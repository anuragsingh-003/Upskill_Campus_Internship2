package FullStack;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.util.Random;
public class Device_Code {

        private static final String BROKER = "<your-iot-endpoint>";
        private static final String CLIENT_ID = "myIoTDevice";
        private static final String TOPIC = "temperature";

        public static void main(String[] args) {
            String publisherId = CLIENT_ID + "_publisher";
            String broker = "ssl://" + BROKER + ":8883";

            MemoryPersistence persistence = new MemoryPersistence();

            try {
                MqttClient client = new MqttClient(broker, publisherId, persistence);

                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);

                System.out.println("Connecting to broker: " + broker);
                client.connect(connOpts);
                System.out.println("Connected");

                while (true) {
                    double temperature = generateTemperature();
                    String content = "{\"device_id\": \"" + CLIENT_ID + "\", \"temperature\": " + temperature + "}";
                    MqttMessage message = new MqttMessage(content.getBytes());
                    message.setQos(1);

                    System.out.println("Publishing message: " + content);
                    client.publish(TOPIC, message);
                    System.out.println("Message published");

                    Thread.sleep(5000); // Wait for 5 seconds before publishing next data
                }

            } catch (MqttException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static double generateTemperature() {
            Random rand = new Random();
            return 20 + rand.nextDouble() * 10; // Generate temperature between 20°C and 30°C
        }


}

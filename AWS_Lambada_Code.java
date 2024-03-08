package FullStack;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
public class AWS_Lambada {


    class TemperatureProcessor implements RequestHandler<TemperatureEvent, String> {

        @Override
        public String handleRequest(TemperatureEvent event, Context context) {
            System.out.println("Incoming data: " + event.toString());

            // Process data (e.g., store in a database, trigger other actions)
            // Here, we'll just print the temperature value
            double temperature = event.getTemperature();
            System.out.println("Temperature: " + temperature + "°C");

            // Return a response (optional)
            return "Data processed successfully";
        }
    }

}

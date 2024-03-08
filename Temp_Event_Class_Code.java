package FullStack;

public class Temp_Event_Class {

        private String device_id;
        private double temperature;

        // getters and setters
        // Note: You can generate getters and setters using IDE or manually write them
        // depending on your preference

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return "TemperatureEvent{" +
                    "device_id='" + device_id + '\'' +
                    ", temperature=" + temperature +
                    '}';
        }


}

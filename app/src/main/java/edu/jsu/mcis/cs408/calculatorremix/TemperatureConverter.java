package edu.jsu.mcis.cs408.calculatorremix;

public class TemperatureConverter {
    public static String fahrenheitToCelsius (double f) {
        return String.valueOf(((f - 32) * 5) / 9);
    }

    public static String celsiusToFahrenheit (double c) {
        return String.valueOf((c * (9/5.0)) + 32);
    }
}

import java.util.Scanner;

/**
 * The TemperatureConversion program implements an application that simply
 * convert between temperatures.
 *
 * @author Lior Kashanovsky
 * @version Maman 11.2
 */
public class Temperature {

    public static void main(String[] args) {
        /* Constants & Variables */
        final char F = 'F';
        final char C = 'C';
        final char K = 'K';
        final double KELVIN_CELSIUS_CONVERSION = 273.15;
        final double CELSIUS_FAHRENHEIT_NINE_FIVE = 9.0 / 5.0;
        final double CELSIUS_FAHRENHEIT_THIRTY_TWO = 32.0;
        double degreeInCelsius = 0;
        double degreeInFahrenheit = 0;
        double degreeInKelvin = 0;

        // Main Method
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Temperature: ");
        String units = scan.next(); // unit type (C/F/K)
        char unit = units.charAt(0); // unit type (C/F/K)
        double degree = scan.nextDouble(); // number of degrees

        /*
         * Formulas:
         * T(°F) = T(°C) × ⁹⁄₅ + 32
         * T(°C) = (T(°F) - 32) / ⁹⁄₅
         * T(K) = T(°C) + 273.15
         */
        switch (unit) {
            case C:
                degreeInCelsius = degree;
                degreeInFahrenheit = (degree * CELSIUS_FAHRENHEIT_NINE_FIVE) + CELSIUS_FAHRENHEIT_THIRTY_TWO;
                degreeInKelvin = degreeInCelsius + KELVIN_CELSIUS_CONVERSION;
                break;
            case F:
                degreeInFahrenheit = degree;
                degreeInCelsius = (degreeInFahrenheit - CELSIUS_FAHRENHEIT_THIRTY_TWO) / (CELSIUS_FAHRENHEIT_NINE_FIVE);
                degreeInKelvin = degreeInCelsius + KELVIN_CELSIUS_CONVERSION;
                break;
            case K:
                degreeInKelvin = degree;
                degreeInCelsius = degree - KELVIN_CELSIUS_CONVERSION;
                degreeInFahrenheit = (degreeInCelsius * CELSIUS_FAHRENHEIT_NINE_FIVE) + CELSIUS_FAHRENHEIT_THIRTY_TWO;
                break;
            default:
                break;
        }

        /*
         * `printf` is a convenience method to write a formatted string.
         *  %f is a format specifier for decimal floating point numbers.
         * \n - line feed.
         */
        System.out.printf("%.2f %c \n%.2f %c \n%.2f %c \n", degreeInCelsius, C, degreeInFahrenheit, F, degreeInKelvin,
                K);
        scan.close();
    }
}

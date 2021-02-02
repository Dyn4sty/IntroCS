
import java.util.Scanner;

/**
 * A program that calculates and print the radius, area and perimeter of
 * inner-circle and outer-circle based on given coordinates of a rectangle.
 *
 * @author Lior Kashanovsky
 * @version Maman 11.1
 */
public class Circle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("this program calculates the areas and the perimeters of the "
                + "excircle and the incircle of a given rectangle");
        System.out.print("Please enter the 2 coordinates of the " + "left-upper point of the rectangle: ");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();
        System.out.print("Please enter the 2 coordinates of the " + "right-bottom point of the rectangle: ");
        int rightBottomX = scan.nextInt();
        int rightBottomY = scan.nextInt();

        /*
         * Calculating the Height & Width of the rectangle.
         */
        int rectangleHeight = leftUpY - rightBottomY;
        int rectangleWidth = rightBottomX - leftUpX;

        /*
         * --Circle Calculations--
         * Formulas:
         *
         * Area = π × R^2 perimeter
         * Perimeter = 2 × π × R
         *
         */
        double inCircleRadius = rectangleHeight / 2; // The Rectangle's height is also the incircle's diameter.
        // We divide the diameter by 2 to get the radius.
        double inCircleArea = Math.PI * Math.pow(inCircleRadius, 2); // Calculates the area according to the formula
        double inCirclePerimeter = 2 * Math.PI * inCircleRadius; // Calculates the Perimeter according to the formula

        // exCircle Calculations //
        double exCircleRadius = Math.sqrt(Math.pow(rectangleHeight, 2) + Math.pow(rectangleWidth, 2)) / 2; // The Rectangle's diagonal is also the excircle's diameter.
        // We divide the diameter by 2 to get the radius.
        double exCirclePerimeter = 2 * Math.PI * exCircleRadius; // Calculates the perimeter based of the formula.
        double exCircleArea = Math.PI * Math.pow(exCircleRadius, 2);  // Calculates the area according to the formula.

        /*
         * stdout `printf` is a convenience method to write a formatted string, %f is a
         * format specifier for decimal floating point numbers.
         */
        System.out.printf("Incircle: radius = %f, area = %f, perimeter = %f \n", inCircleRadius,
                inCircleArea, inCirclePerimeter);
        System.out.printf("Excircle: radius = %f, area = %f, perimeter = %f \n", exCircleRadius,
                exCircleArea, exCirclePerimeter);
        // Closing the IO handler.
        scan.close();

    } // end of main method
} // end of class Circle
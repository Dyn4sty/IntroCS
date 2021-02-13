
/**
 * Represents 2 dimensional points.
 *
 * @author Lior Kashanovsky
 * @version Maman 12.1
 */

public class Point {
    private final int DEFAULT_COORDINATE_VALUE = 0;
    private final int POW_OF_TWO = 2;
    private final double ROUND_NUM = 10000.0;
    private final double PI_IN_DEG = 180.0;
    private final double ALPHA_DEFAULT_VALUE_IN_DEG = 90.0;
    private double _alpha;
    private double _radius;

    /* ***********************************************************************************
     *                              Constructors
     ***********************************************************************************/


    /**
     * Constructor for objects of class Point. Construct a new point with the specified x y coordinates.
     * If the x coordinate is negative it is set to DEFAULT_COORDINATE_VALUE. If the y coordinate is negative it is set to DEFAULT_COORDINATE_VALUE.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point(double x, double y) {
        x = x > DEFAULT_COORDINATE_VALUE ? x : DEFAULT_COORDINATE_VALUE;
        y = y > DEFAULT_COORDINATE_VALUE ? y : DEFAULT_COORDINATE_VALUE;
        this._radius = this.toRadius(x, y);
        this._alpha = this.toAlpha(x, y);
    }

    /**
     * Constructor for objects of class Point. Copy constructor, construct a point using another point.
     *
     * @param other is point from which to construct the new object
     */

    public Point(Point other) {
        this._alpha = other._alpha;
        this._radius = other._radius;
    }

    /* ***********************************************************************************
     *                              Utility Methods
     ***********************************************************************************/

    /**
     * Converts an angle measured in degrees to an approximately
     * equivalent angle measured in radians.
     *
     * @param alpha an angle, in degrees
     * @return the measurement of the angle {@code alpha}
     * in radians.
     */
    private double toRadians(double alpha) {
        return alpha * Math.PI / PI_IN_DEG;
    }

    /**
     * This method returns the Radius coordinate of the point.
     *
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     * @return The radius of the point.
     */
    private double toRadius(double x, double y) {
        // Calculating the radius using the Pythagorean theorem.
        return Math.sqrt(Math.pow(x, POW_OF_TWO) + Math.pow(y, POW_OF_TWO));
    }

    /**
     * <h3>Utility Method to convert x & y values to an angle in radians (The Math class expect to get alpha in radians) </h3>.
     * <b>Formula</b>:
     * <p>
     * alpha(deg) = alpha(rad) × 180.0 / Math.PI
     *
     * @param x The x coordinate of the point. if x is 0 then alpha is equal to 90 deg.
     * @param y The y coordinate of the point
     * @return an angle, in radians.
     */
    private double toAlpha(double x, double y) {

        if (x == DEFAULT_COORDINATE_VALUE) {
            return ALPHA_DEFAULT_VALUE_IN_DEG;
        }
        // Returning alpha in degrees.
        return Math.atan(y / x) * PI_IN_DEG / Math.PI;
    }

    /**
     * This method Convert the radius and alpha to the x coordinate of the point.
     *
     * @param radius The radius of the point
     * @param alpha  The angle (in degrees) of the point.
     * @return x coordinate of the point
     */
    private double toX(double radius, double alpha) {
        // Revert the radius & alpha back to X value;
        // The Math.cos function expect alpha in radians, so we convert it.
        // We are rounding to avoid floating point comparison errors.
        return Math.round(radius * Math.cos(toRadians(alpha)) * ROUND_NUM) / ROUND_NUM;
    }

    /**
     * This method Convert the radius and alpha to the y coordinate of the point.
     *
     * @param radius The radius of the point
     * @param alpha  The angle, in degrees. of the point
     * @return y coordinate of the point
     */
    private double toY(double radius, double alpha) {
        // Revert the radius & alpha back to y value
        // The Math.sin function expect alpha in radians, so we convert it.
        // We are rounding to avoid floating point comparison errors.
        return Math.round(radius * Math.sin(toRadians(alpha)) * ROUND_NUM) / ROUND_NUM;
    }

    /* ***********************************************************************************
     *                              Getters & Setters
     ***********************************************************************************/

    /**
     * This method returns the x coordinate of the point.
     */
    public double getX() {
        return this.toX(_radius, _alpha);
    }

    /**
     * This method sets the x coordinate of the point.
     * If the new x coordinate is negative the old x coordinate will remain unchanged.
     *
     * @param x The new x coordinate
     */
    public void setX(double x) {
        if (x >= DEFAULT_COORDINATE_VALUE) {
            double y = toY(this._radius, this._alpha);
            this._alpha = toAlpha(x, y);
            this._radius = toRadius(x, y);
        }
    }

    /**
     * This method returns the y coordinate of the point.
     */
    public double getY() {
        return this.toY(this._radius, this._alpha);
    }

    /**
     * This method sets the y coordinate of the point.
     * If the new y coordinate is negative the old y coordinate will remain unchanged.
     *
     * @param y The new y coordinate
     */
    public void setY(double y) {
        if (y >= DEFAULT_COORDINATE_VALUE) {
            double x = toX(this._radius, this._alpha);
            this._alpha = toAlpha(x, y);
            this._radius = toRadius(x, y);
        }

    }
    /* ***********************************************************************************
     *                              Methods
     ***********************************************************************************/

    /**
     * Returns a string representation of Point in the format (x,y).
     *
     * @return A String representation of the Point
     */
    @Override
    public String toString() {
        return String.format("(%.1f,%.1f)", toX(_radius, _alpha), toY(_radius, _alpha));
    }

    /**
     * Check if the given point is equal to this point.
     *
     * @param other The point to check equality with.
     * @return True if the given point is equal to this point
     */
    public boolean equals(Point other) {
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

    /**
     * Check if this point is above a received point.
     *
     * @param other The point to check if this point is above.
     * @return True if this point is above the other point
     */
    public boolean isAbove(Point other) {
        return (this.getY() > other.getY());
    }

    /**
     * Check if this point is below a received point.
     *
     * @param other The point to check if this point is below.
     * @return True if this point is below the other point.
     * #this function utilize the isAbove() method.
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Check if this point is left of a received point.
     *
     * @param other The point to check if this point is left of.
     * @return True if this point is left of the other point.
     */
    public boolean isLeft(Point other) {
        return this.getX() < other.getX();
    }

    /**
     * Check if this point is below a received point.
     *
     * @param other The point to check if this point is right of.
     * @return True if this point is right of the other point.
     * #this function utilize the isLeft() method.
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * Check the distance between this point and a given point.
     *
     * @param other - The point to check the distance from.
     * @return The distance.
     */
    public double distance(Point other) {
        double x = getX();
        double y = getY();
        double otherX = other.getX();
        double otherY = other.getY();
        return Math.sqrt(Math.pow(y - otherY, POW_OF_TWO) + Math.pow(x - otherX, POW_OF_TWO));
    }

    /**
     * Moves a point.
     *
     * @param dx The difference to add to x
     * @param dy The difference to add to y
     */
    public void move(double dx, double dy) {
        double x = this.getX() + dx;
        double y = this.getY() + dy;
        if (x >= DEFAULT_COORDINATE_VALUE && y >= DEFAULT_COORDINATE_VALUE) {
            this._radius = this.toRadius(x, y);
            this._alpha = this.toAlpha(x, y);
        }
    }

} // end of class Point


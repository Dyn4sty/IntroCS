
/**
 * Segment2 represents a line (parallel to the x-axis) using a center point and length.
 *
 * @author Lior Kashanovsky
 * @version Maman 12.2
 */
public class Segment2 {
    private final int DEFAULT_COORDINATE_VALUE = 0;
    private Point _poCenter;
    private double _length;


    /* ***********************************************************************************
     *                              Constructors
     ***********************************************************************************/

    /**
     * Constructs a new segment using 4 specified x y coordinates: Two coordinates for the left point and two coordinates for the right point.
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     *
     * @param leftX  X value of left point
     * @param leftY  Y value of left point
     * @param rightX X value of right point
     * @param rightY Y value of right point
     */
    public Segment2(double leftX, double leftY,
                    double rightX, double rightY) {
        this._poCenter = this.toPoCenter(leftX, rightX, leftY);
        this._length = this.toLength(leftX, rightX);
    }

    /**
     * Constructs a new segment using two Points.
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     *
     * @param left  the left point of the segment
     * @param right the right point of the segment
     */
    public Segment2(Point left, Point right) {
        this(left.getX(), left.getY(), right.getX(), right.getY());
    }

    /**
     * Constructs a new segment using a center point and the segment length.
     *
     * @param poCenter - the Center Point
     * @param length   - the segment length
     */
    Segment2(Point poCenter, double length) {
        this((poCenter.getX() * 2 - length) / 2, poCenter.getY(), (poCenter.getX() * 2 + length) / 2, poCenter.getY());
    }

    /**
     * Copy Constructor. Construct a segment using a reference segment.
     *
     * @param other the reference segment
     */
    public Segment2(Segment2 other) {
        this(other._poCenter, other._length);
    }

    /* ***********************************************************************************
     *                              Utility Methods
     ***********************************************************************************/


    private Point toPoLeft(Point poCenter, double length) {
        return new Point((poCenter.getX() * 2 - length) / 2, poCenter.getY());
    }

    private Point toPoRight(Point poCenter, double length) {
        return new Point((poCenter.getX() * 2 + length) / 2, poCenter.getY());
    }

    private Point toPoCenter(double leftX, double rightX, double y) {
        return new Point((leftX + rightX) / 2, y);
    }

    private double toLength(double leftX, double rightX) {
        if (leftX < DEFAULT_COORDINATE_VALUE || rightX < DEFAULT_COORDINATE_VALUE) {
            return DEFAULT_COORDINATE_VALUE;
        }
        return rightX - leftX;
    }

    /* ***********************************************************************************
     *                              Getters
     ***********************************************************************************/

    /**
     * Returns the left point of the segment.
     *
     * @return Point  The left point of the segment
     */
    public Point getPoLeft() {
        return toPoLeft(_poCenter, _length);
    }

    /**
     * Returns the right point of the segment.
     *
     * @return Point  The right point of the segment
     */
    public Point getPoRight() {
        return toPoRight(_poCenter, _length);
    }

    /**
     * Returns the segment length.
     */
    public double getLength() {
        return this._length;
    }

    /* ***********************************************************************************
     *                              Methods
     ***********************************************************************************/

    /**
     * Check if the reference segment is equal to this segment.
     *
     * @param other the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other) {
        return getPoRight().equals(other.getPoRight()) && getPoLeft().equals(other.getPoLeft());
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     *
     * @return String representation of this segment
     */

    @Override
    public String toString() {
        return String.format("%s---%s", getPoLeft(), getPoRight());
    }

    /**
     * Check if this segment is above a reference segment.
     *
     * @param other - the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other) {
        return getPoLeft().isAbove(other.getPoLeft());
    }

    /**
     * Check if this segment is under a reference segment.
     *
     * @param other - the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     *
     * @param other - the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment2 other) {
        return this.getPoRight().isLeft(other.getPoLeft());
    }

    /**
     * Check if this segment is right of a received segment.
     *
     * @param other - the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment2 other) {
        return other.isLeft(this);
    }

    /**
     * Move the segment horizontally by delta.
     *
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        Point poLeft = getPoLeft();
        double leftX = poLeft.getX() + delta;
        if (leftX >= DEFAULT_COORDINATE_VALUE) {
            double rightX = getPoRight().getX() + delta;
            this._poCenter = toPoCenter(leftX, rightX, poLeft.getY());
            this._length = toLength(leftX, rightX);
        }
    }

    /**
     * Move the segment vertically by delta.
     *
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        double y = _poCenter.getY() + delta;
        if (y >= DEFAULT_COORDINATE_VALUE) {
            this._poCenter.setY(y);
        }
    }

    /**
     * Change the segment size by moving the right point by delta.
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     *
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        Point poRight = getPoRight();
        double rightX = poRight.getX() + delta;
        double leftX = getPoLeft().getX();
        if (rightX > leftX) {
            this._poCenter = this.toPoCenter(leftX, rightX, this._poCenter.getY());
            this._length = this.toLength(leftX, rightX);
        }

    }

    /**
     * Check if a point is located on the segment.
     *
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        double pointY = p.getY();
        double pointX = p.getX();
        Point poLeft = getPoLeft();
        // Checks whether the given point has the same Y value, and whether the X value between or on the left and right points.
        return (pointY == poLeft.getY()) &&
                (poLeft.getX() <= pointX && pointX <= getPoRight().getX());
    }

    /**
     * Check if this segment is bigger than a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment2 other) {
        return this.getLength() > other.getLength();
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     *
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap(Segment2 other) {
        double thisRightX = this.getPoRight().getX();
        double thisLeftX = this.getPoLeft().getX();
        double otherRightX = other.getPoRight().getX();
        double otherLeftX = other.getPoLeft().getX();
        if (thisRightX < otherLeftX)
            return 0;
        if (thisRightX >= otherRightX && thisLeftX > otherLeftX) {
            return otherRightX - thisLeftX;
        }
        return thisRightX - otherLeftX;
    }

    /**
     * <h3>Compute the trapeze perimeter, which is constructed by this segment and a reference segment. </h3>
     *
     * <b>Formula</b>:
     * <p>
     * Perimeter = Upper base + Lower base + Right leg + Left leg
     * <br>
     * (Sum of all of the sides).
     *
     * @param other - the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment2 other) {
        return (this.getLength() + other.getLength() + getPoLeft().distance(other.getPoLeft()) + getPoRight().distance(other.getPoRight()));
    }
}


/**
 * Segment1 represents a line (parallel to the x-axis) using two Points.
 *
 * @author Lior Kashanovsky
 * @version Maman 12.2
 */

public class Segment1 {
    private final int DEFAULT_COORDINATE_VALUE = 0;
    private Point _poLeft;
    private Point _poRight;

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
    public Segment1(double leftX, double leftY,
                    double rightX, double rightY) {
//        this(new Point(leftX, leftY), new Point(rightX, rightY));
        if (leftY != rightY) {
            rightY = leftY;
        }
        this._poLeft = new Point(leftX, leftY);
        this._poRight = new Point(rightX, rightY);
    }

    /**
     * Constructs a new segment using two Points.
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     *
     * @param left  the left point of the segment
     * @param right the right point of the segment
     */
    public Segment1(Point left, Point right) {
        this(left.getX(), left.getY(), right.getX(), right.getY());
    }


    /**
     * Copy Constructor. Construct a segment using a reference segment.
     *
     * @param other the reference segment
     */
    public Segment1(Segment1 other) {
        this(other._poLeft, other._poRight);
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
        return new Point(_poLeft);
    }

    /**
     * Returns the right point of the segment.
     *
     * @return Point  The right point of the segment
     */
    public Point getPoRight() {
        return new Point(_poRight);
    }

    /**
     * Returns the segment length.
     */
    public double getLength() {
        return _poLeft.distance(_poRight);
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
    public boolean equals(Segment1 other) {
        return this._poRight.equals(other._poRight) && this._poLeft.equals(other._poLeft);
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     *
     * @return String representation of this segment
     */
    @Override
    public String toString() {
        return String.format("%s---%s", _poLeft, _poRight);
    }

    /**
     * Check if this segment is above a reference segment.
     *
     * @param other - the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other) {
        return this._poLeft.isAbove(other._poLeft);
    }

    /**
     * Check if this segment is under a reference segment.
     *
     * @param other - the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     *
     * @param other - the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment1 other) {
        return this._poRight.isLeft(other._poLeft);
    }

    /**
     * Check if this segment is right of a received segment.
     *
     * @param other - the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment1 other) {
        return other.isLeft(this);
    }

    /**
     * Move the segment horizontally by delta.
     *
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        double leftX = this._poLeft.getX() + delta;
        if (leftX >= DEFAULT_COORDINATE_VALUE) {
            this._poLeft.setX(leftX);
            this._poRight.setX(this._poRight.getX() + delta);
        }
    }

    /**
     * Move the segment vertically by delta.
     *
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        double y = this._poLeft.getY() + delta;
        if (y >= DEFAULT_COORDINATE_VALUE) {
            this._poLeft.setY(y);
            this._poRight.setY(y);
        }
    }

    /**
     * Change the segment size by moving the right point by delta.
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     *
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        double rightX = _poRight.getX() + delta;
        if (rightX > this._poLeft.getX()) {
            this._poRight.setX(rightX);
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

        return (pointY == this._poLeft.getY()) &&
                (this._poLeft.getX() <= pointX && pointX <= this._poRight.getX());
    }

    /**
     * Check if this segment is bigger than a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment1 other) {
        return this.getLength() > other.getLength();
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     *
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap(Segment1 other) {
        double thisRightX = this._poRight.getX();
        double thisLeftX = this._poLeft.getX();
        double otherRightX = other._poRight.getX();
        double otherLeftX = other._poLeft.getX();

        // no overlap
        if (thisRightX < otherLeftX)
            return 0;

        else if (thisRightX >= otherRightX && thisLeftX > otherLeftX) {
            return otherRightX - thisLeftX;
        }
        return thisRightX - otherLeftX;
    }

    /**
     * <h3>Compute the trapeze perimeter, which is constructed by this segment and a reference segment. </h3>
     *
     * <b>Formula</b>:
     * <p>
     * Perimeter = Upper base + Lower base + Right Side + Left Side
     * <br>
     * (Sum of all of the sides).
     *
     * @param other - the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment1 other) {

        return (this.getLength() + other.getLength() + this._poLeft.distance(other._poLeft) + this._poRight.distance(other._poRight));
    }
}

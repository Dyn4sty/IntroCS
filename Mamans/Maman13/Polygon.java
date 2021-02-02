
/**
 * Represents a convex polygon in a plane.
 *
 * @author Lior Kashanovsky
 * @version Maman 13
 */

public class Polygon {
    private final int MAX_VERTICES = 10;
    private final Point[] _vertices;
    private int _noOfVertices;

    /* ***********************************************************************************
     *                              Constructors
     ***********************************************************************************/

    /**
     * Empty Constructor for objects of class Polygon.
     * Construct a new Polygon with the maximum array size of vertices.
     */
    public Polygon() {
        _vertices = new Point[MAX_VERTICES];
    }

    /* ***********************************************************************************
     *                              Methods
     ***********************************************************************************/

    /**
     * Adds a vertex to a {@code Polygon} if it has no more than 10 vertices
     *
     * @param x The x coordinate of the vertex
     * @param y The y coordinate of the vertex
     * @return true if it has no more than 10 vertices, otherwise false.
     */
    public boolean addVertex(double x, double y) {
        if (_noOfVertices == MAX_VERTICES)
            return false;
        _vertices[_noOfVertices++] = new Point(x, y);
        return true;

    }

    /**
     * Find the highest vertex in the {@code Polygon}.
     *
     * @return the highest {@link Point} or null if not exists.
     */
    public Point highestVertex() {
        if (_noOfVertices == 0) {
            return null;
        }
        Point max = _vertices[0];
        for (int i = 1; i < _noOfVertices; i++) {
            if (_vertices[i].getY() > max.getY()) {
                max = _vertices[i];
            }
        }
        return new Point(max);
    }

    /**
     * Compute the {@code Polygon} perimeter, which is constructed by adding the lengths of its sides.
     * (the sum of all sides).
     *
     * @return The polygon's perimeter.
     */
    public double calcPerimeter() {
        // no Sides.
        if (_noOfVertices <= 1) {
            return 0;
        }
        if (_noOfVertices == 2) {
            // adding the 1st && 2nd sides.
            return _vertices[0].distance(_vertices[1]);
        }
        double perimeter = 0;
        for (int i = 0; i < _noOfVertices; i++) {
            // if we reached the end
            if (i == _noOfVertices - 1)
                // adding the first && last sides.
                perimeter += _vertices[i].distance(_vertices[0]);
            else
                perimeter += _vertices[i].distance(_vertices[i + 1]);
        }
        return perimeter;
    }


    /**
     * Calculates the area of a {@code Polygon} by each inner triangle's area. <br>
     * It calculates the area of a triangle whose sides have lengths a, b, and c by the Heron's formula: <br>
     * area = \u221A(s(s-a)(s-b)(s-c)) <br>
     * where s = (a+b+c) / 2
     *
     * @return area - The {@link Polygon}'s area.
     */
    public double calcArea() {
        if (_noOfVertices < 3) {
            return 0;
        }
        double area = 0;
        for (int i = 1; i < _noOfVertices - 1; i++) {
            // Calculating each inner-triangle area.
            double a = _vertices[0].distance(_vertices[i]);
            double b = _vertices[0].distance(_vertices[i + 1]);
            double c = _vertices[i].distance(_vertices[i + 1]);
            double s = (a + b + c) / 2; // the semi-perimeter of the triangle.
            area += Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula.
        }
        return area;
    }

    /**
     * Check if this polygon is bigger than a reference {@code Polygon}.
     *
     * @param other The reference {@link Polygon}
     * @return True if this {@code Polygon} is bigger than the reference {@code Polygon}
     */
    public boolean isBigger(Polygon other) {
        return this.calcArea() > other.calcArea();
    }

    /**
     * Checks whether the received point is the vertex of the polygon. <br>
     * returning the index of the first occurrence of the point <br>
     * or -1 if the Point is not a vertex of the polygon.
     *
     * @param p A {@link Point} to find..
     * @return index - the vertex index.
     */
    public int findVertex(Point p) {
        for (int i = 0; i < _noOfVertices; i++)
            if (p.equals(_vertices[i]))
                return i;
        // No Vertex.
        return -1;
    }

    /**
     * Get the next vertex in polygon by {@link Point}, or:
     * <ul>
     * <li>The same point if its the only point in the polygon. </li>
     * <li>The first vertex if its the point is the last vertex. </li>
     * <li>null if the point is not a vertex in the polygon. </li>
     * </ul>
     *
     * @param p A {@link Point} to find.
     * @return Vertex that checks one of the conditions, or null.
     */
    public Point getNextVertex(Point p) {
        Point result;
        int i = findVertex(p);
        if (i == -1) {
            result = null;
        } else if (i == _noOfVertices - 1) {
            result = new Point(_vertices[0]);
        } else {
            result = new Point(_vertices[i + 1]);
        }
        return result;
    }

    /**
     * Gets the bounding box of this {@code Polygon}.
     *
     * @return a Rectangle({@link Polygon} object) that defines the bounds of this Polygon.
     */
    public Polygon getBoundingBox() {
        if (_noOfVertices < 3) {
            return null;
        }
        /* Getting the min & max of x & y */
        // starting out with smallest set to Integer.MAX_VALUE and largest set to Integer.MIN_VALUE
        // to prevent edge cases.
        double minX = Integer.MAX_VALUE,
                maxX = Integer.MIN_VALUE,
                minY = Integer.MAX_VALUE,
                maxY = Integer.MIN_VALUE;

        for (int i = 0; i < _noOfVertices; i++) {
            double currentX = _vertices[i].getX();
            double currentY = _vertices[i].getY();

            minX = Math.min(minX, currentX);
            maxX = Math.max(maxX, currentX);
            minY = Math.min(minY, currentY);
            maxY = Math.max(maxY, currentY);
        }

        /* Creating new Polygon */
        Polygon boundingBox = new Polygon();
        boundingBox.addVertex(minX, minY); // Lower left
        boundingBox.addVertex(maxX, minY); // Lower right
        boundingBox.addVertex(maxX, maxY); // top right
        boundingBox.addVertex(minX, maxY); // top left
        return boundingBox; /* -> (minX, maxY)                 (maxX, maxY)
                                    +----------------------------+
                                    |                            |
                                    |                            |
                                    +----------------------------+
                                  (minX,minY)                  (maxX, minY)
                            */
    }

    /**
     * Returns a string representation of {@code Polygon} in the format ((x,y), (a,b), ...).
     *
     * @return A String representation of the {@link Polygon}
     */
    @Override
    public String toString() {
        if (_noOfVertices == 0)
            return "The polygon has 0 vertices.";
        StringBuilder polygonRepr = new StringBuilder(_vertices[0].toString());
        for (int i = 1; i < _noOfVertices; i++) {
            polygonRepr.append(',').append(_vertices[i]);
        }
        return String.format("The polygon has %d vertices:\n(%s)", _noOfVertices, polygonRepr);

    }
} // end of class Polygon




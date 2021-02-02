
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tester for Polygon.java - Mmn13 into to CS and Java - 2021a
 * @author Ori Ben Nun
 * @version 5/12/2020
 */
class PolygonTest {

    Polygon defaultPolygon = new Polygon();
    Polygon defaultPolygon2 = new Polygon();

    @BeforeEach
    void setUp() {
        defaultPolygon.addVertex(2, 1);
        defaultPolygon.addVertex(5, 0);
        defaultPolygon.addVertex(6, 2);
        defaultPolygon.addVertex(6.5, 3);
        defaultPolygon.addVertex(7, 5);
        defaultPolygon.addVertex(6, 6);
        defaultPolygon.addVertex(4, 6);
        defaultPolygon.addVertex(2, 5.5);
        defaultPolygon.addVertex(1, 4);
        defaultPolygon.addVertex(1, 2);

        defaultPolygon2.addVertex(2,1);
        defaultPolygon2.addVertex(3,1);
        defaultPolygon2.addVertex(4,3);
        defaultPolygon2.addVertex(3,4);
        defaultPolygon2.addVertex(1,3);
    }

    @Test
    void addVertex() {
        assertEquals(false, defaultPolygon.addVertex(1,5));

        Polygon polygon1 = new Polygon();
        assertEquals(true, polygon1.addVertex(2, 1));
        polygon1.addVertex(5, 0);
        polygon1.addVertex(6, 2);
        assertEquals(true, polygon1.addVertex(6.5, 3));
        polygon1.addVertex(7, 5);
        polygon1.addVertex(6, 6);
        polygon1.addVertex(4, 6);
        polygon1.addVertex(2, 5.5);
        polygon1.addVertex(1, 4);
        assertEquals(true, polygon1.addVertex(1, 2));
        assertEquals(false, polygon1.addVertex(1, 2));
        assertEquals(false, polygon1.addVertex(1, 2));
        assertEquals(false, polygon1.addVertex(1, 2));
    }

    @Test
    void highestVertex() {
        Point highestDefPoint = new Point(6, 6);
        Point highestDefPoint2 = new Point(4, 6);
        Point highestPoint1 = defaultPolygon.highestVertex();
        assertEquals(true, highestDefPoint.equals(highestPoint1));
        assertEquals(false, highestPoint1.equals(highestDefPoint2));

        highestDefPoint2.move(2,0);
        assertEquals(true, highestPoint1.equals(highestDefPoint2));

        highestDefPoint2.move(2,0);
        assertEquals(false, highestPoint1.equals(highestDefPoint2));

        Polygon polygon1 = new Polygon();
        assertEquals(null, polygon1.highestVertex());

        Point point1 = new Point(6, 2);
        polygon1.addVertex(6, 2);

        assertEquals(true, polygon1.highestVertex().equals(point1));

        Point point2 = new Point(6.5, 3);
        assertEquals(true, polygon1.addVertex(6.5, 3));
        assertEquals(false, polygon1.highestVertex().equals(point1));
        assertEquals(true, polygon1.highestVertex().equals(point2));

        assertEquals(true, polygon1.addVertex(2, 1));
        assertEquals(true, polygon1.highestVertex().equals(point2));

        assertEquals(true, polygon1.addVertex(2, 10));
        assertEquals(false, polygon1.highestVertex().equals(point2));

    }

    @Test
    void testToString() {
        String desiredStr = "The polygon has 5 vertices:\n" +
                "((2.0,1.0),(5.0,0.0),(7.0,5.0),(4.0,6.0),(1.0,4.0))";
        Polygon polygon = new Polygon();
        polygon.addVertex(2, 1);
        polygon.addVertex(5, 0);
        polygon.addVertex(7, 5);
        polygon.addVertex(4, 6);
        polygon.addVertex(1, 4);


        assertEquals(true, desiredStr.equals(polygon.toString()));

        polygon.addVertex(2, 5.5);
        assertEquals(false, desiredStr.equals(polygon.toString()));

        Polygon polygon2 = new Polygon();

        String noVerticesStr = "The polygon has 0 vertices.";
        assertEquals(false, noVerticesStr.equals(polygon.toString()));
        assertEquals(true, noVerticesStr.equals(polygon2.toString()));


        polygon2.addVertex(2, 1);
        polygon2.addVertex(5, 0);
        polygon2.addVertex(6, 2);
        polygon2.addVertex(6.5, 3);
        polygon2.addVertex(7, 5);
        polygon2.addVertex(6, 6);
        polygon2.addVertex(4, 6);
        polygon2.addVertex(2, 5.5);
        polygon2.addVertex(1, 4);
        polygon2.addVertex(1, 2);

        assertEquals(true, polygon2.toString().equals(defaultPolygon.toString()));
        assertEquals(false, desiredStr.equals(polygon2.toString()));

        Polygon polygon3 = new Polygon();
        polygon3.addVertex(2, 1);
        polygon3.addVertex(5, 0);
        polygon3.addVertex(6, 2);
        polygon3.addVertex(6.5, 3);
        polygon3.addVertex(7, 5);
        polygon3.addVertex(6, 6);
        polygon3.addVertex(4, 6);
        polygon3.addVertex(2, 5.5);
        polygon3.addVertex(1, 4);
        polygon3.addVertex(1, 2);

        assertEquals(true, polygon2.toString().equals(polygon3.toString()));

        polygon2.addVertex(1,100);

        assertEquals(true, polygon3.toString().equals(polygon2.toString()));

        Polygon polygon4 = new Polygon();
        polygon4.addVertex(2, 1);
        polygon4.addVertex(5, 0);
        polygon4.addVertex(6, 2);
        polygon4.addVertex(6.5, 3);
        polygon4.addVertex(7, 5);
        polygon4.addVertex(1, 4);
        polygon4.addVertex(6, 6);
        polygon4.addVertex(4, 6);
        polygon4.addVertex(2, 5.5);
        polygon4.addVertex(1, 2);

        assertEquals(false, polygon3.toString().equals(polygon4.toString()));

        Polygon polygon5 = new Polygon();
        polygon5.addVertex(2, 1);
        polygon5.addVertex(5, 0);
        polygon5.addVertex(6, 2);
        polygon5.addVertex(6.5, 3);
        polygon5.addVertex(7, 5);
        polygon5.addVertex(1, 4);
        polygon5.addVertex(6, 6);
        polygon5.addVertex(4, 6);
        polygon5.addVertex(2, 5.5);

        assertEquals(false, polygon4.toString().equals(polygon5.toString()));

        polygon5.addVertex(1,2);
        assertEquals(true, polygon5.toString().equals(polygon4.toString()));
    }

    @Test
    void calcPerimeter() {

        double periComplex = 1 + Math.sqrt(2) + (Math.sqrt(5) * 3);
        double periSimple = 9.1224;

        assertEquals(periComplex, defaultPolygon2.calcPerimeter(), 0.01);
        assertEquals(periSimple, defaultPolygon2.calcPerimeter(), 0.01);

        assertEquals(false, defaultPolygon2.calcPerimeter() - defaultPolygon.calcPerimeter() == 0);

        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2,1);
        polygon2.addVertex(3,1);
        polygon2.addVertex(4,3);
        polygon2.addVertex(3,4);
        polygon2.addVertex(1,3);

        assertEquals(true, defaultPolygon2.calcPerimeter() - polygon2.calcPerimeter() == 0);
        assertEquals(0, defaultPolygon2.calcPerimeter() - polygon2.calcPerimeter(), 0.01);

        polygon2.addVertex(1, 2);

        assertEquals(false, defaultPolygon2.calcPerimeter() - polygon2.calcPerimeter() == 0);


        Polygon polygon3 = new Polygon();
        assertEquals(0, polygon3.calcPerimeter());

        polygon3.addVertex(2,1);
        assertEquals(0, polygon3.calcPerimeter());

        polygon3.addVertex(3,1);
        assertEquals(1, polygon3.calcPerimeter());

        polygon3.addVertex(4,3);
        assertEquals(1 + Math.sqrt(5) + Math.sqrt(8), polygon3.calcPerimeter());

    }

/*    @Test
    void triangleArea() {
        Point a = new Point(3,1);
        Point b = new Point(4,3);
        Point c = new Point(3,4);
        Polygon polygon = new Polygon();

        assertEquals(1.4996, polygon.triangleArea(a,b,c), 0.01);

        Point d = new Point(1,3);

        assertEquals(2.999, polygon.triangleArea(a,c,d), 0.01);

        Point e = new Point(2,1);

        assertEquals(1, polygon.triangleArea(a,d,e), 0.01);

        polygon.addVertex(a.getX(), a.getY());
        polygon.addVertex(b.getX(), b.getY());
        polygon.addVertex(c.getX(), c.getY());
        polygon.addVertex(d.getX(), d.getY());
        polygon.addVertex(e.getX(), e.getY());

        double expectedArea = polygon.triangleArea(a, b, c) + polygon.triangleArea(a,c,d) + polygon.triangleArea(a,d,e);

        assertEquals(expectedArea, polygon.calcArea(), 0.01);
    }*/


    @Test
    void calcArea() {
        // Using the website https://www.mathopenref.com/coordpolygonareacalc.html

        assertEquals(26.5, defaultPolygon.calcArea(), 0.01);

        Polygon polygon = new Polygon();
        polygon.addVertex(2,1);
        polygon.addVertex(5,0);
        polygon.addVertex(6,2);
        polygon.addVertex(6.5,3);
        polygon.addVertex(7,5);
        polygon.addVertex(6,6);
        polygon.addVertex(4,6);

        assertEquals(18.75, polygon.calcArea(), 0.01);

        Polygon polygon1 = new Polygon();
        assertEquals(0, polygon1.calcArea(), 0.01);

        polygon1.addVertex(2,1);
        assertEquals(0, polygon1.calcArea(), 0.01);

        polygon1.addVertex(5,0);
        assertEquals(0, polygon1.calcArea(), 0.01);

        polygon1.addVertex(6,2);
        assertEquals(3.5, polygon1.calcArea(), 0.01);

        polygon1.addVertex(6.5,4);
        assertEquals(7.25, polygon1.calcArea(), 0.01);

    }

    @Test
    void isBigger() {
        assertEquals(true, defaultPolygon.isBigger(defaultPolygon2));
        assertEquals(false, defaultPolygon2.isBigger(defaultPolygon));
        assertEquals(false, defaultPolygon2.isBigger(defaultPolygon2));

        Polygon polygon3 = new Polygon();
        polygon3.addVertex(2,1);
        polygon3.addVertex(3,1);
        polygon3.addVertex(4,3);
        polygon3.addVertex(3,4);
        polygon3.addVertex(1,3);


        assertEquals(false, polygon3.isBigger(defaultPolygon2));

        polygon3.addVertex(1,1.5);
        assertEquals(true, polygon3.isBigger(defaultPolygon2));

        assertEquals(true, defaultPolygon.isBigger(polygon3));
        assertEquals(false, defaultPolygon2.isBigger(polygon3));

        Polygon polygon4 = new Polygon(), polygon5 = new Polygon();
        assertEquals(false, polygon4.isBigger(polygon5));
        assertEquals(false, polygon5.isBigger(polygon4));

        polygon4.addVertex(2,1);
        polygon4.addVertex(3,1);
        polygon4.addVertex(4,3);
        polygon5.addVertex(2,1);
        polygon5.addVertex(3,1);
        polygon5.addVertex(4,3);
        assertEquals(false, polygon4.isBigger(polygon5));
        assertEquals(false, polygon5.isBigger(polygon4));

        polygon4.addVertex(3,4);
        assertEquals(true, polygon4.isBigger(polygon5));
    }

    @Test
    void findVertex() {
        Point point1 = new Point(2,1);
        Point point2 = new Point(5,0);
        assertEquals(0, defaultPolygon.findVertex(point1));
        assertEquals(1, defaultPolygon.findVertex(point2));

        Point point3 = new Point(5,1);
        assertEquals(-1, defaultPolygon.findVertex(point3));

        Point point4 = new Point(1,2);
        Point point5 = new Point(1,6);
        assertEquals(9, defaultPolygon.findVertex(point4));
        assertEquals(-1, defaultPolygon.findVertex(point5));

        Polygon polygon1 = new Polygon();
        assertEquals(-1, polygon1.findVertex(point1));

        polygon1.addVertex(point1.getX(), point1.getY());
        assertEquals(0, polygon1.findVertex(point1));

        polygon1.addVertex(point2.getX(), point2.getY());
        assertEquals(1, polygon1.findVertex(point2));
    }

    @Test
    void getNextVertex() {
        Point point0 = new Point(2, 1);
        Point point1 = new Point(3, 1);
        Point point2 = new Point(4, 3);
        Point point3 = new Point(3, 4);
        Point point4 = new Point(1, 3);

        assertEquals(true, point1.equals(defaultPolygon2.getNextVertex(point0)));
        assertEquals(true, point2.equals(defaultPolygon2.getNextVertex(point1)));
        assertEquals(true, point3.equals(defaultPolygon2.getNextVertex(point2)));
        assertEquals(true, point4.equals(defaultPolygon2.getNextVertex(point3)));
        assertEquals(true, point0.equals(defaultPolygon2.getNextVertex(point4)));

        Polygon polygon1 = new Polygon();
        assertEquals(null, polygon1.getNextVertex(point0));
        assertEquals(null, polygon1.getNextVertex(point1));

        polygon1.addVertex(point0.getX(), point0.getY());
        assertEquals(true, point0.equals(polygon1.getNextVertex(point0)));
        assertEquals(null, polygon1.getNextVertex(point1));

        polygon1.addVertex(point1.getX(), point1.getY());
        assertEquals(true, point1.equals(polygon1.getNextVertex(point0)));
        assertEquals(true, point0.equals(polygon1.getNextVertex(point1)));

        polygon1.addVertex(point2.getX(), point2.getY());
        assertEquals(true, point1.equals(polygon1.getNextVertex(point0)));
        assertEquals(true, point2.equals(polygon1.getNextVertex(point1)));
        assertEquals(true, point0.equals(polygon1.getNextVertex(point2)));
        assertEquals(null, polygon1.getNextVertex(point3));

        // Checking aliasing
        polygon1.getNextVertex(point0).move(5, 124);
        assertEquals(true, point1.equals(polygon1.getNextVertex(point0)));
    }

    @Test
    void getBoundingBox() {
        Polygon bounding1 = defaultPolygon2.getBoundingBox();
        assertEquals(9, bounding1.calcArea(), 0.01);

        Polygon bounding2 = defaultPolygon.getBoundingBox();
        assertEquals(36, bounding2.calcArea(), 0.01);

        Polygon square = new Polygon();
        square.addVertex(1,1);
        square.addVertex(51,1);
        square.addVertex(51,51);
        square.addVertex(1,51);
        assertEquals(2500, square.calcArea(), 0.01);

        Polygon boxSquare = square.getBoundingBox();
        assertEquals(2500, boxSquare.calcArea(), 0.01);
        assertEquals(true, boxSquare.calcArea() == square.calcArea() &&
                boxSquare.calcPerimeter() == square.calcPerimeter());
    }


    ///
    /// Matan's Tester:
    ///

    @Test
    void polygonTestMatan() {
        Polygon polygon = new Polygon();
        polygon.addVertex(1.0, 0.0);
        polygon.addVertex(3.0, 1.0);
        polygon.addVertex(5.0, 3.0);
        polygon.addVertex(6.0, 4.0);
        polygon.addVertex(7.0, 4.0);
        polygon.addVertex(8.0, 4.0);
        polygon.addVertex(6.0, 4.0);
        polygon.addVertex(4.0, 3.0);
        polygon.addVertex(2.0, 2.0);
        assertEquals(true, polygon.addVertex(1.0, 1.0));
        assertEquals(false, polygon.addVertex(1.0, 1.0));
    }

    @Test
    public void calcPerimeterMatan()
    {
        Polygon polygon1 = new Polygon();
        polygon1.addVertex(1.0, 0.0);
        polygon1.addVertex(3.0, 1.0);
        polygon1.addVertex(5.0, 3.0);
        polygon1.addVertex(6.0, 4.0);
        polygon1.addVertex(7.0, 4.0);
        polygon1.addVertex(8.0, 4.0);
        polygon1.addVertex(4.0, 3.0);
        polygon1.addVertex(2.0, 2.0);
        assertEquals(17.0,polygon1.calcPerimeter(),17.1);
        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2.0, 1.0);
        polygon2.addVertex(5.0, 0.0);
        polygon2.addVertex(7.0, 5.0);
        polygon2.addVertex(4.0, 6.0);
        polygon2.addVertex(1.0, 4.0);
        assertEquals(18.4,polygon2.calcPerimeter(),18.6);
    }

    @Test
    public void highestVertexMatan()
    {
        Polygon polygon1 = new Polygon();
        polygon1.addVertex(1.0, 0.0);
        polygon1.addVertex(3.0, 1.0);
        polygon1.addVertex(5.0, 3.0);
        polygon1.addVertex(6.0, 4.0);
        polygon1.addVertex(7.0, 4.0);
        polygon1.addVertex(8.0, 4.0);
        polygon1.addVertex(4.0, 3.0);
        polygon1.addVertex(2.0, 2.0);
        Point point1=new Point(6.0,4.0);
        assertEquals(point1.toString(),polygon1.highestVertex().toString());
        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2.0, 1.0);
        polygon2.addVertex(5.0, 0.0);
        polygon2.addVertex(7.0, 5.0);
        polygon2.addVertex(4.0, 6.0);
        polygon2.addVertex(1.0, 4.0);
        Point point2=new Point(4.0,6.0);
        assertEquals(point2.toString(),polygon2.highestVertex().toString());
    }

    @Test
    public void calcAreaMatan()
    {
        Polygon polygon1 = new Polygon();
        polygon1.addVertex(1.0, 0.0);
        polygon1.addVertex(3.0, 1.0);
        polygon1.addVertex(5.0, 3.0);
        polygon1.addVertex(6.0, 4.0);
        polygon1.addVertex(7.0, 5.0);
        polygon1.addVertex(8.0, 6.0);
        polygon1.addVertex(4.0, 3.0);
        polygon1.addVertex(2.0, 2.0);
        assertEquals(5.49,polygon1.calcArea(),5.6);
        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2.0, 1.0);
        polygon2.addVertex(5.0, 0.0);
        polygon2.addVertex(7.0, 5.0);
        polygon2.addVertex(4.0, 6.0);
        polygon2.addVertex(1.0, 4.0);
        assertEquals(22.4,polygon2.calcArea(),22.6);
    }

    @Test
    public void toPrintMatan()
    {
        Polygon polygon1 = new Polygon();
        assertEquals("The polygon has 0 vertices.",polygon1.toString());
        polygon1.addVertex(1.0, 0.0);
        polygon1.addVertex(3.0, 1.0);
        polygon1.addVertex(5.0, 3.0);
        polygon1.addVertex(6.0, 4.0);
        polygon1.addVertex(7.0, 5.0);
        polygon1.addVertex(8.0, 6.0);
        polygon1.addVertex(4.0, 3.0);
        polygon1.addVertex(2.0, 2.0);
        Polygon polygon3 = new Polygon();
        polygon3.addVertex(2.0, 1.0);
        polygon3.addVertex(8.0, 1.0);
        polygon3.addVertex(8.0, 6.0);
        polygon3.addVertex(2.0, 6.0);

        assertEquals(5.49,polygon1.calcArea(),5.6);
        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2.0, 1.0);
        polygon2.addVertex(5.0, 0.0);
        polygon2.addVertex(7.0, 5.0);
        polygon2.addVertex(4.0, 6.0);
        polygon2.addVertex(1.0, 4.0);
        assertEquals(22.4,polygon2.calcArea(),22.6);
    }

    @Test
    public void boundingBoxMatan()
    {
        Polygon polygon1 = new Polygon();
        polygon1.addVertex(3.0, 1.0);
        polygon1.addVertex(5.0, 3.0);
        polygon1.addVertex(6.0, 4.0);
        polygon1.addVertex(7.0, 5.0);
        polygon1.addVertex(8.0, 6.0);
        polygon1.addVertex(4.0, 3.0);
        polygon1.addVertex(2.0, 2.0);
        Polygon polygon3 = new Polygon();
        polygon3.addVertex(2.0, 1.0);
        polygon3.addVertex(8.0, 1.0);
        polygon3.addVertex(8.0, 6.0);
        polygon3.addVertex(2.0, 6.0);
        assertEquals(polygon3.toString(),polygon1.getBoundingBox().toString());
        Polygon polygon2 = new Polygon();
        polygon2.addVertex(2.0, 1.0);
        polygon2.addVertex(5.0, 0.0);
        polygon2.addVertex(7.0, 5.0);
        polygon2.addVertex(4.0, 6.0);
        polygon2.addVertex(1.0, 4.0);
        Polygon polygon4 = new Polygon();
        polygon4.addVertex(1.0, 0.0);
        polygon4.addVertex(7.0, 0.0);
        polygon4.addVertex(7.0, 6.0);
        polygon4.addVertex(1.0, 6.0);
        assertEquals(polygon4.toString(),polygon2.getBoundingBox().toString());
        Polygon polygon5 = new Polygon();
        polygon5.addVertex(1.0, 0.0);
        assertEquals(null,polygon5.getBoundingBox());
        polygon5.addVertex(2.0, 0.0);
        assertEquals(null,polygon5.getBoundingBox());
        polygon5.addVertex(1.50, 3.0);
        Polygon polygon6 = new Polygon();
        polygon6.addVertex(1.0, 0.0);
        polygon6.addVertex(2.0, 0.0);
        polygon6.addVertex(2.0, 3.0);
        polygon6.addVertex(1.0, 3.0);
        assertEquals(polygon6.toString(),polygon5.getBoundingBox().toString());
    }
}

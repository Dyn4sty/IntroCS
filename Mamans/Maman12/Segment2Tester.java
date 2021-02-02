
/**
 * Compilation (only !) tester for Maman 12, 20441, 2021a
 * 
 * @author Course staff 
 * @version 2_1
 */
public class Segment2Tester
{
    public static void main(String[] args)
    {
        System.out.println("============ Testing class Segment2 =============");
        
        Segment2 s21 = new Segment2(1.0 , 2.0, 3.0, 4.0);
        Segment2 s22 = new Segment2(1.0 , 2.0, 3.0, 4.0);
        if (!s21.equals(s22))
            System.out.println("Check your equals method in class Segment2");        
            
        Point p3 = new Point(5.0, 6.0);
        Point p4 = new Point(7.0, 8.0);
        Segment2 s23 = new Segment2(p3, p4);
        Segment2 s24 = new Segment2(s22);
        
        Point p5 = s21.getPoLeft();
        p5 = s21.getPoRight();
        
        double d1 = s21.getLength();
        
        if (s21.toString().indexOf('@') != -1)
            System.out.println("Check your toString method in class Segment2");
            
        boolean b1 = s21.isAbove(s22);
        b1 = s21.isUnder(s22);
        b1 = s21.isLeft(s22);
        b1 = s21.isRight(s22);
        
        s21.moveHorizontal(1.0);
        s21.moveVertical(1.0);
        s21.changeSize(1.0);
        
        b1 = s21.pointOnSegment(p3);
        b1 = s21.isBigger(s22);
        d1 = s21.overlap(s22);
        d1 = s21.trapezePerimeter(s22);

        System.out.println("============ Testing class Segment2 Done=============");
    }
}

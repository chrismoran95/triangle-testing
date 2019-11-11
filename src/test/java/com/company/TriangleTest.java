package com.company;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void Constructor()  {
        Point a = new Point(1.3 , 1.1);
        assertEquals(1.3, a.X());
        assertEquals(1.1, a.Y());
    }
    @Test
    void Equilateral() {
        Triangle a = new Triangle(1, 1, 1);
        assertEquals("Equilateral", a.GetName());
    }
    @Test
    void CheckInfo()  {
        Point a = new Point(1,2);
        assertEquals(" 1.0, 2.0", a.display());
    }
    @Test
    void CheckArea()
    {
        Triangle a = new Triangle(1,1,1);
        assertEquals(0.4330127018922193,a.getArea());
    }
    @Test
    void Scalene()
    {
        Triangle a = new Triangle(13,9,14);
        assertEquals("Scalene",a.GetName());
    }
    @Test
    void Right()
    {
        Triangle a = new Triangle(1,1,1.41421356237);
        assertEquals("Right Isoceles Triangle",a.GetName());
    }
    @Test
    void Isoceles()
    {
        Triangle t = new Triangle(3, 3, 5);
        assertEquals("Isoceles Triangle", t.GetName());
    }
    @Test
    void Validation()  {
        Triangle invalid = new Triangle(-1, -1, -7);

        Assert.assertEquals("All sides are negative or equal to zero", invalid.GetName());
        Triangle t = new Triangle(5, 6, 1);
        assertEquals("Invalid triangle", t.GetName());

    }
    @Test
    void CheckScaleneArea()
    {
        Triangle t = new Triangle(3, 2, 4);
        assertEquals("Scalene", t.GetName());
        assertEquals(2.9047375096555625, t.getArea());

    }
    @Test
    void CheckRightIsocelesCoordinate()
    {
        Point a = new Point(0,1);
        Point b = new Point(1,0);
        Point c = new Point(0,0);
        Triangle t = new Triangle(a, b, c);
        assertEquals("Right Isoceles Triangle", t.GetName());
        assertEquals(0.49999999999999983, t.getArea());
    }
    @Test
    void CheckEquilateralCoordinates()
    {
        // Equilateral Triangle
        Triangle t = new Triangle(4,4,4);
        assertEquals("Equilateral", t.GetName());
       assertEquals(6.928203230275509, t.getArea());
    }
    @Test
    void checkEquals()  {
        Point a = new Point(3,3);
        Point b = new Point(3,3);
        Point c = new Point(2,3);
        assertTrue(a.ComparePoints(b));
        assertFalse(a.ComparePoints(c));
    }

    @Test
    void CheckPointTypeScalene()
    {
        Point d = new Point(2,1);
        Point e = new Point(1,3);
        Point f = new Point(1,4);
        Triangle te = new Triangle(d,e,f);
        assertEquals("Scalene", te.GetName());
    }


    @Test
    void CheckDistance()
    {
        Point a = new Point(3,10);
        Point b= new Point(0, 6);
        Point c= new Point(3, 10);
        assertEquals(5 , b.CalculateDistanceAB(a));
        assertEquals(5 , b.CalculateDistanceBC(c));

    }
}
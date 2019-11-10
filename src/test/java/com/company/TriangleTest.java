package com.company;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {


    @Test
    void Equilateral() {
        Triangle a = new Triangle(1, 1, 1);
        Assert.assertEquals("Equilateral", a.GetName());
    }

    @Test
    void CheckArea()
    {
        Triangle a = new Triangle(1,1,1);
        Assert.assertEquals(0.4330127018922193,a.getArea());
    }
    @Test
    void Scalene()
    {
        Triangle a = new Triangle(13,9,14);
        Assert.assertEquals("Scalene",a.GetName());
    }
    @Test
    void NotEqual() {
        Point a = new Point(3,10);
        Point b= new Point(6,0);
        assertFalse(a.equals(b));




    }
    @Test
    void CheckDistance()
    {
        Point a = new Point(3,10);
        Point b= new Point(0, 6);
        assertEquals(5 , b.CalculateDistanceAB(a));

    }
}
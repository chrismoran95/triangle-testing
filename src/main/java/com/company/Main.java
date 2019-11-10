package com.company;

import java.util.*;
import java.util.Scanner;

class Triangle
{
    private double firstside,otherside,longestside,totalarea,semi;
    private String Names = "";

    Triangle()
    {
        firstside=0;
        otherside=0;
        longestside=0;
        Names="";
    }
    String GetName()
    {
        return Names;
    }
    boolean Equilateral()
    {
        if(Names.equals("Equilateral")) {
            return true;
        }
        return false;
    }

    public void Check(double a,double b,double c)
    {


        double [] array1 = {a,b,c};
        Arrays.sort(array1);//sorts the array so that the longest side will always be the highest aka c
        firstside= array1[0];
        otherside = array1[1];
        longestside= array1[2];
        double total = ((a*a)+(b*b))-(c*c);
        if(firstside <=0 && otherside<=0 && longestside<=0)
        {
            System.out.println("All sides are negative or equal to zero");
        }
        else if(firstside<=0 && otherside<=0|| otherside<=0 && longestside<=0 || firstside<=0 && longestside<=0)
        {
            System.out.println("Two sides are negative or zero which is invalid");
        }
        else if (firstside<=0||otherside<=0||longestside<=0)
        {
            System.out.println("One side is either negative or is equal to zero which is invalid");
        }
        else if(firstside + otherside <= longestside || firstside + longestside <= otherside || otherside + longestside <= firstside)
        {
            System.out.println("Invalid triangle");
        }
        else
        {



            if((firstside == otherside && Math.abs(total) != 0 && Math.abs(total)!= 0.000000000000001) && (otherside == longestside && Math.abs(total) != 0 && Math.abs(total)!= 0.000000000000001))
            {
                System.out.println("Equilateral");

            }
            else
            {
                if ((firstside == otherside && Math.abs(longestside/firstside-Math.sqrt(2))<0.00000000001))
                {
                    System.out.println("Right Isoceles Triangle");

                }
				/*else if (firstside == otherside && Math.abs(total) > 0.00000000001||firstside == longestside && Math.abs(total) > 0.00000000001||otherside == longestside && Math.abs(total) > 0.00000000001)
				{
					System.out.println("Right Isoceles Triangle if negative");
				}*/
                else if((firstside == otherside && Math.abs(total) != 0)||(firstside == longestside && Math.abs(total) != 0) || (otherside == longestside && Math.abs(total) != 0))
                {
                    System.out.println("Isoceles Triangle");
                }
                else
                {
                    if ((firstside != otherside && total == 0) || (firstside != otherside && Math.abs(total) <= 0.000000000000001) || (firstside != longestside && total==0)||(firstside != longestside &&Math.abs(total) <= 0.000000000000001))
                    {
                        System.out.println("Right Scalene Triangle");

                    }
                    else
                    {
                        System.out.println("Scalene");
                    }
                }

            }
            System.out.println("Total "+total+" a "+firstside+" b "+otherside+" c "+longestside);
        }
    }

    public Triangle(Point A,Point B,Point C)
    {
        //Creates a triangle object using the distance that was created as it's a,b,and c;
        this(A.CalculateDistanceAB(B), B.CalculateDistanceBC(C), C.CalculateDistanceCA(A));

    }
    public double getArea()
    {
        semi = (firstside + otherside + longestside)/2;//semi perimeter
        totalarea = Math.sqrt(semi*(semi-firstside)*(semi-otherside)*(semi-longestside));//herosFormula
        return totalarea;

    }
    void displayTriangle()
    {
        System.out.println(Names);
    }
    public Triangle (double a,double b,double c)
    {


        double [] array1 = {a,b,c};
        Arrays.sort(array1);//sorts the array so that the longest side will always be the highest aka c
        firstside= array1[0];
        otherside = array1[1];
        longestside= array1[2];
        double total = ((a*a)+(b*b)-(c*c));
        if(firstside <=0 && otherside<=0 && longestside<=0)
        {
            Names = "All sides are negative or equal to zero";
        }
        else if(firstside<=0 && otherside<=0|| otherside<=0 && longestside<=0 || firstside<=0 && longestside<=0)
        {
            Names ="Two sides are negative or zero which is invalid";
        }
        else if (firstside<=0||otherside<=0||longestside<=0)
        {
            Names="One side is either negative or is equal to zero which is invalid";
        }
        else if(firstside + otherside <= longestside || firstside + longestside <= otherside || otherside + longestside <= firstside)
        {
            Names="Invalid triangle";
        }
        else
        {



            if((firstside == otherside && Math.abs(total) != 0 && Math.abs(total)!= 0.000000000000001) && (otherside == longestside && Math.abs(total) != 0 && Math.abs(total)!= 0.000000000000001))
            {
                Names = "Equilateral";

            }
            else
            {
                if ((firstside == otherside && Math.abs(longestside/firstside-Math.sqrt(2))<0.00000000001))
                {
                    Names="Right Isoceles Triangle";

                }
				/*else if (firstside == otherside && Math.abs(total) > 0.00000000001||firstside == longestside && Math.abs(total) > 0.00000000001||otherside == longestside && Math.abs(total) > 0.00000000001)
				{
					System.out.println("Right Isoceles Triangle if negative");
				}*/
                else if((firstside == otherside && Math.abs(total) != 0)||(firstside == longestside && Math.abs(total) != 0) || (otherside == longestside && Math.abs(total) != 0))
                {
                    Names="Isoceles Triangle";
                }
                else
                {
                    if ((firstside != otherside && total == 0) || (firstside != otherside && Math.abs(longestside/firstside-Math.sqrt(2))<0.00000000001) || (firstside != longestside && total==0)||(firstside != longestside &&Math.abs(longestside/firstside-Math.sqrt(2))<0.00000000001))
                    {
                        Names="Right Scalene Triangle";

                    }
                    else
                    {
                        Names="Scalene";
                    }
                }

            }
            System.out.println("Total "+total+" shortside "+firstside+" secondside "+otherside+" longestside "+longestside);
            System.out.println("The Triangles Area is "+getArea());
        }
    }
}
class Point
{
    private double x, y,distance;
    public Point(double x, double y)
    {

        this.x=x;
        this.y=y;


    }
    public double CalculateDistanceAB(Point initial)
    {
        distance = Math.sqrt((Math.pow((Math.abs(x- initial.x)), 2))+Math.pow((Math.abs(y- initial.y)),2));
        System.out.println("Point A to b x coordinate  " +initial.x+"y coordinate "+initial.y);
        System.out.println("distance = "+distance);

        return distance;//calculates the distance
    }
    public double CalculateDistanceBC(Point initial)
    {
        distance = Math.sqrt((Math.pow((Math.abs(x- initial.x)), 2))+Math.pow((Math.abs(y- initial.y)),2));
        System.out.println("Point B to C x coordinate  " +initial.x+"y coordinate "+initial.y);
        System.out.println("distance = "+distance);

        return distance;//calculates the distance
    }
    public double CalculateDistanceCA(Point initial)
    {
        distance = Math.sqrt((Math.pow((Math.abs(x- initial.x)), 2))+Math.pow((Math.abs(y- initial.y)),2));
        System.out.println("Point C to A x coordinate  " +initial.x+"y coordinate "+initial.y);
        System.out.println("distance = "+distance);

        return distance;//calculates the distance
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        try
        {


		  /* System.out.println("Please enter the first side");
		   double a= input.nextDouble();
		   System.out.println("Please enter the second side");
		   double b= input.nextDouble();
		   System.out.println("Please enter the third side");
		   double c= input.nextDouble();*/
            System.out.println("Please enter your first x coordinate and y coordinate but makes sure to space them");
            double firstX = input.nextDouble();
            double firstY = input.nextDouble();
            Point coordinate1 = new Point(firstX,firstY);
            System.out.println("Please enter your second  x coordinate and y coordinate but makes sure to space them");
            double secondX = input.nextDouble();
            double secondY = input.nextDouble();
            Point coordinate2 = new Point(secondX,secondY);
            System.out.println("Please enter your third  x coordinate and y coordinate but makes sure to space them");
            double finalX = input.nextDouble();
            double finalY = input.nextDouble();
            Point coordinate3 = new Point(finalX,finalY);
            System.out.println("Calculating all three points to see what triangle it wil be .....");
            Triangle t= new Triangle(coordinate1,coordinate2,coordinate3);
            System.out.println("Your points are x: "+firstX+"y: "+firstY+"For side A");
            System.out.println("Your points are x: "+secondX+"y: "+secondY+"For side B");
            System.out.println("Your points are x: "+finalX+"y: "+finalY+"For side C");
            System.out.println("The triangle is a");
            t.displayTriangle();

        }

        catch(Exception e)
        {
            System.out.println("Please enter a valid number");
        }
        input.close();
    }

}
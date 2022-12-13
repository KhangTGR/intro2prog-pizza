import java.util.Scanner;

public class Circle_Cylinder {

    public static void main (String[] args) {
                Scanner scan = new Scanner(System.in);

                Cylinder cylinder = new Cylinder(3.4, 12);
                System.out.println("Area: " + cylinder.getArea());
                System.out.println("Volume: "   + cylinder.getVolume());
            }
        }




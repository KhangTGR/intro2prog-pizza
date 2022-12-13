public class Circle {

   private double radius;

   public Circle(double radius) {

       this.radius = radius;
   }


    public double getRadius() {
        return radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return this.radius * this.radius * Math.PI;

    }
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';

    }

}

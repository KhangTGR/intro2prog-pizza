public class Cylinder extends Circle {


   private double height;

   public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
   }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;

    }
}


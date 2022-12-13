/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Test 1
  Author: Pham Ngoc Huy
  ID: S3926681
  Created date: 3/12/2022
  Acknowledgement: Acknowledge the resources that you use here.
*/

package Question3;

public class Service {
    private double distance;

    public Service(double distance) {
        this.distance = distance;
    }

    public void FoodDelivery(){
        double FoodDeliveryCost = 2 * distance;
    }
    public void ExpressDelivery(){
        double ExpressDeliveryCost = 4 * distance;
    }
    public String booked(){
        System.out.println("Booked");
        return null;
    }
    public Object delivering(){
        System.out.println("Delivering");
        return null;
    }
    public Object delivered(){
        System.out.println("Delivered");
        return null;
    }

}

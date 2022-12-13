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

public class Client {

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getDistance() {
        return distance;
    }


    public void setDistance(int distance) {
        this.distance = distance;
    }


    public String getService() {
        return service;
    }


    public void setService(String service) {
        this.service = service;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    private String name;
    private int distance;
    private String service;
    private String status;



}

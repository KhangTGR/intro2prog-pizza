package View;

import utility.displayData;

import java.io.IOException;


abstract class adminGoodsDisplay implements productDisplay {

    public void displayGoods ()  {
        try{
            displayData data = new displayData();
            data.displayGoods();
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}

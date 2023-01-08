package View;

import utility.displayData;

import java.io.IOException;


abstract class adminGoodsDisplay implements productDisplay {

    public void displayGoods ()  {
        displayData data = new displayData();
        data.displayGoods();

    }
}

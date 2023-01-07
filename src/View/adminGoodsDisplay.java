package View;

import utility.displayData;


abstract class adminGoodsDisplay implements productDisplay {

    public void displayGoods () {
        displayData data = new displayData();
        data.displayGoods();

    }
}

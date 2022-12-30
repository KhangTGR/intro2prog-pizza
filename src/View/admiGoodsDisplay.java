package View;

import utility.displayData;


abstract class admiGoodsDisplay implements productDisplay {

    public void displayGoods () {
        displayData data = new displayData();
        data.displayGoods();

    }
}

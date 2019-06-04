package com.moxiaowei.map.mapdemo;

import static com.moxiaowei.map.mapdemo.Color.WHITE;

public class MapItem {

    int num;
    Color color = WHITE;
    int d = 0;
    MapItem pro = null;

    public MapItem() {
    }

    public MapItem(int num, Color color, int d, MapItem pro) {


        this.num = num;
        this.color = color;
        this.d = d;
        this.pro = pro;
    }
}

package com.moxiaowei.map.mapdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.moxiaowei.map.mapdemo.Color.*;

public class Map {

    List<List<MapItem>> array;

    public Map() {
        array = new ArrayList<>();
        MapItem item0 = new MapItem(0, Color.WHITE, 0, null);
        MapItem item11 = new MapItem(1, Color.WHITE, 0, null);
        MapItem item12 = new MapItem(1, Color.WHITE, 0, null);
        MapItem item21 = new MapItem(2, Color.WHITE, 0, null);
        MapItem item22 = new MapItem(2, Color.WHITE, 0, null);
        MapItem item23 = new MapItem(2, Color.WHITE, 0, null);
        MapItem item31 = new MapItem(3, Color.WHITE, 0, null);
        MapItem item32 = new MapItem(3, Color.WHITE, 0, null);

        array.add(new ArrayList<MapItem>() {{
            add(item0);
            add(item11);
            add(item12);
        }});

        array.add(new ArrayList<MapItem>() {{
            add(item11);
            add(item21);
        }});

        array.add(new ArrayList<MapItem>() {{
            add(item12);
            add(item22);
            add(item23);
        }});

        array.add(new ArrayList<MapItem>() {{
            add(item22);
            add(item12);
            add(item23);
            add(item31);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item23);
            add(item12);
            add(item22);
            add(item31);
            add(item32);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item23);
            add(item12);
            add(item22);
            add(item31);
            add(item32);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item31);
            add(item22);
            add(item23);
            add(item32);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item32);
            add(item23);
            add(item31);
        }});

    }

    public void BFS() throws InterruptedException {
        MapItem s = this.array.get(0).get(0);
        s.color = GRAY;
//        Stack<MapItem> Q = new Stack<>();
        ConcurrentLinkedQueue<MapItem> Q = new ConcurrentLinkedQueue<>();
        Q.add(s);
        System.out.println(s.num);
        while (!Q.isEmpty()) {
            MapItem u = Q.poll();
            List<MapItem> mapItems = null;
            for (List<MapItem> item : this.array) {
                if (item.get(0).equals(u)) {
                    mapItems = item;
                }
            }
            if (mapItems != null) {
                for (MapItem v : mapItems) {
                    if (v.color == WHITE) {
                        v.color = GRAY;
                        v.d = v.d + 1;
                        v.pro = u;
                        Q.add(v);
                        System.out.println(v.num);
                    }
                }
            }
            u.color = BLACK;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        map.BFS();
    }
}

package com.moxiaowei.map.mapdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.moxiaowei.map.mapdemo.Color.*;

public class Map {

    List<List<MapItem>> array;

    public Map() {
        array = new ArrayList<>();
        MapItem item0 = new MapItem(0, WHITE, 0, null);
        MapItem item11 = new MapItem(1, WHITE, 0, null);
        MapItem item12 = new MapItem(1, WHITE, 0, null);
        MapItem item21 = new MapItem(2, WHITE, 0, null);
        MapItem item22 = new MapItem(2, WHITE, 0, null);
        MapItem item23 = new MapItem(2, WHITE, 0, null);
        MapItem item31 = new MapItem(3, WHITE, 0, null);
        MapItem item32 = new MapItem(3, WHITE, 0, null);
        MapItem item41 = new MapItem(4, WHITE, 0, null);

        array.add(new ArrayList<MapItem>() {{
            add(item0);
            add(item11);
            add(item12);
        }});

        array.add(new ArrayList<MapItem>() {{
            add(item11);
            add(item21);
            add(item0);
        }});

        array.add(new ArrayList<MapItem>() {{
            add(item12);
            add(item22);
            add(item23);
            add(item0);
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
            add(item41);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item32);
            add(item23);
            add(item31);
        }});
        array.add(new ArrayList<MapItem>() {{
            add(item41);
            add(item31);
        }});

    }

    public List<MapItem> BFS() throws InterruptedException {
        ArrayList<MapItem> re = new ArrayList<>();
        MapItem s = this.array.get(0).get(0);
        s.color = GRAY;
//        Stack<MapItem> Q = new Stack<>();
        ConcurrentLinkedQueue<MapItem> Q = new ConcurrentLinkedQueue<>();
        Q.add(s);
//        System.out.println(s.num);
        re.add(s);
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
                        v.d = u.d + 1;
                        v.pro = u;
                        Q.add(v);
//                        System.out.println(v.num);
                        re.add(v);
                    }
                }
            }
            u.color = BLACK;
        }
        return re;
    }

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        List<MapItem> bfs = map.BFS();
        for(MapItem mi : bfs){
            if(mi.num == 4){
                System.out.println(mi.d);
            }
        }
    }
}

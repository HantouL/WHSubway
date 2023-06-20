package com.hantou.utils;

import com.hantou.Service.LineService;
import com.hantou.Service.StationService;
import com.hantou.Service.Station_LineService;
import com.hantou.pojo.line;
import com.hantou.pojo.station;
import com.hantou.pojo.station_line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
//打包了线路查询的主要逻辑
public class func {
    @Autowired
    LineService lineService =new LineService();
    @Autowired
    Station_LineService station_lineService=new Station_LineService();
    @Autowired
    StationService stationService=new StationService();

    public LinkGraph InitGraph()
    {
        List<line> lines= lineService.getLines();
        List<station> stations = stationService.getStations();
        List<station_line> station_lines = station_lineService.getStation_Lines();

        LinkGraph lg = new LinkGraph(stations.size(),false);
        for (int i = 0; i < stations.size(); i++) {//插入头结点
            lg.InsertVertextes(stations.get(i).getName());
        }

        for (int i = 0; i < lines.size(); i++) {
            List<station> linestations = station_lineService.getLine(lines.get(i).getName());
            int a=-1,b=0,c=1;
            for(b=0;b<linestations.size();a++,b++,c++)
            {
                if(a>=0&&a<linestations.size())
                    lg.InsertEdges(linestations.get(b).getName(),linestations.get(a).getName(),1);
                if(c>=0&&c<linestations.size())
                    lg.InsertEdges(linestations.get(b).getName(),linestations.get(c).getName(),1);
            }

        }
    return lg;
    }

    public List<String> bfs(String start,String end,LinkGraph lg)
    {
        // 初始化路径为空
        List<String> way = new ArrayList<>();

        // 出发即到达，直接返回起点
        if (start.equals(end)) {
            way.add(start);
            return way;
        }

        Queue<String> q = new LinkedList<>();
        int v = lg.getNumInputV();
        Boolean[] visited = new Boolean[v];
        Arrays.fill(visited, false);

        Map<String, String> parentMap = new HashMap<>();

        // 将起点加入队列，标记为已访问
        q.offer(start);
        visited[lg.getVertexPos(start)] = true;

        while (!q.isEmpty()) {
            String stationName = q.poll();
            EdgeNode edge = lg.getVtNode()[lg.getVertexPos(stationName)].getFirstEdge();

            // 遍历当前节点的所有邻居节点
            while (edge != null) {
                String neighbor = edge.getAdjvex();

                // 如果该邻居节点未被访问过，则将其加入队列并标记为已访问，同时记录下其父节点
                if (!visited[lg.getVertexPos(neighbor)]) {
                    visited[lg.getVertexPos(neighbor)] = true;
                    parentMap.put(neighbor, stationName);
                    q.offer(neighbor);

                    // 如果找到了终点，则按照父节点记录构造路径并返回
                    if (neighbor.equals(end)) {
                        String currStation = neighbor;
                        while (!currStation.equals(start)) {
                            //头插
                            way.add(0, currStation);
                            //一路回溯上去
                            currStation = parentMap.get(currStation);
                        }
                        way.add(0, start);
                    }
                }
                edge = edge.getNext();
            }
        }

        if(way.size()<=2) return way;

        List<String> temp = new ArrayList<String>(way);
        for (int i = 1; i < way.size()-1; i++) {
            List<String> l1 = station_lineService.getLinesByStations(temp.get(i-1),temp.get(i));
            List<String> l2 = station_lineService.getLinesByStations(temp.get(i),temp.get(i+1));

            String a = l1.get(0);
            String b = l2.get(0);

            if(!a.equals(b)) way.set(i,way.get(i)+"(换乘"+b+")");

        }
        return way;
    }

}


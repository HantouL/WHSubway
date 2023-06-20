package com.hantou.Service;

import com.hantou.Mapper.StationMapper;
import com.hantou.Mapper.Station_LineMapper;
import com.hantou.pojo.station;
import com.hantou.pojo.station_line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Station_LineService {
    @Autowired
    private Station_LineMapper station_LineMapper;

    public List<station_line> getStation_Lines(){
        return station_LineMapper.getStation_Lines();
    }

    public List<station> getLine(String lineName){return station_LineMapper.getLine(lineName);};

    public List<String> getLinesByStations(String start,String end) {return station_LineMapper.getLinesByStations(start,end);}
}

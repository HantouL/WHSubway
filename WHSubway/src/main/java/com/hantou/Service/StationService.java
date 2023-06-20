package com.hantou.Service;

import com.hantou.Mapper.StationMapper;
import com.hantou.pojo.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationMapper stationMapper;

    public List<station> getStations(){
        return stationMapper.getStations();
    }

    public station getStationByName(String stationName) {
        return stationMapper.getStationByName(stationName);
    }

    public station getStationById(String stationId) {
        return stationMapper.getStationById(stationId);
    }
}

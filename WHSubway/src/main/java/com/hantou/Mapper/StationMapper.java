package com.hantou.Mapper;

import com.hantou.pojo.station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

@Mapper
public interface StationMapper {
    List<station> getStations();

    station getStationByName(@Param("stationName") String stationName);

    station getStationById(@Param("stationId")String stationId);
}

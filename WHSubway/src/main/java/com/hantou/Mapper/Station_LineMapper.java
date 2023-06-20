package com.hantou.Mapper;

import com.hantou.pojo.station;
import com.hantou.pojo.station_line;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Station_LineMapper {
    List<station_line> getStation_Lines();

    List<station> getLine(@Param("lineName")String lineName);

    List<String> getLinesByStations(@Param("start")String start,@Param("end")String end);
}

package com.hantou.Service;

import com.hantou.Mapper.LineMapper;
import com.hantou.Mapper.StationMapper;
import com.hantou.pojo.line;
import com.hantou.pojo.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {
    @Autowired
    private LineMapper lineMapper;

    public List<line> getLines(){return lineMapper.getLines();}
}

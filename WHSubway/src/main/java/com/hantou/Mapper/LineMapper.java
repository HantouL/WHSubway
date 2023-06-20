package com.hantou.Mapper;

import com.hantou.pojo.line;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineMapper {
    List<line> getLines();
}

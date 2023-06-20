package com.hantou.Controller;


import com.hantou.Service.StationService;
import com.hantou.Service.Station_LineService;
import com.hantou.Vo.ResultVo;
import com.hantou.constant.ResultEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//站点_线路控制器
@RestController
@RequestMapping("/station_line")
public class Station_LineController {
    @Autowired
    private Station_LineService station_lineService;

    //查询所有站点_线路
    @RequestMapping("/getStation_Lines")
    public ResultVo getStation_Lines(){
        return new ResultVo(ResultEnum.OK,station_lineService.getStation_Lines());
    }

    //查询指定线路上的站点
    @RequestMapping("/getLine")
    public ResultVo getALine(@RequestParam("lineName")String lineName) {
        return new ResultVo(ResultEnum.OK, station_lineService.getLine(lineName));
    }

    //查询边所属线路
    @RequestMapping("/getLineByStations")
    public ResultVo getLinesByStations(@RequestParam("start")String start,@RequestParam("end")String end){
        return new ResultVo(ResultEnum.OK,station_lineService.getLinesByStations(start,end));
    }

}

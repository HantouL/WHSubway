package com.hantou.Controller;

import com.hantou.Service.StationService;
import com.hantou.Vo.ResultVo;
import com.hantou.constant.ResultEnum;
import com.hantou.pojo.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//站点控制器
@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    //查询所有站点
    @RequestMapping("getStations")
    public ResultVo getStations() {
        //List<station> stations = stationService.getStations();
        return new ResultVo(ResultEnum.OK,stationService.getStations());
    }

    //根据名称查询站点
    @RequestMapping("getStationByName")
    public ResultVo getStationByName(@RequestParam("stationName")String stationName) {
        return new ResultVo(ResultEnum.OK,stationService.getStationByName(stationName));
    }

    //根据id查询站点
    @RequestMapping("getStationById")
    public ResultVo getStationById(@RequestParam("stationId")String stationId) {
        return new ResultVo(ResultEnum.OK,stationService.getStationById(stationId));
    }
}

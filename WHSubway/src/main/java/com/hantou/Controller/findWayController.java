package com.hantou.Controller;

import com.hantou.Service.LineService;
import com.hantou.Vo.ResultVo;
import com.hantou.constant.ResultEnum;
import com.hantou.utils.LinkGraph;
import com.hantou.utils.func;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 寻路控制器
@RestController
@RequestMapping("/way")
public class findWayController {

    @Autowired
    private func findWayFunc;

    //根据输入的出发站点和目的站点返回对应的路径信息
    @RequestMapping("findWay")
    public ResultVo findWay(@RequestParam("startStation")String startStation,@RequestParam("endStation")String endStation) {
        LinkGraph lg = findWayFunc.InitGraph();
        return new ResultVo(ResultEnum.OK,findWayFunc.bfs(startStation,endStation,lg));
    }
}

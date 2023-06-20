package com.hantou.Controller;

import com.hantou.Service.LineService;
import com.hantou.Vo.ResultVo;
import com.hantou.constant.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//线路相关控制器
@RestController
@RequestMapping("/lines")
public class LineController {
    @Autowired
    private LineService lineService;

    //查询所有线路
    @RequestMapping("/getLines")
    public ResultVo getLines() {
        return new ResultVo(ResultEnum.OK,lineService.getLines());
    }
}

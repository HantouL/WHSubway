package com.hantou.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//站点_线路Pojo类
public class station_line {
    private Integer lineId;

    private Integer stationId;

    private Integer sequence;
}
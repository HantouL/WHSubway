-- 创建车站表
CREATE TABLE station (
id INT(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
name VARCHAR(20) COMMENT '站名' 
) COMMENT '车站表';

-- 创建线路表
CREATE TABLE line(
id INT(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
name VARCHAR(20) COMMENT '线路名'
) COMMENT '线路表';

-- 创建车站-线路关联表
CREATE TABLE stationLine(
  stationId INT(11) NOT NULL,
  lineId INT(11) NOT NULL,
	sequence INT(11) NOT NULL,
  PRIMARY KEY (stationId, lineId),
  FOREIGN KEY (stationId) REFERENCES station(id),
  FOREIGN KEY (lineId) REFERENCES line(id)
	) COMMENT '地铁站-线路关联表';

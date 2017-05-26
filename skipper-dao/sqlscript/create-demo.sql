CREATE TABLE skipper.skipper_demo
(
  demo_id     BIGINT(20) PRIMARY KEY              NOT NULL
  COMMENT 'demo表主键' AUTO_INCREMENT,
  demo_name   VARCHAR(50)                         NOT NULL
  COMMENT 'demo名称',
  create_tiem TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '更新时间',
  is_deleted  TINYINT(4) DEFAULT '0'              NOT NULL
  COMMENT '删除标志位0未删除 1已删除',
  sys_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT '系统时间'
);
ALTER TABLE skipper.skipper_demo
  COMMENT = 'skipper的demo表'
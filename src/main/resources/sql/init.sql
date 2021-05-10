CREATE TABLE `t_invest_detail`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_name`     varchar(20) NOT NULL COMMENT '用户名',
    `stock_name`    varchar(20) NOT NULL COMMENT '证券名',
    `stock_price`   double      NOT NULL COMMENT '价格',
    `stock_num`     double      NOT NULL COMMENT '数量',
    `tax`           double      NOT NULL DEFAULT '0' COMMENT '税费',
    `purchase_flag` int(1) NOT NULL COMMENT '购买标志 0 买入 1 卖出',
    `purchase_date` date        NOT NULL COMMENT '购买时间',
    `create_time`   datetime    NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY             `purchase_date_idx` (`purchase_date`)
) ENGINE=MEMORY AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='投资明细';


CREATE TABLE `user`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name` varchar(50) NOT NULL COMMENT '姓名',
    `password`  varchar(50) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4)
;

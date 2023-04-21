package com.fhhk.entity;

import java.io.Serializable;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.entity
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO 购物车实体类
 * @Version: 1.0
 */
public class Trolley implements Serializable {
    private int tid;
    private int customer_id;//用户id
    private int service_id;//服务id
    private int trolley_number;
    private String order_id;
    //添加服务映射
    private Service service;

}

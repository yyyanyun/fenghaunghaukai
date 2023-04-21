package com.fhhk.entity;

import java.io.Serializable;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.entity
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
public class Service implements Serializable {
    private int service_id;//服务id
    private String service_name;//服务名称
    private double price;//价格
    private int duration;//时长
    //添加技师映射
    private Staff staff;
}

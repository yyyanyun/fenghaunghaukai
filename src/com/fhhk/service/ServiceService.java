package com.fhhk.service;

import com.fhhk.entity.Service;

import java.util.List;

public interface ServiceService {
    List<Service> selectAllService();
    Service selectServiceByID(int service_id);
}

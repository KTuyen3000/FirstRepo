package com.example.demo.service;

import com.example.demo.model.BuildingDTO;
import com.example.demo.repository.entity.BuildingEntity;
import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name, String districtIDd);
}

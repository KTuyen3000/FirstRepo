package com.example.demo.repository;
import com.example.demo.repository.entity.BuildingEntity;
import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findAl(String name, String districtId);
}

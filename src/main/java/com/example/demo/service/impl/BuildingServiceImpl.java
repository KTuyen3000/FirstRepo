package com.example.demo.service.impl;

import com.example.demo.model.BuildingDTO;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<BuildingDTO> findAll(String name, String districtId) {
        List<BuildingEntity> buildingEntities =  buildingRepository.findAl(name, districtId);
        List<BuildingDTO> result = new ArrayList<BuildingDTO>();
        for(BuildingEntity item : buildingEntities){
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(item.getName());
            buildingDTO.setAddress(item.getStreet() + ", " + item.getWard());
            buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
            result.add(buildingDTO);
        }
        return result;
    }
}

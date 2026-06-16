package com.example.demo.controller;

import com.example.demo.model.BuildingDTO;
import com.example.demo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;
    @GetMapping(value = "/api/building")
    public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
                                         @RequestParam(name = "districtId", required = false) String districtId,
                                         @RequestParam(name = "typeCode", required = false) List<String> typeCode){
        List<BuildingDTO> result = buildingService.findAll(name, districtId);

        return result;
    }

//    public void validate(BuildingDTO building){
//        if(building.getName() == null || building.getName().equals("") || building.getNumberOfBasement() == null){
//            throw new FieldRequiredException("name or number of basement is null");
//        }
//
//    }

//    @GetMapping(value = "/api/building/")
//    void postBuilding(@RequestParam Map<String, String> map){
//        System.out.println("oke");
//    }

    @RequestMapping(value = "/api/building/", method = RequestMethod.PUT)
    public BuildingDTO getBuilding3(@RequestBody BuildingDTO buildingDTO){
        //xu ly xong
        return buildingDTO;
    }


    @DeleteMapping(value = "/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id,
                               @PathVariable String name){
        System.out.println("Da xoa toa nha co id la " + id + " roi nha bro!");
    }
}

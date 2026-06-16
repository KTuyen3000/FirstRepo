package com.example.demo.repository.impl;

import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuidlingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/estateadvance";
    static final String USER = "postgres";
    static final String PASS = "x=25cos(Wt+phi)";
    @Override
    public List<BuildingEntity> findAl(String name, String districtId) {
        StringBuilder sql =  new StringBuilder("SELECT * FROM building b where 1 = 1");
        if(name != null && !name.equals("")){
            sql.append(( " AND b.name like '%" + name + "%' "));
        }
        if(districtId != null){
            sql.append(" AND b.district like '%" + districtId + "%' ");
        }
        List<BuildingEntity> result = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());
            while(rs.next()){
                BuildingEntity buildingDTO = new BuildingEntity();
                buildingDTO.setName(rs.getString("name"));
                buildingDTO.setStreet(rs.getString("street"));
                buildingDTO.setWard(rs.getString("ward"));
                buildingDTO.setNumberOfBasement(rs.getInt("numberOfBasement"));
                result.add(buildingDTO);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connected Database failed...");
        }
        return result;
    }
}

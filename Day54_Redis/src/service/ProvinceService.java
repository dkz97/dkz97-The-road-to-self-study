package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Province;

import java.util.List;

public interface ProvinceService {


    public List<Province> findAll();

    public String findAllJson() throws JsonProcessingException;
}

package com.example.study_springboots.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboots.dao.SharedDao;

@Service
@Transactional
public class MainService {
    @Autowired
    SharedDao sharedDao;

    public Map selectSearch(Map dataMap) {
    // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "MainSpl.selectSearch";
        
        HashMap result = new HashMap<>();
        result.put("resultList", sharedDao.getList(sqlMapId, dataMap));
        return result;
    }
}

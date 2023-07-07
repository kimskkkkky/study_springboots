package com.example.study_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboots.dao.SharedDao;

@Service
@Transactional
public class CarInforsService {
    @Autowired
    SharedDao sharedDao;

    //foreach Map.put("CAR_INFOR_ID_LIST", CAR_INFOR_ID_LIST)
    public Object selectInUID(Map dataMap) {

        String sqlMapId = "CarInfors.selectInUID";

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    //검색
        public Object selectSearch(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectSearch";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

        //검색
        public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

        public Object selectAll(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectByUID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    //입력
    public Object insert(Map dataMap){
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId,dataMap);
        return result;
    }

    public Object update(Map dataMap){
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId,dataMap);
        return null;
    }
     //MVC view에 사용
    public Object delete(Map dataMap){
        String sqlMapId = "CarInfors.delete";
        
        Object result = sharedDao.delete(sqlMapId,dataMap);
        return result;
    }

        //MVC view에 사용
    public Object deleteAndSelectSearch(Map dataMap){
         HashMap result = new HashMap<>();
        //  String sqlMapId = "CarInfors.delete";
        //  result.put ("deletCount", sharedDao.delete(sqlMapId,dataMap));
        result.put ("deletCount", this.delete(dataMap));

        // sqlMapId = "CarInfors.selectSearch";
        //  result.put ("resultList", sharedDao.getOne(sqlMapId,dataMap));
        result.put ("resultList", this.selectSearch(dataMap));
        return result;
    }

    //rest api에 사용
     public Object delete(String CAR_INFOR_ID){
        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.delete(sqlMapId,dataMap);
        return result;
    }

        public Object insertDouble(Map dataMap){
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId,dataMap);
        result = sharedDao.insert(sqlMapId,dataMap);

        return result;
    }
}

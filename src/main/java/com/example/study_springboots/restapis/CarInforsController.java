package com.example.study_springboots.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots.service.CarInforsService;

@RestController
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

    // /selectSearch/YEAR/2020
    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words){
        Object result = carInforsService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
        }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI001
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap){
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap){
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }


    
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

     //2PC create
    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap){
        Object result = null;
        try {
            result =  carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
       
        return ResponseEntity.ok().body(result);
}
}

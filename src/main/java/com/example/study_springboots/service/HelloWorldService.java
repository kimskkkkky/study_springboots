package com.example.study_springboots.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HelloWorldService {
    public ArrayList fakeSelect(String currentPage, String perPage) {
        ArrayList arrayList = new ArrayList();

        HashMap resultmap = new HashMap();
        resultmap.put("spm_row", 471);
        resultmap.put("SN", 1);
        resultmap.put("CMPNM", "로이유통");
        resultmap.put("RDNMADR", null);
        arrayList.add(resultmap);

        resultmap = new HashMap();
        resultmap.put("spm_row", 571);
        resultmap.put("SN", 2);
        resultmap.put("CMPNM", "의료유통");
        resultmap.put("RDNMADR", 3);
        arrayList.add(resultmap);
        return arrayList;
    }
}

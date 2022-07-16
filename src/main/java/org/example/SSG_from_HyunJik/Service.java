package org.example.SSG_from_HyunJik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    List<WiseSaying> result = new ArrayList<>();
    private final Dao dao;
    public Service(){
        dao = new Dao();
    }

    public WiseSaying create(WiseSaying wiseSaying){
        dao.create(wiseSaying);
        return wiseSaying;
    }
    public List allList(){
        return dao.alllist();
    }
}

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
    public void update(int id,String  author, String content){
        dao.update(id,author,content);
    }
    public void delete(int id){
        dao.delete(id);
    }

    public int findByid(int id) {
        return dao.findByid(id);
    }
    public WiseSaying get(int id) {
        return dao.get(id);
    }
}

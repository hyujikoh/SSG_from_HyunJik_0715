package org.example.SSG_from_HyunJik;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    List<WiseSaying> result = new ArrayList<>();
    public WiseSaying create(WiseSaying wiseSaying){
        result.add(wiseSaying);
        return wiseSaying;
    }
    public List alllist(){
        return result;
    }
}

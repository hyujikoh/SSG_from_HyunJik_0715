package org.example.SSG_from_HyunJik;

import org.example.SSG_from_HyunJik.model.WiseSaying;
import org.example.SSG_from_HyunJik.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    List<WiseSaying> result = new ArrayList<>();

    public WiseSaying create(WiseSaying wiseSaying) {
        result.add(wiseSaying);

        Util.saveToFile("test_data/"+wiseSaying.id+".json",wiseSaying.toString());
        return wiseSaying;
    }

    public List alllist() {
        return result;
    }

    public void delete(int id) {
        result.remove(id);
    }


    public int findByid(int id) {
        int idx = -1;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).id == id) {
                return result.get(i).id - 1;
            }
            if (i + 1 == result.size()) {
                break;
            }
        }
        return idx;
    }

    public void update(int id, String author, String content) {
        WiseSaying update_element = result.get(id);
        update_element.author = author;
        update_element.content = content;
    }

    public WiseSaying get(int id) {
        return result.get(id);
    }
}

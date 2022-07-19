package org.example.SSG_from_HyunJik;

import org.example.SSG_from_HyunJik.model.WiseSaying;
import org.example.SSG_from_HyunJik.util.Rq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Service service;
    private Scanner sc;
    int id = 0;
    String error = "잘못된 에러 정보 입력";
    List<WiseSaying> result = new ArrayList<>();

    public Controller(Scanner sc) {
        this.sc = sc;
        service = new Service();
    }

    public void create(Rq rq) {
        id++;
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();
        WiseSaying wiseSaying1 = new WiseSaying(id, author, content);
        WiseSaying wiseSaying = service.create(wiseSaying1);
        System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");
    }

    public void allList(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        result = service.allList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).id + " / " + result.get(i).author + " / " + result.get(i).content);
        }
    }


    public void update(Rq rq) {
        try {
            int id = rq.getIntParam("id", 0);
            int update_id = service.findByid(id);
            if (update_id == -1) {
                throw new Exception();
            }

            WiseSaying update_element = service.get(update_id);

            System.out.println("명언(기존) : " + update_element.content);
            String update_content = sc.nextLine();
            System.out.println("작가(기존) : " + update_element.author);
            String update_author = sc.nextLine();
            service.update(update_id, update_author, update_content);
            System.out.println(id + "번 명언이 수정되었습니다.");
        } catch (Exception e) {
            System.out.println(error);
        }

    }

    public void delete(Rq rq) {
        try {
            int id = rq.getIntParam("id", 0);
            int delete_id = service.findByid(id);
            if (delete_id == -1) {
                throw new Exception();
            }
            service.delete(delete_id);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } catch (Exception e) {
            System.out.println(error);
        }

    }


}

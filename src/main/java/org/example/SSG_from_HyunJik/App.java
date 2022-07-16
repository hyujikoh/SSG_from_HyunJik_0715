package org.example.SSG_from_HyunJik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private Controller controller;
    List<WiseSaying> result = new ArrayList<>();
    public App(Scanner sc) {
        this.sc = sc;
    }
    int id=0;
    String error = "잘못된 에러 정보 입력";
    public void run() {
        System.out.println("== 명언 SSG ==");
        controller = new Controller(sc);
        outer:
        while (true) {
            System.out.println("명령)");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "종료":
                    break outer;

                case "등록":
                    controller.create(rq);
                    break ;
                case "목록":
                    controller.allList(rq);
                    break ;
                case "삭제":
                    controller.delete(rq);
                    break;


                case "수정":

                    controller.update(rq);
                    break ;


            }

        }
    }
    public int findByid(int id){
        String error = "잘못된 에러 정보 입력";
        int idx=-1;
        for(int i = 0 ; i<result.size();i++){
            if(result.get(i).id==id){
                idx = i;
                break;
            }
            if(i+1==result.size()){
                break;
            }
        }
        return idx;
    }
}

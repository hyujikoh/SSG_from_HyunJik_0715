package org.example.SSG_from_HyunJik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    List<WiseSaying> result = new ArrayList<>();
    public App(Scanner sc) {
        this.sc = sc;
    }
    int id=0;
    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.println("명령)");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "종료":
                    break outer;

                case "등록":

                    id++;
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    WiseSaying wiseSaying= new WiseSaying(id,author,content);
                    result.add(wiseSaying);
                    System.out.println(id+"번 명언이 등록되었습니다.");
                    break ;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(int i=0; i <result.size();i++){
                        System.out.println(result.get(i).id+" / "+result.get(i).author+" / "+result.get(i).content);
                    }
                    break ;
                case "삭제":
                    int id = rq.getIntParam("id", 0);
                    System.out.println(id);
                    if(id==0){
                        System.out.println("없는 정보");
                        break;
                    }
                    WiseSaying result_index = result.get(id-1);
                    result.remove(result_index);
                    System.out.println(id+"번 명언이 삭제되었습니다.");
                    break;
                case "수정":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(int i=0; i <result.size();i++){
                        System.out.println(result.get(i).id+" / "+result.get(i).author+" / "+result.get(i).content);
                    }
                    break ;


            }

        }
    }
}

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
    String error = "잘못된 에러 정보 입력";
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
                    if(findByid(id)==-1){
                        System.out.println(error);
                        break ;
                    }
                    WiseSaying delete_element = result.get(findByid(id));
                    result.remove(delete_element);
                    System.out.println(id+"번 명언이 삭제되었습니다.");
                    break;


                case "수정":

                    int update_id = rq.getIntParam("id", 0);
                    if(findByid(update_id)==-1){
                        System.out.println(error);
                        break ;
                    }
                    WiseSaying update_element = result.get(findByid(update_id));
                    System.out.println("명언(기존) : "+update_element.content);
                    String update_content = sc.nextLine();
                    System.out.println("작가(기존) : "+update_element.author);
                    String update_autnor = sc.nextLine();
                    update_element.content =update_content;
                    update_element.author=update_autnor;
                    System.out.println(update_id+"번 명언이 수정되었습니다.");
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

package org.example.SSG_from_HyunJik;

import java.util.Scanner;

public class App {
    private Scanner sc;

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
            switch (cmd) {
                case "종료":
                    break outer;

                case "등록":
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    break outer;

            }

        }
    }
}

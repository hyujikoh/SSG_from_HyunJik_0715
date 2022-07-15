package org.example.SSG_from_HyunJik;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }
    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
              등록
              명언1
              작가1
              """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);
        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();
        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }
    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.println("안녕");
        // 그 동안 System.out.println 으로 모아놨던 문장들을 받아옴
        String rs = output.toString().trim();
        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();
        assertEquals("안녕", rs);
    }
    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료_1단계() {
        String rs = AppTestRunner.run("""
                종료
                """);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
    }
    @Test
    public void 등록시_내용_작가_정보입력_2단계() {
        String rs = AppTestRunner.run("""
                등록
                이순신명언
                이순신
                종료
                """);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }





}

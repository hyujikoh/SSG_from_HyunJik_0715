package org.example.SSG_from_HyunJik.util;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    String path;
    Map<String, String> queryParams;

    // 5.01 cmd 명령으로 받은 내용을 매개변수를 받는 생성자 Rq  선업
    public Rq(String url) {
        this.url = url;
        // 5.02 문자열 배열을 받는 urlBits 를 ? 연산자를 기준으로 나눈다.
        // 가령 "삭제?id=5로 나눌 경우, 각각 삭제, id=5로 나누어진다" , 이후 갯수는 최대 2개로 나누어진다.
        String[] urlBits = url.split("\\?", 2);
        // 5.03 문자열 변수 path urlBits[0]번에 담긴 문자열을 저장한다.(위의 경우를 예로 들어 '삭제' 가 담긴다.  )
        this.path = urlBits[0];
//        String querystr = "search?q=라면&oq=라면&aqs=chrome.0.0i355i433i512j46i433i512j0i3j0i131i433i512j0i3l2j0i512j0i3j0i512l2.750j0j7&sourceid=chrome&ie=UTF-8";
//        String[] querystrbit = querystr.split("&");
//        System.out.println(querystrbit[0]);
        // 5.04 각각 키 - 값이 , String - String 으로 받는 맵자료형 변수 queryParams을 해시맵 객체로 연결
        queryParams = new HashMap<>();

        // 5.05 urlBits 의 길이가 2 인경우 , 단 입력어가 '삭제' 만 있으면 length 는 1이 되기 때문에 해당 조건문은 적용안된다다
        if (urlBits.length == 2) {
            //5.06 "id=5" 또는 "id=5&author="lee"" 등으로 나누어진 urlBits[1]를 변수 querystr
            String queryStr = urlBits[1];

            // 5.07 여러 조건으로 나누어진 경우를 & 기준으로 나눈다. 단 이때는 배열 제한을 결어놓지 않는다.
            String[] paramBits = queryStr.split("&");

            //5.08 배열 변수 paramBits를 각각에 조건을 for 문으로 처리
            // 5.09 가령, "id=5&author="lee""를 각각 , id=5 , author=lee 로 배열값으로 받는다.
            for (String paramBit : paramBits) {
                // 5.10 각각의 배열 값을 = 기준으로 split 한다.
                String[] paramNameAndValue = paramBit.split("=", 2);
                // 5.11 만약 각 조건에 value 를 넣지 않는 경우를 판단. id= 까지만 작성한 경우  는
                // 해당 for문 상황에서 벗어나고 다음 인자를 받는 for 문을 시도
                if (paramNameAndValue.length == 1) {
                    continue;
                }

                //5.12 각각 나누어진 id 와 5를 해시구조를 가진 queryParams에 키 - 값으로 넣는다.
                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();

                queryParams.put(paramName, paramValue);
            }
        }
    }


    public int getIntParam(String paramName, int defaultValue) {
        if (queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }

        String paramValue = queryParams.get(paramName);

        if (paramValue.length() == 0) {
            return defaultValue;
        }

        return Integer.parseInt(paramValue);
    }
    //5.03 에서 받은 path를 리턴, 이때는 삭제, 목록, 등록, 등으로 나누어진 값이다.
    public String getPath() {
        return path;
    }
}

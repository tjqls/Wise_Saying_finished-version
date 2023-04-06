package org.example;

import java.util.Scanner;

public class Container {  // 클래스 컨테이너 선언

    private static Scanner sc;  // 스캐너라는 클래스를 sc로 선언
    public static void init(){  // 클래스 컨테이너 안에있는 함수 init 생성
       sc = new Scanner(System.in);  // sc는 입력값을 받겠다.
    }

    public static void close(){  // 클래스 컨테이너 안에있는 close 함수
        sc.close();  // sc를 끝내겠다.

    }

    public static Scanner getSc(){  // 스캐너타입 함수 getSc
        return sc;  // sc값 반환
    }

}

package org.example;



public class Main {
    public static void main(String[] args) {

        Container.init();  // 컨테이너의 init함수 갖다 쓰겠다. (컨에이너의 init함수는 스캐너를 사용하겠다는것을 선언)

        new App().run();  // App클래스에서 run함수 실행하겠다.

        Container.close();  // 컨테이너의 close함수 (컨테이너의 close함수는 sc를 끝내는 함수)

    }
}
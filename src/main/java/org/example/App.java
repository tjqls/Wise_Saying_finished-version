package org.example;

import org.example.system.controller.SystemController;
import org.example.wisesaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {  //클래스 App선언

    public void run() {  // 클래스 App안에서 run함수 선언
        System.out.println("== 명언 앱 ==");  // 처음 run함수 실행시 "== 명언 앱 ==" 출력

        SystemController systemController = new SystemController();  //SystemController클래스를 여기서 갖다 쓰겠다고 선언
        WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController클래스를 갖다 쓰겠다고 선언



        while (true){  // 반복문 while(true라고 썼기때문에 무한히 반복함)
            System.out.println("명령)");  // "명언 앱" 출력 후 명령) 출력
            String command = Container.getSc().nextLine().trim(); // 문자형 command는 컨테이너의 Scanner형 sc에 문자로 넣겠다 공백 제거하고
            Rq rq = new Rq(command);  // Rq클래스 형태의 변수 rq는 command를 받아서 Rq의 생성자 함수에 값을 넣겠다.

            switch (rq.getActionCode()){  //switch문 (rq의 getActionCode함수 실행하겠다.)
                case "종료" : // command에 종료라고 입력시
                    SystemController.exit(); //SystemController의 exit함수 실행
                    return; //여기서 break이 아닌 return을 쓴 이유는 종료를 하려면 이 함수를 끝내야하는데 함수를 끝내기위해서는 returnm을 써야한다.
                case "등록" : // command에 등록이라고 입력시
                    wiseSayingController.write(); // wiseSayingController의 write함수 실행
                    break; // write함수 실행후 여기서 멈춤
                case "목록" : // command에 목록이라고 입력시
                    wiseSayingController.list(); // wiseSayingController의 list함수 실행
                    break; // list함수 실행후 여기서 멈춤
                case "삭제" : // command에 삭제라고 입력시
                    wiseSayingController.remove(rq); // wiseSayingController의 remove함수 실행
                    break;
                case "수정" : // command에 수정이라고 입력시
                    wiseSayingController.modify(rq);
            }

        }

    }
}


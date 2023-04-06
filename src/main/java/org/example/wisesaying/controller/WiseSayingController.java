package org.example.wisesaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wisesaying.entity.WiseSaying;

import java.util.ArrayList;

public class WiseSayingController {
    private int count = 1;
    ArrayList<WiseSaying> wiseSayings = new ArrayList<WiseSaying>();



    private WiseSaying findById(int id){
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.getId()==id){
                return wiseSaying;
            }
        }
        return null;
    }


    public void write() {
        System.out.println("명언을 입력해주세요.");
        String content = Container.getSc().nextLine().trim();
        System.out.println("작가를 입력해주세요.");
        String authorName = Container.getSc().nextLine().trim();

        int id=count;
        WiseSaying wiseSaying = new WiseSaying(id,content,authorName);

        wiseSayings.add(wiseSaying);

        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;
    }

    public void list() {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("-".repeat(30));

        for(int i= wiseSayings.size()-1; i>=0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.println(wiseSaying.getId() + "/" + wiseSaying.getContent() + "/" + wiseSaying.getAuthorName());


        }
        System.out.println("총 등록된 명언 갯수는 " + wiseSayings.size() + "개 입니다.");
    }

    public void remove(Rq rq) {
        int id = rq.getIntparam("id",-1);

        if(id == -1){
            System.out.println("정수를 입력해주세요");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if(wiseSaying== null){
            System.out.println("삭제할 명언이 존재하지 않습니다.");
        }

        wiseSayings.remove(wiseSaying);
        System.out.println(id+ "번 명언이 삭제되었습니다.");

    }


    public void modify(Rq rq) {
        int id=rq.getIntparam("id",-1);

        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null){
            System.out.println("수정할 명언이 없습니다");
            return;
        }

        System.out.println("기존 명언 : " + wiseSaying.getContent());
        System.out.println("명언 수정)");
        String content = Container.getSc().nextLine().trim();

        System.out.println("기존 작가 : " + wiseSaying.getAuthorName());
        System.out.println("작가 수정)");
        String authorName = Container.getSc().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);

        System.out.println(id + "번 명언이 수정되었습니다.");

    }
}

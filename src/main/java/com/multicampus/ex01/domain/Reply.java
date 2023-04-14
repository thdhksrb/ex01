package com.multicampus.ex01.domain;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "Reply", indexes = {
        @Index(name = "idx_reply_board_bno", columnList = "board_bno")
})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")          //Board 타입의 객체 참조를 board 라는 변수를 이용해서 참조하겠다.
//@ToString
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)  //하나의 Entity를 조회할때 연관관계에 있는 객체들을 어떻게 가져올것인지에 대한 설정값(연관관계 모든 Entity)
    private Board board;

    private String replyText;

    private String replyer;

    public void changeText(String text){
        this.replyText = text;
    }

}


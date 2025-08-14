package com.kh.app22.board.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BOARD")
@SequenceGenerator(name = "abc", sequenceName = "SEQ_BOARD", allocationSize = 1)
//generator = "abc" : 시퀀스 생성기 / 이름짓기
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abc")
    private Long no;

    private String title;
    private String content;
}

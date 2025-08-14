package com.kh.app22.notice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name = "NOTICE")
@SequenceGenerator(name = "notice_gen", sequenceName = "SEQ_NOTICE", allocationSize = 1)
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_gen")
    private Long no;
    private String title;
    private String content;
}

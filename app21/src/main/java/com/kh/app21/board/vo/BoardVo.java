package com.kh.app21.board.vo;

import lombok.Data;

@Data
public class BoardVo {
    private Long no;
    private String title;
    private String content;
    private Long hit;
}

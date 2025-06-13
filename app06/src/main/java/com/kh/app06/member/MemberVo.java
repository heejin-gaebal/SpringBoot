package com.kh.app06.member;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String createdDate;
    private String delYn;
}

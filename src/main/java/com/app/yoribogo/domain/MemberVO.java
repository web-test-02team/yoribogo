package com.app.yoribogo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;


import java.io.Serializable;

@Component
@Data
public class MemberVO  implements Serializable{
    private Long id;
    private String memberEmail;
    private String memberKakaoEmail;
    private String memberPassword;
    private String memberName;
    private String memberKakaoProfileUrl;
    private String memberProfileName;
    private String memberProfilePath;
    private boolean memberStatus;
    private String memberLoginCode;
}

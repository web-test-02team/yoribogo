package com.app.yoribogo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MessageVO implements Serializable {
    private Long id;
    private String messageCheck;
    private String messageSendDate;
    private String messageReadDate;
//    TBL_MEMBER의 PK를 이렇게 다른 이름 2개로 참조해도 되는지 강사님께 여쭤보기:)
    private Long senderId;
    private Long receiverId;
}

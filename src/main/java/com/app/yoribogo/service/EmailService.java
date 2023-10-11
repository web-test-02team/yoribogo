package com.app.yoribogo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String recipientEmail,String Name) {

        try {
            String token = TokenManager.generateToken(recipientEmail);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); // true를 사용하여 HTML 메일을 사용하도록 설정

            helper.setTo(recipientEmail); // 수신자 이메일 주소
            helper.setSubject("[요리보고] 비밀번호를 재설정 해주세요."); // 이메일 제목

            // HTML 형식의 본문 설정
            String htmlContent =
                     "<html>" +
                    "<body>" +
                    "<div style=\"padding:0 0 40px;\">" +
                    "<div>" +
                    "<div style=\"font-size:24px; line-height:36px; letter-spacing:-0.025em; margin: 0 0 40px; padding: 0 0 32px; border-bottom: 1px solid #E6E6E7\">" +
                    "</div>" +
                    "<div style=\"padding: 0 32px;\">" +
                    "<p style=\"font-weight: 700; font-size: 24px; line-height: 34px; text-align: center; color: #1D1D1E; margin: 0 0 16px;\">" +
                    "비밀번호 재설정" +
                    "</p>" +
                    "<div style=\"margin: 0;\">" +
                    "<p style=\"font-size: 16px; line-height: 22px; text-align: center; color: #333334;\">" +
                             "<strong>" + Name + "</strong>님 안녕하세요. 요리보고입니다.<br>" +
                    "아래 버튼을 선택하여 비밀번호를 재설정해주세요." +
                    "</p>" +
                    "</div>" +
                    "<div style=\"text-align: center; margin: 32px 0 0;\">" +
                    "<a href='http://localhost:10000/member/findPasswordSend?token=" + token + "' style=\"display: inline-block; margin: 0 40px; text-decoration: none; border: 0; padding: 10px 20px; font-size: 14px; font-weight: 600; color: #ffffff; background: #7e69fe; border-radius: 20px;\" rel='noreferrer noopener' target='_blank'>" +
                    "비밀번호 재설정 링크" +
                    "</a>" +
                    "</div>" +
                   "<p style=\"font-weight: 400; font-size: 14px; line-height: 20px; text-align: center; color: #333334;\">비밀번호 재설정 링크는 1시간 동안 유효합니다." +
                   "</p>"+
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>";
            helper.setText(htmlContent, true); // 두 번째 매개변수를 true로 설정하여 HTML 사용

            // 이메일 보내기
            javaMailSender.send(message);
        } catch (MessagingException e) {
            // 이메일 전송 실패 시 예외 처리
            e.printStackTrace();
            // 예외 처리 코드를 추가하여 필요한 작업을 수행하세요.
        }
        }
    }



package com.app.yoribogo.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
@Slf4j
public class KaKaoService {
    public String getKaKaoAccessToken(String code){
        String accessToken = null;
//        카카오 로그인 토근받기
        String requestURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=7f45ae3dbdabcd003d1e4ff2171184c3"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:10000/kakao/login"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            if(connection.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                accessToken = element.getAsJsonObject().get("access_token").getAsString();

                br.close();
                bw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return accessToken;
    }

//    public Optional<MemberVO> getKaKaoInfo(String token){
//            //사용자 정보 가져오기
//        String requestURL = "https://kapi.kakao.com/v2/user/me";
//        MemberVO memberVO = null;
//
//        try {
//            URL url = new URL(requestURL);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//            connection.setRequestProperty("Authorization", "Bearer " + token);
////성공 일때
//            if(connection.getResponseCode() == 200){
//                memberVO = new MemberVO();
//                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String line = null;
//                String result = "";
//
//                while((line = br.readLine()) != null){
//                    result += line;
//                }
//
//                JsonElement element = JsonParser.parseString(result);
//                JsonElement kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
//                JsonElement profile = kakaoAccount.getAsJsonObject().get("profile").getAsJsonObject();
////카카오에서 받은 것들 가져오기
//                memberVO.setMemberKakaoEmail(kakaoAccount.getAsJsonObject().get("email").getAsString());
//                memberVO.setMemberName(profile.getAsJsonObject().get("nickname").getAsString());
//                memberVO.setMemberKakaoProfileUrl(profile.getAsJsonObject().get("thumbnail_image_url").getAsString());
//                memberVO.setMemberLoginCode("KAKAO");
//
//                br.close();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return Optional.ofNullable(memberVO);
//    }
}

package com.app.yoribogo.service;

import com.app.yoribogo.dao.MemberDAO;
import com.app.yoribogo.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public void join(MemberVO memberVO, RedirectAttributes redirectAttributes,Long id) {

        //        1. 일반회원, 카카오회원 구분
        if(memberVO.getMemberKakaoProfileUrl() != null){ //카카오 로그인
            Optional<MemberVO> foundMember = getKaKaoMember(memberVO.getMemberKakaoEmail());
            List<MemberVO> foundKakaos= kakaEmailALL();
            log.info("{}",id);
            if(id != null){
                log.info("아이디 :{}",foundMember);
                boolean isKakaoMemberExist =    (foundMember != null && foundMember.isPresent()) &&
                        (foundKakaos != null && foundKakaos.stream()
                                .filter(member -> member != null && member.getMemberKakaoEmail() != null)
                                .anyMatch(member -> memberVO.getMemberKakaoEmail().equals(member.getMemberKakaoEmail())));
                log.info("{}",isKakaoMemberExist);
                if (isKakaoMemberExist) {
                    log.info("들어옴");
                 redirectAttributes.addFlashAttribute("kakao", false);
                }
                else{
                    memberVO.setId(id);
                    synchronize(memberVO);
                    return;
                }
            }
//          1-2. 최초 로그인 검사
            if(foundMember.isEmpty()){
                memberDAO.save(memberVO);
            }else{ // 이메일 정보가 있을 경우
                MemberVO member = foundMember.get();
//              1-3. 카카오회원일 경우 프사 검사
                if(member.getMemberProfileName() == null){// 전달받은 프사경로로 수정
//                    전달받은 카카오 프사로 업데이트
                    updateKaKaoProfile(memberVO);
                }
            }
        }else {
            Optional<MemberVO> foundEmail = searchEmail(memberVO);
            if (foundEmail.isPresent()) {
                // 이메일이 중복되면 로그인 실패 메시지를 전달
                redirectAttributes.addFlashAttribute("login", false);
                return;
            }
            // 중복된 이메일이 없는 경우 회원 가입을 진행
            memberVO.setMemberLoginCode("YORIBOGO");
            memberDAO.save(memberVO);
        }

    }


    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }

    @Override
    public Optional<MemberVO> searchEmail(MemberVO memberVO) {
        return memberDAO.searchEmail(memberVO);
    }

    @Override
    public void change(String memberEmail, String memberPassword) {
        memberDAO.change(memberEmail,memberPassword);
    }

    @Override
    public Optional<MemberVO> getKaKaoMember(String memberKakaoEmail) {
        return memberDAO.findByKakaoEmail(memberKakaoEmail);
    }
        @Override
        public void updateKaKaoProfile(MemberVO memberVO) {
            memberDAO.setKaKaoProfile(memberVO);
        }

    @Override
    public void synchronize(MemberVO memberVO) {
        memberDAO.updateBySync(memberVO);
    }

    @Override
    public void delete(Long id) {
        memberDAO.delete(id);
    }

    @Override
    public List<MemberVO> kakaEmailALL() {
        return memberDAO.kakaEmailALL();
    }
}

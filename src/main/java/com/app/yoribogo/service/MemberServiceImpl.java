package com.app.yoribogo.service;

import com.app.yoribogo.dao.MemberDAO;
import com.app.yoribogo.domain.MemberDTO;
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
//            카카오와 memberEmail 리스트
            List<MemberVO> foundKakaos= kakaEmailALL();
//           foundMember 카카오계정 가지고옴 db에서 연동할때 는 null
//            연동을 누른 녀석은 id
            log.info("id:{}",id);
            if (id != null) {
                String kakaoEmail = memberVO.getMemberKakaoEmail();
                if (foundKakaos.stream().noneMatch(member ->
                        member != null && member.getMemberKakaoEmail() != null &&
                                kakaoEmail != null && kakaoEmail.equals(member.getMemberKakaoEmail()) &&
                                member.getMemberEmail() != null)) {
                    // 리스트에서 카카오 이메일과 일치하고, 멤버 이메일이 null인 경우
                    Long oldId = null; // 초기값을 null로 설정
                    if (foundMember.isPresent()) { // foundMember가 비어 있지 않은 경우에만 oldId 설정
                        oldId = foundMember.get().getId();
                    }
                    if (oldId != null) {
                        log.info("카카오db에 있을때");
                        updateComment(oldId, id);
                        updateLike(oldId, id);
                        updatePurchase(oldId, id);
                        updateById(oldId, id);
                        memberVO.setId(id);
                        delete(oldId);
                        synchronize(memberVO);
                        return;
                    } else {
                        log.info("카카오이메일이 db에없을때");
                        memberVO.setId(id);
                        synchronize(memberVO);
                        return;
                    }
                } else {
                    // 리스트에서 카카오 이메일과 일치하지 않거나, 멤버 이메일이 null이 아닌 경우
                    redirectAttributes.addFlashAttribute("kakao", false);
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

    @Override
    public void updateById(Long oldMemberId,Long newMemberId) {
        memberDAO.updateById(oldMemberId,newMemberId);
    }

    @Override
    public void updatePurchase(Long oldMemberId, Long newMemberId) {
        memberDAO.updatePurchase(oldMemberId,newMemberId);
    }

    @Override
    public void updateLike(Long oldMemberId, Long newMemberId) {
        memberDAO.updateLike(oldMemberId,newMemberId);
    }

    @Override
    public void updateComment(Long oldMemberId, Long newMemberId) {
        memberDAO.updateComment(oldMemberId,newMemberId);
    }

    @Override
    public List<MemberDTO> findByMember(Long memberId) {
        return memberDAO.findByMember(memberId);
    }

    @Override
    public Optional<MemberVO> selectById(Long id) {
        return memberDAO.selectById(id);
    }
    @Override
    public void  toggleLikeStatus(Long id){
//        boolean isLiked = memberDAO.isLiked(id);
//
//        // 좋아요 상태 토글
//        if (isLiked) {
//            memberDAO.decreaseLikeCount(id);
//        } else {
//            memberDAO.increaseLikeCount(id);
//        }
    }

}

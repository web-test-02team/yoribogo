package com.app.yoribogo.service;

import com.app.yoribogo.domain.MemberDTO;
import com.app.yoribogo.domain.MemberVO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    //회원가입
    public void join(MemberVO memberVO , RedirectAttributes redirectAttributes,Long id);
    //로그인
    public Optional<MemberVO> login(MemberVO memberVO);
    //이메일 찾기
    public Optional<MemberVO> searchEmail(MemberVO memberVO);
    //비밀번호 변경
    public void change(String memberEmail,String memberPassword);
    //    카카오 회원 정보 조회
    public Optional<MemberVO> getKaKaoMember(String memberKakaoEmail);
    //카카오 프사 수정
    public void updateKaKaoProfile(MemberVO memberVO);
    //    카카오 연동하기
    public void synchronize(MemberVO memberVO);

    //    회원 삭제
    public void delete(Long id);

    //카카오 이메일 중복
    public List<MemberVO> kakaEmailALL();

    public void updateById(Long oldMemberId,Long newMemberId);

    public void updatePurchase(Long oldMemberId,Long newMemberId);

    public void updateLike(Long oldMemberId,Long newMemberId);

    public void updateComment(Long oldMemberId,Long newMemberId);

    public List<MemberDTO> findByMember(Long id);

    public Optional<MemberVO> selectById(Long id);

}

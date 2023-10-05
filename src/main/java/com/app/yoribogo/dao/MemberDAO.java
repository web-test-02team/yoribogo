package com.app.yoribogo.dao;

import com.app.yoribogo.domain.MemberDTO;
import com.app.yoribogo.domain.MemberVO;
import com.app.yoribogo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {

        memberMapper.insert(memberVO);
    }
    public Optional<MemberVO> login(MemberVO memberVO){
        return memberMapper.selectByLogin(memberVO);
    }

    public Optional<MemberVO> searchEmail(MemberVO memberVO){
        return  memberMapper.selectByEmail(memberVO);
    }
    public void change(String memberEmail,String memberPassword){
        memberMapper.update(memberEmail,memberPassword);
    }
    public Optional<MemberVO> findByKakaoEmail(String memberKakaoEmail){
        return memberMapper.selectKaKao(memberKakaoEmail);
    }
    public void setKaKaoProfile(MemberVO memberVO){
        memberMapper.updateKaKaoProfile(memberVO);
    }
    public void updateBySync(MemberVO memberVO){
        memberMapper.updateBySync(memberVO);
    }
    public void delete(Long id){
        memberMapper.delete(id);
    }
    public List<MemberVO> kakaEmailALL(){
      return  memberMapper.kakaEmail();
    }

    public void updateById(Long oldMemberId,Long newMemberId){
         memberMapper.updateALL(oldMemberId,newMemberId);
    }

    public void updatePurchase(Long oldMemberId,Long newMemberId){
        memberMapper.updatePurchase(oldMemberId,newMemberId);
    }

    public void updateLike(Long oldMemberId,Long newMemberId){
        memberMapper.updateLike(oldMemberId,newMemberId);

    }

    public void updateComment(Long oldMemberId,Long newMemberId){
        memberMapper.updateComment(oldMemberId,newMemberId);
    }
    public List<MemberDTO> findByMember(Long memberId){
        return memberMapper.select(memberId);
    }
}

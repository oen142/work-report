package com.wani.workreport.member.application;

import com.wani.workreport.member.domain.MemberRepository;
import com.wani.workreport.member.dto.MemberRequest;
import com.wani.workreport.member.dto.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberResponse createMember(MemberRequest request) {
        return null;
    }

    public MemberResponse findMember(Long id) {
        return null;
    }

    public void updateMember(Long id, MemberRequest param) {

    }

    public void deleteMember(Long id) {

    }
}

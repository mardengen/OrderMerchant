package com.framework.service;

import com.framework.dto.MemberDTO;
import com.framework.entity.Member;
import com.framework.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public MemberDTO addMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member = memberRepository.save(member);
        memberDTO.setId(member.getId());
        return memberDTO;
    }

    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member = memberRepository.save(member);
        return memberDTO;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public MemberDTO getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        return memberDTO;
    }

    public List<MemberDTO> getAllMembers(int page, int size) {
        return memberRepository.findAll().stream()
                .skip(page * size)
                .limit(size)
                .map(member -> {
                    MemberDTO memberDTO = new MemberDTO();
                    memberDTO.setId(member.getId());
                    memberDTO.setName(member.getName());
                    memberDTO.setEmail(member.getEmail());
                    return memberDTO;
                }).collect(Collectors.toList());
    }
}
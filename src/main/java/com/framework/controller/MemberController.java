package com.framework.controller;

import com.framework.dto.MemberDTO;
import com.framework.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    public String showMembers(Model model) {
        List<MemberDTO> members = memberService.getAllMembers(0, 10);
        model.addAttribute("members", members);
        return "/members.html";  // 確保這個路徑對應到您的模板名稱
    }


    @PostMapping
    public String addMember(@RequestBody MemberDTO memberDTO, Model model) {
        memberService.addMember(memberDTO);
        return "redirect:/members";
    }

    @PutMapping("/{id}")
    public String updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO, Model model) {
        memberService.updateMember(id, memberDTO);
        return "redirect:/members";
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }

    @GetMapping("/{id}")
    public String getMember(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.getMember(id);
        model.addAttribute("member", memberDTO);
        return "member";
    }

    @GetMapping
    public String getAllMembers(@RequestParam int page, @RequestParam int size, Model model) {
        List<MemberDTO> members = memberService.getAllMembers(page, size);
        model.addAttribute("members", members);
        return "members";
    }
}

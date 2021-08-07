package kr.or.connect.reservation.controller;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.Member;
import kr.or.connect.reservation.service.MemberService;

@Controller
@RequestMapping(path = "/users")
public class MemberController {
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }
	
	@GetMapping("/loginform")
    public String loginform(){
        return "users/loginform";
    }

    @GetMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "users/loginerror";
    }

    @GetMapping("/joinform")
    public String joinform(){
        return "users/joinform";
    }

    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public String join(@ModelAttribute Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member, false);
        return "redirect:/users/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "users/welcome";
    }

    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap){
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        member.setPassword("****");
        modelMap.addAttribute("member", member);

        return "users/memberinfo";
    }
}

package kr.or.ddit.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(UserVo userVo, Model model) { 
		
		model.addAttribute("userVo", userVo);
		
		if("brown".equals(userVo.getUserId()) && "brownpass".equals(userVo.getPass())) {
			return "main";
		}else {
			return "login/login";
		}
		
		
		
	}
	
}

package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	// userService 스프링 빈 주입
	@Resource(name="userService")
	private UserServiceInf userService;

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
	
	/**
	* Method : userAllList
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@RequestMapping("userAllList")
	public String userAllList(Model model) {
		
		// userService 사용자 전체 정보조회
		List<UserVo> userList = userService.selectUserAll();
		
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
	}

	@RequestMapping("/userPageList")
	public String userPageList(/*Model model, PageVo pageVo*/) {
		
		// spring 컨테이너로부터 bean을 주입받기 때문에 new 연산자를 통해 생성할 필요 없음
		
		// controller method 매개변수로 선언
		
//		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
//		model.addAllAttributes(resultMap);
		
		
		return "user/userPageList";
	}
	
	@RequestMapping("/userPageListAjax")
	public String userPageListAjax(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	@RequestMapping("/userPageListAjaxHtml")
	public String userPageListAjaxHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/pageListHtml";
	}
	
	@RequestMapping("/userPagenationHtml")
	public String userPagenationHtml(Model model, PageVo pageVo) {
		
		/*
		 * Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		*/
		
		return "user/userPageList";
	}
	
	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId")String userId, Model model) {
		
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute("userVo", userVo);
		
		return "user/userDetail";
	}
	
	@RequestMapping(value= {"/userForm"}, method= RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
		
	}
	
	@RequestMapping(value= {"/userForm"}, method= RequestMethod.POST)
	public String userForm(@RequestPart("profilePic")MultipartFile part, HttpServletRequest request, UserVo userVo) {
		
		
		try {
			if(part.getSize() > 0) {
			String path = request.getServletContext().getRealPath("/profile");
			
			String fileName = part.getOriginalFilename();
			
			part.transferTo(new File(path + File.separator + fileName));
			
			userVo.setProfile("/profile/" + fileName);
			
			}else {
				userVo.setProfile("");
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
	
	@RequestMapping(value= {"/userUpdateForm"}, method= RequestMethod.GET)
	public String userUpdateForm(@RequestPart("userId")String userId, Model model) {
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute(userVo);
		
		return "user/userUpdateForm";
	}
	

		
		
}












package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/**
	* Method : main
	* �ۼ��� : pc23
	* �����̷� :
	* @return
	* Method ���� : main ȭ�� ��û
	*/
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
}

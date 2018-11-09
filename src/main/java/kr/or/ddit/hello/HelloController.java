package kr.or.ddit.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

/*
 * servlet
 * 1. HttpServlet Ŭ������ ���
 * 2. @WebServlet Ȥ�� web.xml�� url-mapping ���
 * 3. doGet, doPost ���� doXXX�޼ҵ带 ���� ���񽺸� ����
 * 
 * spring controller
 * 1. @Controller ������̼� ����
 * 2. @RequestMapping ������̼� ����(class / method)
 */

@RequestMapping("/hello")
@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(HelloController.class);

	// ����� ��û : localhost:8081/hello/hello.do url�� ��û�� �ϰ� �Ǹ�
	// �Ʒ��� �޼��忡�� ��û�� ó��
	// ���� class�� ������ @RequestMapping("/hello") �κ��� ���� �ϰ� �Ǹ�
	// localhost:8081/hello.do url�� ��û�� ���� hello() �޼��忡�� ��û�� ó���ϰԵ�
	@RequestMapping("/hello.do")
	public String hello() {

		// viewName�� ����
		// internalResourceViewResolver ������ ����
		// prefix + viewName + suffix ��ġ�� ���ҽ���
		// ���� �����Ѵ�.
		// prefix : /WEB-INF/view
		// suffix : .jsp
		// viewName : hello
		// ==> /WEB-INF/view/hello.jsp
		// �⺻ : forward
		return "hello";
	}

	/*
	 * servlet doGet, doPost : �޼��� ���ڰ� HttpServletRequest, HttpServletResponse'
	 * spring controller �޼��� : ���� �����Ӱ� ������ ���� HttpServletRequest,
	 * HttpServletResponse, HttpSession, ValueObject, Model : view���� ǥ���� �����͸� ����
	 */
	@RequestMapping("/model")
	public String model(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");

		// servlet : request.setAttribute("rangers", rangers);
		model.addAttribute("rangers", rangers);

		return "hello";
	}

	@RequestMapping("/request")
	public String request(HttpServletRequest request, Model model) {

		// ���� servlet �Ķ���� Ȯ�� ���
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		model.addAttribute("userId", userId + "_attr");
		model.addAttribute("pass", pass + "_attr");
		
		// logger�� �̿��� ���
		logger.debug("userId : {}", userId);
		logger.debug("pass : {}", pass);

		return "hello";
	}
	
	// value object�� �Ӽ��̸��� ������ �̸��� �Ķ���͸� �ڵ����� �������ش�.
	@RequestMapping("/vo")
	public String vo(UserVo userVo, Model model) {
		
		logger.debug("userVo : {}", userVo);
		
		model.addAttribute("userVo", userVo);
		
		return "hello";
	}
	
	// spring mvc controller �޼ҵ��� ����Ÿ��
	// 1. String : viewName
	// 2. ModelAndView : ������ ���� ��ü
	// 3. void : response ��ü�� �����ڰ� ���� ������ �ۼ�
	// ModelAndView
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(Model model) {
		ModelAndView mav = new ModelAndView();
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		// model.addAttribute("rangers", rangers);
		mav.addObject("rangers", rangers);
		
		// model
		model.addAttribute("rangers", rangers);
		
		// viewName
		mav.setViewName("hello");
		
		
		return mav;
	}
	
	// void
	@RequestMapping("/void")
	public void voidMethod(HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		
		writer.write("<html>");
		writer.write("spring");
		writer.write("<html>");
		
	}
	
	@RequestMapping("/exception")
	public String view() {
		
		throw new ArithmeticException();
		
	}
}

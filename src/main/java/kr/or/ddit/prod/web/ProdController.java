package kr.or.ddit.prod.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.prod.service.ProdServiceInf;

@RequestMapping("/prod")
@Controller
public class ProdController {

	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	
	
}

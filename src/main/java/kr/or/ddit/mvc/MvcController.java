package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

// @ModelAttribute�� ���� ����� �Ӽ��� �������
// �� ��û�� @ModelAttribute�� ����� �޼��带 ��������� �ʰ�
// ���ǿ� �����Ͽ� ���� ��Ȱ��(�� ������� �ʴ� ���� ������ ��� �޼��尡 �Ź� ȣ��Ǵ� �����ϸ� �� �� �� �ִ�.)
@SessionAttributes("rangers")
@Controller
public class MvcController {
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	// @RequestMapping�� ���� �޼��尡 ����Ǳ� ���� ���� �����
	// �ش� ��Ʈ�ѷ����� ���������� ���� �Ӽ��� �������
	// �ߺ��� ���ϱ����� @ModelAttribute ������̼��� ������
	// �޼��带 ���� �ڵ� �ߺ��� ���� �� ����
	
	
	@ModelAttribute(value="rangers")
	//public void setUp(Model model) {
	public List<String> setUp() {
		logger.debug("{}", "setUp");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
//		model.addAttribute("rangers", rangers);
		return rangers;
	}

	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
		for(String ranger : rangers) {
			logger.debug("ranger : {}", ranger);
		}
		rangers.add("james");
		
		return "mvc/view";
	}
	
	@RequestMapping("/mvc/view2")
	public String mvcView2() {
		
		return "mvc/view2";
	}
	
	
	//@pathvariable : ��û url�� �Ϻθ� �޼��� ���ڷ� ���� ���� �� �ִ� ������̼�
	// http://localhost:8081/mvc/central : logger central
	// http://localhost:8081/mvc/left : logger left
	@RequestMapping("/mvc/{libcd}")
	public String pathvariable(@PathVariable("libcd") String libcd) {
		logger.debug("libcd : {}", libcd);
		return "mvc/view";
	}
	
	// fileupload �׽�Ʈ�� ���� view (get)
	@RequestMapping(value="/mvc/fileupload", method= {RequestMethod.GET})
	public String fileuploadView() {
		return "mvc/fileuploadView";
	}
	
	@RequestMapping(value="/mvc/fileupload", method= {RequestMethod.POST})
	// fileupload (���� ����)�� ó�� �ϱ����� controller method(post)
	public String fileupload(@RequestPart("uploadFile") MultipartFile part, @RequestParam("userId")String userId) {
		
		logger.debug("requestParam userId : {}", userId);
		
		logger.debug("partSize : {}", part.getSize());
		logger.debug("originalFilename : {}", part.getOriginalFilename());
		
		// 1. File��ü ����(��� + ���ϸ� ==> ���ϸ� �浹 ������ ���� ����ũ �� �� ������ ���ϸ��� ����)
		//
		
		String path = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload";
		String orginamFileName = part.getOriginalFilename();	// ����ڰ� ���ε��� ���� ���ϸ�
		String fileExt = FileUtil.getFileText(orginamFileName);
		String fileName = UUID.randomUUID().toString() + fileExt;					// �浹 ������ ���� ������ ���ϸ�
		File file = new File(path + File.separator + fileName);
		
		FileVo fileVo = new FileVo();
		fileVo.setFile_name(fileName);
		fileVo.setFile_path(path);
		fileVo.setOrg_file_name(orginamFileName);
		fileVo.setFile_ext(fileExt); 
		
		logger.debug("fileVo : {}", fileVo);
		
		try {
			if (part.getSize() > 0) {
				// ������ path�� ���ε� ������ �ۼ�
				part.transferTo(file);

				// ������ ���̽��� ÷������ ���� ����
				// 1. fileService
				// 2. ����ȣ��
				int insertCnt = fileService.insertFile(fileVo);
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return "mvc/fileuploadView";
	}	
	
}













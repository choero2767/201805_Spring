package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

public class FileDaoTest extends ServiceDaoTestConfig{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* �ۼ��� : pc23
	* �����̷� :
	* Method ���� : �������� �Է� �׽�Ʈ
	*/

	@Test(timeout=5000)
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("sally.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload");

		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}

}

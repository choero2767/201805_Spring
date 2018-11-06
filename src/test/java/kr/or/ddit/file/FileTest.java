package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.file.util.FileUtil;

public class FileTest {

	// 테스트 코드를 운영코드보다 먼저 작성하는 방법
	// Test Driven Development (TDD)
	/**
	* Method : getFileExtExists
	* 작성자 : pc23
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 있는경우)
	*/
	@Test
	public void getFileExtExists() {
		/***Given***/
		String fileName = "sally.png";

		/***When***/
		String ext = FileUtil.getFileText(fileName);
		
		/***Then***/
		assertEquals(".png", ext);
		
	}

	/**
	* Method : getFileExtNotExists
	* 작성자 : pc23
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 없는경우)
	*/
	@Test
	public void getFileExtNotExists() {
		/***Given***/
		String fileName = "sally.png";

		/***When***/
		String ext = FileUtil.getFileText(fileName);
		
		/***Then***/
		assertEquals(".png", ext);
		
	}
	
}

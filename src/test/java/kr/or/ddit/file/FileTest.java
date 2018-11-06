package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.file.util.FileUtil;

public class FileTest {

	// �׽�Ʈ �ڵ带 ��ڵ庸�� ���� �ۼ��ϴ� ���
	// Test Driven Development (TDD)
	/**
	* Method : getFileExtExists
	* �ۼ��� : pc23
	* �����̷� :
	* Method ���� : ���� Ȯ���� ����(Ȯ���ڰ� �ִ°��)
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
	* �ۼ��� : pc23
	* �����̷� :
	* Method ���� : ���� Ȯ���� ����(Ȯ���ڰ� ���°��)
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

package kr.or.ddit.file.util;

public class FileUtil {
	
	// FileUtil.getFileExt(String fileName);
			// Ȯ���ڰ� ������� .�� ������ Ȯ���� ���� ����
			// Ȯ���ڰ� ���� ��� "" whitespace�� ����
			// �׽�Ʈ�� : sally.png ==> .png
			// �׽�Ʈ�� : sally == ""
	
	/**
	* Method : getFileText
	* �ۼ��� : pc23
	* �����̷� :
	* @param fileName
	* @return
	* Method ���� : ���� Ȯ���� ����
	*/
	public static String getFileText(String fileName) {
		
		String[] split = fileName.split("\\.");
		
		if(split.length == 1) {
			return "";// Ȯ���ڰ� ���� ���
		}else {
			return "." + split[split.length-1];
		}
		
	}
	
	
	
	
}

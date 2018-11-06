package kr.or.ddit.file.util;

public class FileUtil {
	
	// FileUtil.getFileExt(String fileName);
			// 확장자가 있을경우 .을 포함한 확장자 값을 리턴
			// 확장자가 없을 경우 "" whitespace를 리턴
			// 테스트값 : sally.png ==> .png
			// 테스트값 : sally == ""
	
	/**
	* Method : getFileText
	* 작성자 : pc23
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일 확장자 추출
	*/
	public static String getFileText(String fileName) {
		
		String[] split = fileName.split("\\.");
		
		if(split.length == 1) {
			return "";// 확장자가 없는 경우
		}else {
			return "." + split[split.length-1];
		}
		
	}
	
	
	
	
}

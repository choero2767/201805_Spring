package kr.or.ddit.file.dao;

import kr.or.ddit.file.model.FileVo;

public interface FileDaoInf {
	
	/**
	* Method : insertFile
	* 작성자 : pc23
	* 변경이력 :
	* @param fileVe
	* @return
	* Method 설명 : 파일 정보 저장
	*/
	int insertFile(FileVo fileVo);
}

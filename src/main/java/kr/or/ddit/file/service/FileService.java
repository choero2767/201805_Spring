package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

@Service
public class FileService implements FileServiceInf{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	public FileService() {
		
	}
	
	/**
	* Method : insertFile
	* 작성자 : pc23
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		return fileDao.insertFile(fileVo);
	}
	
}

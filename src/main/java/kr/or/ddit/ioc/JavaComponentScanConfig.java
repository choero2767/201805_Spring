package kr.or.ddit.ioc;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;

@Configuration
@ComponentScan(basePackages= {"kr.or.ddit.board"})
public class JavaComponentScanConfig {
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	/**
	* Method : javaConfigBeanTest
	* 작성자 : pc23
	* 변경이력 :
	* Method 설명 : javaconfig를 통해 스프링 빈이 정상적으로 생성 되었는지 테스트
	*/
	@Test
	public void javaConfigBeanTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
	}

}

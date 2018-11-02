package kr.or.ddit.ioc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {
	
	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	
	public static void main(String[] args) {
		
		// ������ �����̳� ����
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {
					"classpath:kr/or/ddit/ioc/application-context.xml"
				});
		
		// ������ �����̳ʿ��� boardDao ������ ���� ��û(DL : Dependency Lookup)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVo : {}, {}" , boardVo, "test");
//			System.out.println("boardVo : " + boardVo);
		}	
		
		// ������ �����̳ʿ��� boardService ������ ���� ��û�� selectBoardList
		// ����� logger�� �̿��� console ���
		BoardServiceInf boardService = (BoardServiceInf)context.getBean("boardService");
		List<BoardVo> boardList2 = boardService.selectBoardList();
		
		for(BoardVo boardVo2 : boardList) {
			logger.debug("boardVo : {} ", boardVo2);
		}
		
		
		// ������ ������ ���� ������ boardService ������ ���� ��û
		BoardServiceInf boardServiceConst = (BoardServiceInf)context.getBean("boardServiceConst");
		boardList2 = boardServiceConst.selectBoardList();
		
		for(BoardVo boardVo2 : boardList) {
			logger.debug("boardVo : {} ", boardVo2);
		}
		
		// spring scope-prototype test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);

		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);
		
		logger.debug("spring prototype bean test : {}", boardDaoPrototype1==boardDaoPrototype2);
		
		
		// spring scope-singleton test
		BoardDaoInf boardDaoSingleton1 = context.getBean("boardDaoSingleton1", BoardDaoInf.class);
		BoardDaoInf boardDaoSingleton2 = context.getBean("boardDaoSingleton2", BoardDaoInf.class);
		
		logger.debug("spring singleton bean test : {}", boardDaoSingleton1==boardDaoSingleton2);
		
		
	}
}

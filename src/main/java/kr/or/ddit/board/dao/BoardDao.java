package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

// ������̼��� ���� �� ���
// bean ������̼��� : @Controller, @Service, @Repository, @Component
// @Controller : controller
// @Service : service
// @Respository : dao
// @Component : �Ϲ����� ��ü
// @Controller, @Service, @Repository ������̼��� @Component ������̼��� 
//												������� Ȯ��
// ������̼� ��ü�� Ư���� ����� ��� �ִ� ���� �ƴ�
// ���߿� ���� ���Ǵ� ����� �и��Ͽ� ����� �Ϳ� �Ұ�

// �̸��� �����ϸ� Ŭ���� ù ���ڸ� �ҹ��ڷ� �� �̸��� spring bean �̸��� ��
@Repository("boardDao")
public class BoardDao implements BoardDaoInf{

	public List<BoardVo> selectBoardList() {
		// db���� ��ȸ �ؿ� �����Ͷ�� ��������
		BoardVo boardVo = new BoardVo(1, "�����Խ���", "brown");
		BoardVo boardVo2 = new BoardVo(2, "��������", "cony");
		BoardVo boardVo3 = new BoardVo(3, "FAQ", "sally");
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList.add(boardVo);
		boardList.add(boardVo2);
		boardList.add(boardVo3);
		
		return boardList;
	}

}

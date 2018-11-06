package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

// spring bean���� ��� : @Repository(�̸��� �Ⱥ��̸� class���� �ձ��ڸ� �ҹ��ڷ� ������ �ؽ�Ʈ�� spring bean �̸�)
@Repository // fileDao
public class FileDao implements FileDaoInf{

	private SqlSessionFactory sessionFactory;
	
	public FileDao() {
		sessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	}
	
	/**
	* Method : insertFile
	* �ۼ��� : pc23
	* �����̷� :
	* @param fileVe
	* @return
	* Method ���� : ���� ���� ����
	*/

	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession session = sessionFactory.openSession();
		
		// sql ȣ��
		int insertCnt = session.insert("file.insertFile", fileVo);
		
		// Ʈ����� commit, session close
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	
	//�����Ʈ����� : �����ڰ� commit,rollback ���� ���
	//������Ʈ����� : Ư��ȯ�濡�� Ʈ������� �̷��������
//	                   (*Service �̸��� ���� ��ü�� ��� �޼ҵ忡��
//					     Ʈ������� �̷��������
//						 ���ܰ� �߻����� ������ �ڵ�Ŀ��
//						 RuntimeException�� �߻��ϸ� �ڵ� rollback)
	
}

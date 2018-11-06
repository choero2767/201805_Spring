package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : �뜲�씠�꽣媛� �븳嫄댁씪�븣
		// selectList : �뿬�윭嫄댁쓽 �뜲�씠�꽣瑜� 議고쉶
		// 硫붿꽌�뱶 �씤�옄 : 臾몄옄�뿴 = �꽕�엫�뒪�럹�씠�뒪(紐⑤뱢紐�).荑쇰━�븘�씠�뵒
		
		List<UserVo> userList = session.selectList("user.selectUserAll");
//		session.rollback();
		session.commit();
		session.close();
		
		return userList;
	}
	
	public UserVo selectUser(String userName){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList1 = session.selectOne("user.selectUser", userName);
		
		session.commit();
		session.close();
		
		return userList1;
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList2 = session.selectOne("user.selectUser");
		
		session.commit();
		session.close();
		
		return userList2;
	}

	@Override
	public UserVo selectedUser(UserVo userPw) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList3 = session.selectOne("user.selectUserByVo", userPw);
		
		session.commit();
		session.close();
		
		return userList3;
	}
	
	
	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> pageList = session.selectList("user.selectUserPageList", pageVo);
		
		session.commit();
		session.close();
		
		return pageList;
	}

	/**
	* Method : getUserCnt
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @return
	* Method �꽕紐� : �궗�슜�옄 �쟾泥� 嫄댁닔 議고쉶
	*/
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		
		session.close();
		
		return totalUserCnt;
	}

	
	/**
	* Method : insertUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* Method �꽕紐� : �궗�슜�옄 �벑濡�
	*/
	@Override
	public int insertUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("user.insertUser", userVo);
		
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : deleteUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param userId
	* @return
	* Method �꽕紐� : �궗�슜�옄 �궘�젣
	*/
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("user.deleteUser", userId);
		
		session.commit();
		session.close();

		return deleteCnt;
	}

	/**
	* Method : updateUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param userVo
	* @return
	* Method �꽕紐� : �궗�슜�옄 �젙蹂� �닔�젙
	*/
	@Override
	public int updateUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("user.updateUser", userVo);
		
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
}

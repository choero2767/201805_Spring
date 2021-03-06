package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userName);
	
	public UserVo selectUser(UserVo userVo);
	
	public UserVo selectedUser(UserVo userPw);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	/**
	* Method : getUserCnt
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @return
	* Method �꽕紐� : �궗�슜�옄 �쟾泥� 嫄댁닔 議고쉶
	*/
	int getUserCnt();
	
	/**
	* Method : insertUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* Method �꽕紐� : �궗�슜�옄 �벑濡�
	*/
	int insertUser(UserVo userVo);
	
	/**
	* Method : deleteUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param userId
	* @return
	* Method �꽕紐� : �궗�슜�옄 �궘�젣
	*/
	int deleteUser(String userId);
	
	/**
	* Method : updateUser
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param userVo
	* @return
	* Method �꽕紐� : �궗�슜�옄 �젙蹂� �닔�젙
	*/
	int updateUser(UserVo userVo);
}

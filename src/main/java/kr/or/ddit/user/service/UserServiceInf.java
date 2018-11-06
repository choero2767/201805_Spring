package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserServiceInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userName);
	
	public UserVo selectUser(UserVo userVo);
	
	public UserVo selectedUser(UserVo userPw);
	
	/**
	* Method : selectUserPageList
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param pageVo
	* @return
	* Method �꽕紐� : �궗�슜�옄 �럹�씠吏� 議고쉶
	*/
	public Map<String, Object> selectUserPageList(PageVo pageVo);
	
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
	* Method �꽕紐� : �궗�슜�옄 �닔�젙
	*/
	int updateUser(UserVo userVo);
}

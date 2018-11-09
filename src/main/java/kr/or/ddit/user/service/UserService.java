package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class UserService implements UserServiceInf{

	private UserDao dao = new UserDao();
    private static UserService service;
	
	@Override
	public List<UserVo> selectUserAll() {
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userName) {
		return dao.selectUser(userName);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return dao.selectUser(userVo);
	}

	@Override
	public UserVo selectedUser(UserVo userPw) {
		return dao.selectedUser(userPw);
	}

	/**
	* Method : selectUserPageList
	* �옉�꽦�옄 : pc23
	* 蹂�寃쎌씠�젰 :
	* @param pageVo
	* @return
	* Method �꽕紐� : �궗�슜�옄 �럹�씠吏� 議고쉶
	*/
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		
		// �럹�씠吏��뿉 �빐�떦�븯�뒗 �쑀�� 由ъ뒪�듃(1~10嫄� �궗�씠)
		List<UserVo> userList = dao.selectUserPageList(pageVo);
		
		// �럹�씠吏� �궡鍮꾧쾶�씠�뀡�쓣 �쐞�븳 �쟾泥� �쑀�� 由ъ뒪�듃 議고쉶
		int totalUserCnt = dao.getUserCnt();
		
		// 寃곌낵瑜� �떞�뒗 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
//		(int)Math.ceil((double)totalUserCnt / pageVo.getPageSize());
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return dao.updateUser(userVo);
	}
	
	
	
}

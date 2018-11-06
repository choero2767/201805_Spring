package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest extends ServiceDaoTestConfig{
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	private final String TEST_USER_ID = "testuser1";
	
	@Before
	public void setup(){
		userDao.deleteUser("TEST_USER_ID");
	}
	
	
	@Test
	public void selectUserAllTest() {
		/***Given : 주어�? ?��?��***/
		UserDao userDao = new UserDao();

		/***When : ?��?�� ?��?�� ?��?��(메소?��)***/
		List<UserVo> userList = userDao.selectUserAll();
		System.out.println("userList : " + userList);
		
		/***Then : 결과�? ?��?��?��?��?��?���? ?��?��***/
		assertEquals(105, userList.size());
		
	}
	
	@Test
	public void selectUserAllTest2(){
		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = userDao.selectUser("brown");

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());

	}
	
	@Test
	public void selectUserAllTest3(){
		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");

		userDao.selectUser(userVo);
		/***Then***/
		assertEquals("brown", userVo.getUserId());

	}
	
	@Test
	public void selectUserPageList(){
		/***Given***/
		UserDaoInf userDao = new UserDao();

		/***When***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		List<UserVo> pageList = userDao.selectUserPageList(pageVo);

		/***Then***/
		assertEquals(10 , pageList.size());

	}
	
	/**
	* Method : getUserCntTest
	* ?��?��?�� : pc23
	* �?경이?�� :
	* Method ?���? : ?��?��?�� ?���? 건수 조회 ?��?��?��
	*/
	@Test
	public void getUserCntTest(){
		/***Given***/
		
		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
		
	}
	
	@Test
	public void getInsertUser(){
		/***Given***/
		// userVo �?�?
		UserVo userVo = new UserVo();
		userVo.setUserId("testuser1");
		userVo.setName("testName");
		userVo.setPass("testPass");
		userVo.setAdd1("testAddr1");
		userVo.setAdd2("testAddr2");
		userVo.setZipcd("testZipCd");
		String str = "2018-10-12";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(str);
			userVo.setBirth(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		userVo.setEmail("testUser@gmail.com");
		userVo.setTel("042-222-0421");
		/***When***/
		// userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);
		
		
		/***Then***/
		// ?��?��건수 비교
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void getDeleteUser(){
		/***Given***/
		String userId = "testuser1";

		/***When***/
		int deleteCnt = userDao.deleteUser(userId);
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getUpdateUser(){
		/***Given***/
		// userVo �?�?
		UserVo userVo = new UserVo();
		userVo.setUserId("testuser1");
		userVo.setName("testName");
		userVo.setPass("testPass");
		userVo.setAdd1("testAddr1");
		userVo.setAdd2("testAddr2");
		userVo.setZipcd("testZipCd");
		String str = "2018-10-12";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(str);
			userVo.setBirth(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		userVo.setEmail("testUser@gmail.com");
		userVo.setTel("042-222-0421");

		/***When***/
//		int updateCnt = userDao.updateUser(userVo);

		/***Then***/
//		assertEquals(1, updateCnt);
		System.out.println(userVo);
		
	}

}

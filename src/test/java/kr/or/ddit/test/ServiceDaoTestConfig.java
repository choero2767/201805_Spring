package kr.or.ddit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)

// service, dao에 대한 설정파일만 필요하다.
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})
// 스프링 컨테이너를 웹 기반에서 활용가능 한 WebApplicationContext로 생성
public class ServiceDaoTestConfig {
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
}












package kr.or.ddit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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

// controller�� ��� service ������ ���� ���Թޱ� ������
// service, dao�� ���� �������ϵ� �ʿ��ϴ�.
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml", "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
// ������ �����̳ʸ� �� ��ݿ��� Ȱ�밡�� �� WebApplicationContext�� ����
@WebAppConfiguration
public class ControllerTestConfig {

	// webApplicationContext ==> mockMvc(dispatcherServlet)������ ���� �ʿ�
	
	@Autowired
	private WebApplicationContext ctx;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Ignore
	@Test
	public void test() {
		assertTrue(true);
	}
	
}












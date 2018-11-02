package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-collection.xml"})
public class CollectionInjectTest {

	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	
	/**
	 * Method : collectionBeanTest
	 * �ۼ��� : pc23
	 * �����̷� :
	 * Method ���� : ������ ���������� ���� collection ��ü ������ ���������� �̷�������� �׽�Ʈ
	 */
	@Test
	public void collectionBeanTest() {
		/***Given***/
		

		/***When***/
		List<String> list = collectionBean.getList();
		Set<String> set = collectionBean.getSet();
		Map<String, String> map = collectionBean.getMap();
		Properties property = collectionBean.getProperty();
		
		/***Then***/
		assertNotNull(collectionBean); // spring �����̳ʿ��� DL�� ���� ���� �� : �������̶�� null�� �ƴϴ�.
		
		// list ����
		assertEquals(3, list.size());
		assertEquals("brown", list.get(0));
		
		// set ����
		assertEquals(3, set.size());
		
		// map ����
		assertEquals("brown", map.get("name"));
		assertEquals("15", map.get("age"));
		
		// properties ����
		assertEquals("pc23", property.get("db.userId"));
		assertEquals("java", property.get("db.password"));
		
		
		
	}

}

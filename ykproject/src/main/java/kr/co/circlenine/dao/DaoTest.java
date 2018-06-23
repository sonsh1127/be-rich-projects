package kr.co.circlenine.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.circlenine.dao.InsureQuestionDao;

//"file:src/main/webapp/WEB-INF/spring/root-context.xml
//"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
//@ContextConfiguration(locations= {"classpath*:spring/root-context.xml",
//"classpath*:spring/appServlet/servlet-context.xml"})


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DaoTest {
	@Autowired
	InsureQuestionDao dao;
	@Test
	public void test() {
		
	}
}

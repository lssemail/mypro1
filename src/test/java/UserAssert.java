import com.erp.dao.sys.UserDao;
import com.erp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class UserAssert {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private UserDao userDao;

	@Test
	public void testInsert() {
		User user = new User();
			user.setUsername("aaa");
			user.setPassword("bbb");
		userDao.insert(user);
	}
}

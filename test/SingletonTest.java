import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.ch1.User;
import springboot.ch1.UserDao;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/springboot/ch1/test-applicationContext.xml")
public class SingletonTest {
    @Autowired
    ApplicationContext context;

    @Autowired
    UserDao userDao;

    static Set<UserDao> testObjects = new HashSet<>();

    @Test
    public void test1() {
        // SINGLETON 방식으로 BEAN OBJECT를 가져오는가
        assertThat(testObjects.isEmpty() || testObjects.contains(userDao),is(true));
        testObjects.add(userDao);
        assertThat(testObjects.size()==1,is(true));

        // GETBEAN과 AUTOWIRED가 동일한가
        UserDao userDao2 = context.getBean("userDao",UserDao.class);
        assertThat(userDao.equals(userDao2),is(true));
    }
    @Test
    public void test2() {
        assertThat(testObjects.isEmpty() || testObjects.contains(userDao),is(true));
        testObjects.add(userDao);
        assertThat(testObjects.size()==1,is(true));

        UserDao userDao2 = context.getBean("userDao",UserDao.class);
        assertThat(userDao.equals(userDao2),is(true));
    }
    @Test
    public void test3() {
        assertThat(testObjects.isEmpty() || testObjects.contains(userDao),is(true));
        testObjects.add(userDao);
        assertThat(testObjects.size()==1,is(true));

        UserDao userDao2 = context.getBean("userDao",UserDao.class);
        assertThat(userDao.equals(userDao2),is(true));
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void test4() {
        // No Such name Bean
        UserDao userDao3 = context.getBean("userDaoDao",UserDao.class);
    }
}

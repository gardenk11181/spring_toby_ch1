import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.ch1.User;
import springboot.ch1.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/springboot/ch1/applicationContext.xml" )
public class UserDaoTest {
    // context를 모든 Test가 공유
//    @Autowired
//    private ApplicationContext context;

    // Junit은 서로 다른 Test method에 대해 서로 다른 Object를 생성하므로,
    // 인스턴스 변수도 계속 초기화 돼서 OK
    @Autowired // 바로 빈을 직접 DI받는다.
    private UserDao dao;

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
//        ApplicationContext context = new GenericXmlApplicationContext("/springboot/ch1/applicationContext.xml");
//        this.dao = context.getBean("userDao",UserDao.class);
        this.user1 = new User("jeongwon","김정원","jeongwon1");
        this.user2 = new User("jeongwon2","김정원","jeongwon2");
        this.user3 = new User("jeongwon3","김정원","jeongwon3");
    }

    @Test
    public void addAndGet() throws SQLException {
        // use Java Code to DI
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        // use Xml to DI
//        ApplicationContext context = new GenericXmlApplicationContext("springboot/ch1/applicationContext.xml");
//        UserDao dao = context.getBean("userDao",UserDao.class);
//        User user1 = new User("jeongwon","김정원","garden");
//        User user2 = new User("dayoung","정다영","Dada");

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(),is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(),is(user1.getName()));
        assertThat(userget1.getPassword(),is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(),is(user2.getName()));
        assertThat(userget2.getPassword(),is(user2.getPassword()));

//        CountingConnectionMaker ccm = context.getBean("connectionMaker",CountingConnectionMaker.class);
//        System.out.println("Connection counter : "+ccm.getCounter());

    }

    @Test
    public void count() throws SQLException {

//        ApplicationContext context = new GenericXmlApplicationContext("springboot/ch1/applicationContext.xml");
//
//        UserDao dao = context.getBean("userDao",UserDao.class);
//        User user1 = new User("jeongwon","김정원","jeongwon1");
//        User user2 = new User("jeongwon2","김정원","jeongwon2");
//        User user3 = new User("jeongwon3","김정원","jeongwon3");

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.add(user1);
        assertThat(dao.getCount(),is(1));

        dao.add(user2);
        assertThat(dao.getCount(),is(2));

        dao.add(user3);
        assertThat(dao.getCount(),is(3));

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
//        ApplicationContext context = new GenericXmlApplicationContext("springboot/ch1/applicationContext.xml");
//
//        UserDao dao = context.getBean("userDao",UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.get("unknown_id");

    }
}

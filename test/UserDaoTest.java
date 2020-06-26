import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.sql.SQLException;
import springboot.ch1.User;
import springboot.ch1.UserDao;

public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException {
        // use Java Code to DI
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        // use Xml to DI
        ApplicationContext context = new GenericXmlApplicationContext("springboot/ch1/applicationContext.xml");
        UserDao dao = context.getBean("userDao",UserDao.class);

        User user = new User();
        user.setId("dayoung2");
        user.setName("정다영");
        user.setPassword("haha");

        dao.add(user);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName(),is(user.getName()));
        assertThat(user2.getPassword(),is(user.getPassword()));

//        CountingConnectionMaker ccm = context.getBean("connectionMaker",CountingConnectionMaker.class);
//        System.out.println("Connection counter : "+ccm.getCounter());

    }
}

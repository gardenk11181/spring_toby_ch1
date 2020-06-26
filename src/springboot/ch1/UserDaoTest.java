package springboot.ch1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // use Java Code to DI
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        // use Xml to DI
        ApplicationContext context = new GenericXmlApplicationContext("springboot/ch1/applicationContext.xml");
        UserDao dao = context.getBean("userDao",UserDao.class);

        User user = new User();
        user.setId("garden5");
        user.setName("김정원");
        user.setPassword("dayoung");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공 ");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+ " 조회 성공 ");

        CountingConnectionMaker ccm = context.getBean("connectionMaker",CountingConnectionMaker.class);
        System.out.println("Connection counter : "+ccm.getCounter());

    }
}

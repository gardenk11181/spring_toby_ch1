package springboot.ch1;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("garden");
        user.setName("김정원");
        user.setPassword("dayoung");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공 ");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+ " 조회 성공 ");

    }
}

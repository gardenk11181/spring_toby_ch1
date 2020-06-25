package springboot.ch1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory { // Client로부터 요청을 받으면, 해당하는 DBConnectionMaker를 보내 userDao생성
    @Bean
    public UserDao userDao() {
        // 의존 관계 주입 (런타임 의존관계)
        return new UserDao(connectionMaker());
    }

    // Another Db Accessing Object
//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }
//
//    public MessageDao messageDao() {
//        return new MessageDao(connectionMaker());
//    }
    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realCountingMaker());
    }

    @Bean
    public ConnectionMaker realCountingMaker() {
        return new GConnectionMaker();
    }
}
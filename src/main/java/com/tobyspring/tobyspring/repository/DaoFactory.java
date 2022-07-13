package com.tobyspring.tobyspring.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 어플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {

    // Dao가 사용자, 계정 등 다양하게 쓰이게 되면서 직접적으로 생성하기 보단 ConnectionMaker를 만들어주는 팩토리 메소드를 통해 주입받는 형식으로
    // 최대한 공통적인 부분을 감싸는 것이 가능하다.
    @Bean
    public UserDao userDAO() {
        return new UserDao( connectionMaker() );
    }

    public AccountDao accountDao() {
        return new AccountDao( connectionMaker() );
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        // return new DConnectionMaker();
        // 개발 운영을 factory 클래스의 코드 한줄만 변경하여 di를 자유롭게 변경할 수 있다.
        return new LocalDBConnectionMaker();
        // return new PublicDBConnectionMaker();
    }
}

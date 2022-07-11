package com.tobyspring.tobyspring.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class DaoFactoryTest {
    @Test
    void testDao() {
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDAO();
        UserDao dao2 = factory.userDAO();

        // dao1과 dao2가 같지 않다는걸 확인하기 위한 테스트
        assertThat( dao1 ).isNotEqualTo( dao2 );
    }

    @Test
    @DisplayName ( "Spring Bean Test" )
    void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( DaoFactory.class );

        UserDao userDao1 = ac.getBean( UserDao.class );
        UserDao userDao2 = ac.getBean( UserDao.class );


        assertThat( userDao1 ).isEqualTo( userDao2 );
    }
}
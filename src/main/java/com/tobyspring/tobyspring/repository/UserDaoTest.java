package com.tobyspring.tobyspring.repository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 커낵션 메이커를 통해 DConnectionMaker 구현체를 만들고 이를 통해 userDAO 생성자의 파라미터로 conncectionMaker를 던져 최대한 의존성을 분리한다
        // ConnectionMaker connectionMaker = new DConnectionMaker();

        // UserDAO userDAO = new UserDAO( connectionMaker );

        // 새롭게 의존성을 주입하는 방법 factory 클래스를 인스턴스를 만들고 주입한다.
        UserDao userDAO = new DaoFactory().userDAO();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DaoFactory.class );

        UserDao dao = context.getBean( "userDao", UserDao.class );

        System.out.println( "userDAO = " + userDAO );
    }
}
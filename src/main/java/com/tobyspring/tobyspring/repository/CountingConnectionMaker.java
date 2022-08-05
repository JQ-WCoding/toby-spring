package com.tobyspring.tobyspring.repository;

import java.sql.Connection;

public class CountingConnectionMaker implements ConnectionMaker {

    // 연결 갯수 확인용
    int counter = 0;
    private final ConnectionMaker realConnectionMaker;

    //생성자 -> 의존성 주입
    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    // 연결과 함께 바로 카운 +1 씩하기
    @Override
    public Connection makeConnection() {
        this.counter++;

        return realConnectionMaker.makeConnection();
    }

    public int getCounter() {
        return this.counter;
    }
}

package com.tobyspring.tobyspring.singleton;

public class SingletonSync {
    private static SingletonSync instance;

    private SingletonSync() {
    }

    // synchronized 멀티 쓰레드 환경에서 호출에 대한 예방법(?)
    public static synchronized SingletonSync getInstance() {
        if ( instance == null ) {
            instance = new SingletonSync();
        }
        return instance;
    }
}

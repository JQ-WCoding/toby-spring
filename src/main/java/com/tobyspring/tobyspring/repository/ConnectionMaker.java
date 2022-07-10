package com.tobyspring.tobyspring.repository;

import java.sql.Connection;

public interface ConnectionMaker {
    Connection makeConnection();
}

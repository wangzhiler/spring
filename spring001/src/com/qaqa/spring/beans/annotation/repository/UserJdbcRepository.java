package com.qaqa.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by thinkpad on 2018/6/23.
 */

@Repository
public class UserJdbcRepository implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserJdbcRepository save...");
    }
}

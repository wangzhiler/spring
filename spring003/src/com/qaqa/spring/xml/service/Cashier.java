package com.qaqa.spring.xml.service;

import java.util.List;

/**
 * Created by thinkpad on 2018/6/28.
 */
public interface Cashier {
    public void checkout(String username, List<String> isbns);
}

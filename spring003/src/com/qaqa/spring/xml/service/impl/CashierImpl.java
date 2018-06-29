package com.qaqa.spring.xml.service.impl;

import com.qaqa.spring.xml.service.BookShopService;
import com.qaqa.spring.xml.service.Cashier;

import java.util.List;

/**
 * Created by thinkpad on 2018/6/28.
 */

public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public BookShopService getBookShopService() {
        return bookShopService;
    }

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}

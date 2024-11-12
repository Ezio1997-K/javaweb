package com.bookstore.controller;

import com.bookstore.pojo.OrderBean;
import com.bookstore.pojo.User;
import com.bookstore.service.OrderService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName:OrderController
 * Package:com.bookstore.controller
 * Description:
 */
public class OrderController {
    private OrderService orderService;

    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();

        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + year + monthValue + dayOfMonth + hour + minute + second);
        orderBean.setOrderDate(date);
        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return "index";
    }
}

package com.fpoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.dao.RevenueDAO;
import com.fpoly.entity.Order;
import com.fpoly.model.OrderInfo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class RevenueController {

    @Autowired
    private RevenueDAO revenueDAO;

    @GetMapping("/admin/revenue")
    public String viewRevenue(@RequestParam(name = "startDate", required = false) Date startDate,
                              @RequestParam(name = "endDate", required = false) Date endDate,
                              Model model) {
        List<Order> orders;
        if (startDate != null && endDate != null) {
            LocalDateTime startOfDay = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
            LocalDateTime endOfDay = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(LocalTime.MAX);
            orders = revenueDAO.findByCreateDateBetween(startOfDay, endOfDay);
        } else {
            // Nếu không có ngày bắt đầu hoặc ngày kết thúc được chọn, hiển thị tất cả đơn hàng
            orders = revenueDAO.findAll();
        }

        // Thực hiện tính toán tổng doanh thu từ danh sách đơn hàng
        List<OrderInfo> orderInfos = new ArrayList<>();

        for (Order order : orders) {
            double totalAmount = order.getOrderDetails().stream()
                    .mapToDouble(detail -> detail.getPrice() * detail.getQuantity())
                    .sum();
            
            orderInfos.add(new OrderInfo(order, totalAmount));
        }

        double overallTotalRevenue = orderInfos.stream()
                .mapToDouble(OrderInfo::getTotalAmount)
                .sum();

        model.addAttribute("orderInfos", orderInfos);
        model.addAttribute("overallTotalRevenue", overallTotalRevenue);
        return "views/home/user/layout/admin/revenue";
    }
}
package com.example.bookshop.servlet;

import com.example.bookshop.model.Goods;
import com.example.bookshop.model.Order;
import com.example.bookshop.service.GoodsService;
import lombok.NonNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "goods_buy", urlPatterns = "/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
    private final GoodsService gService = new GoodsService();

    @Override
    protected void doPost(@NonNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order o;
        if (request.getSession().getAttribute("order") != null) {
            o = (Order) request.getSession().getAttribute("order");
        } else {
            o = new Order();
            request.getSession().setAttribute("order", o);
        }
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        Goods goods = gService.getGoodsById(goodsid);
        if (goods.getStock() > 0) {
            o.addGoods(goods);
            response.getWriter().print("ok");
        } else {
            response.getWriter().print("fail");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.xch.boots.controller;

import com.xch.boots.pojo.Product;
import com.xch.boots.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @package: com.xch.boots.controller
 * @ClassName: ProductController
 * @author: 清欢.
 * @date: 2022/1/7 15:38
 */

@Controller
public class ProductController {
    @Resource
    ProductService productService;

    @ResponseBody
    @GetMapping("/product")
    public Product getProduct(@RequestParam("id") Integer id){
       return productService.getProductById(id);
    }

    @GetMapping("/productList")
    public String getAllList(Model model){
        model.addAttribute("pList",productService.getList());
        return "updateUser";
    }
}

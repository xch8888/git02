package com.xch.boots.pojo;

import lombok.Data;

/**
 * @package: com.xch.boots.pojo
 * @ClassName: Product
 * @author: 清欢.
 * @date: 2022/1/7 15:18
 */

@Data
public class Product {
    private Integer id; //商品id
    private String productName; //商品名称
    private Integer quantity; //库存量
}

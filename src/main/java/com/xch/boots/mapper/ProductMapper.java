package com.xch.boots.mapper;

import com.xch.boots.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @package: com.xch.boots.mapper
 * @ClassName: ProductMapper
 * @author: 清欢.
 * @date: 2022/1/7 15:20
 */

@Mapper
public interface ProductMapper {
    /**
     * 根据id得到商品信息
     * @param id 商品id
     * @return  对象
     */
    public Product getProduct(Integer id);

    /**
     * 查询所有数据
     * @return
     */
    public List<Product> getAllProduct();
}

package com.learnmba.mapper;

import com.learnmba.pojo.Brand;

import java.util.List;

/**
 * ClassName:BrandMapper
 * Package:com.learnmba.mapper
 * Description:
 *
 */
public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectByIdBrand(int id);
}

package com.hw.service;

import com.hw.pojo.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    int addBrand(Brand brand);

    int deleteById(int index);

    int updateById(Brand brand);
}

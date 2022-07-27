package com.hw.service.impl;

import com.hw.mapper.BrandMapper;
import com.hw.pojo.Brand;
import com.hw.service.BrandService;
import com.hw.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    // 1. 由自定义Util获取 SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有数据
     * @return 返回Brand list 数据
     */
    @Override
    public List<Brand> selectAll(){
        // 2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        List<Brand> brandList = brandMapper.selectAll();
        // 5. 释放资源
        sqlSession.close();

        return brandList;
    }

    /**
     * 添加一个 Brand数据
     * @return 返回row影响数 =1
     */
    @Override
    public int addBrand(Brand brand) {
        // 2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        int flag = brandMapper.addBrand(brand);
        System.out.println("serviceImpl:" + brand);
        // 5. 提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public int deleteById(int index) {
        // 2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        int flag = brandMapper.deleteById(index);
        System.out.println("serviceImpl:" + index);
        // 5. 提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public int updateById(Brand brand) {
        // 2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        int flag = brandMapper.updateById(brand);
        System.out.println("serviceImpl:" + brand);
        // 5. 提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
}

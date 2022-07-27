package com.hw.service;

import com.hw.mapper.UserMapper;
import com.hw.pojo.User;
import com.hw.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 服务端 存放对数据库操作的相关方法
 */

public class UserService {
    // 获取 SQL工厂
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 根据username，password查询是否存在该user
     * @param username
     * @param password
     * @return
     */
    public User selectUser(String username, String password){
        // 获取SqlSession 对象,
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行方法返回数据
        User user = userMapper.selectUser(username, password);
        // 关闭连接资源
        sqlSession.close();

        return user;
    }

    /**
     * 根据用户名查询该用户是否存在
     * @param username
     * @return
     */
    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user = usermapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }

    public int add(String username, String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int i = usermapper.add(username, password);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public User[] selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User[] users = mapper.selectAll();
        sqlSession.commit();
        return users;
    }

}

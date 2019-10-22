package com.corre;

import com.corre.domain.User;
import com.corre.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {


    @Test
    public void testFindAll() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建Session
        SqlSession sqlSession = build.openSession();

        //执行SQL
        User objects = sqlSession.selectOne("com.findAll",1);
        System.out.println(objects);


    }


    @Test
    public void testLike() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建Session
        SqlSession sqlSession = build.openSession();

        //执行SQL
        List<User> objects = sqlSession.selectList("com.likeleecx","静");
        System.out.println(objects);


    }


    @Test
    public void testadd() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建Session
        SqlSession sqlSession = build.openSession();

        User user = new User();
        user.setId(7);
        user.setUser_name("Homi");
        user.setPassword("58763283");
        user.setName("鸣式");
        user.setAge(36);
        user.setSex(2);
        //执行SQL
        int insert = sqlSession.insert("com.insertId",user);
        System.out.println(insert);
        System.out.println(user.getId());
        sqlSession.commit();


    }



    @Test
    public void testUpdate() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建Session
        SqlSession sqlSession = build.openSession();

        User user = new User();

        user.setPassword("HCD12344!@#");
        user.setId(3);
        //执行SQL
        int insert = sqlSession.update("com.update",user);
        System.out.println(insert);
        System.out.println(user.getId());
        sqlSession.commit();


    }


    @Test
    public void testDelete() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建Session
        SqlSession sqlSession = build.openSession();

        User user = new User();

        user.setUser_name("hj");
        user.setName("静静");

        //执行SQL
        int insert = sqlSession.delete("com.delete",user);
        System.out.println(insert);
        System.out.println(user.getId());
        sqlSession.commit();


    }
}


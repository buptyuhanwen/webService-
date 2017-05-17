package com.buptcnc.test;

import com.buptcnc.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by ASUS on 2017/5/11.
 */
public class MybatisFirst {
    @Test
    public void findUserByIdTest() throws Exception{
        //读取配置文件
        //全局配置文件的路径
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);


        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一标示
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        Arrays.sort(new String[]{"a","b"});
        //关闭资源
        sqlSession.close();
    }
}

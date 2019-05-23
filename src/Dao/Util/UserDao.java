package Dao.Util;

import database.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.UserMapper;

import java.util.List;

public class UserDao {
    //插入数据
    public void testInsert(){
        SqlSessionFactory factory=Util.getFactory();
        SqlSession session=factory.openSession(true);
        //使用反射的方法
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.insertT(new User());
        session.close();
    }

    //删除数据
    public void testDelete(){
        SqlSessionFactory factory=Util.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.deleteById(1);
        session.close();
    }


    //修改数据
    public void testUpdate(){
        SqlSessionFactory factory=Util.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.updateT(new User());
        session.close();
    }

    //获取一条数据
    public void testGetUser(){
        SqlSessionFactory factory=Util.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.getUser(2);
        session.close();
        System.out.println(user);
    }

    //获取所有数据
    public void testGetAllUsers(){
        SqlSessionFactory factory=Util.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<User> users=mapper.getAllUsers();

        session.close();
        System.out.println(users);
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.testInsert();
    }
}


package service;

import database.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    /*
     * 这是基于注解的映射方式，实现对数据的增删改查，将sql语句直接写在注解的括号中
     * 这是一个接口，其不需要类去实现它
     * 下边分别是插入，删除，修改，查询一个记录，查询所有的记录
     * */

    @Insert("insert into user(loginname,password) values(#{loginname},#{password})")
    public void insertT(User user);

    @Delete("delete from user where id=#{id}")
    public void deleteById(int id);

    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    public void updateT(User user);

    @Select("select * from user where id=#{id}")
    public User getUser(int id);

    @Select("select * from user")
    public List<User> getAllUsers();
}

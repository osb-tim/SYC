package Dao.Util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Util {
    public static SqlSessionFactory getFactory(){
        String resource="conf.xml";

        //加载mybatis 的配置文件（它也加载关联的映射文件）
        InputStream is=Util.class.getClassLoader().getResourceAsStream(resource);

        //构建sqlSession 的工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
}

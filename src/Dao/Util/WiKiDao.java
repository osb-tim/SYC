package Dao.Util;

import database.WiKiEntity;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

import static database.Main.getSession;
@Component
public class WiKiDao {
    public String upload(WiKiEntity wiKiEntity){
        wiKiEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        final Session session=getSession();
        Transaction tran =session.beginTransaction();
        session.save(wiKiEntity);
        tran.commit();
        session.close();
        return null;
    }

    public String delete(WiKiEntity wiKiEntity){
        final Session session=getSession();
        Transaction tran =session.beginTransaction();
        session.delete(getWiki(wiKiEntity));
        tran.commit();
        session.close();
        return null;
    }

    public String update(WiKiEntity wiKiEntity){
        wiKiEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        final Session session=getSession();
        Transaction tran =session.beginTransaction();
        session.update(wiKiEntity);
        tran.commit();
        session.close();
        return null;
    }

    public WiKiEntity getWiki(WiKiEntity wiKiEntity){

        final Session session = getSession();
//        Transaction tx = session.beginTransaction();

        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //2.获取CriteriaQuery对象
        CriteriaQuery<WiKiEntity> createQuery = criteriaBuilder.createQuery(WiKiEntity.class);

        //3.指定根条件
        Root<WiKiEntity> root = createQuery.from(WiKiEntity.class);

        //获取用户id

            createQuery.where((criteriaBuilder.equal(root.get("wid"), wiKiEntity.getWid())));

        //4执行查询
        List<WiKiEntity> List = session.createQuery(createQuery).getResultList();
        session.close();
        return List.get(0);
    }

    public List<WiKiEntity> getWikisByAuthorId(WiKiEntity wiKiEntity){
        final Session session = getSession();
//        Transaction tx = session.beginTransaction();

        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //2.获取CriteriaQuery对象
        CriteriaQuery<WiKiEntity> createQuery = criteriaBuilder.createQuery(WiKiEntity.class);

        //3.指定根条件
        Root<WiKiEntity> root = createQuery.from(WiKiEntity.class);

        //获取用户id

        createQuery.where((criteriaBuilder.equal(root.get("authorId"), wiKiEntity.getAuthorId())));
        if (!wiKiEntity.isIfAuthor()){
            boolean b=true;
            createQuery.where((criteriaBuilder.equal(root.get("ifPublic"), b)));
        }

        //4执行查询
        List<WiKiEntity> List = session.createQuery(createQuery).getResultList();
        session.close();
        return List;
    }

    public List<WiKiEntity> getAllPublicWikis(){
        final Session session = getSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from WiKiEntity where ifPublic = true order by createTime asc ");
        List list = ((org.hibernate.query.Query) query).list();
        t.commit();
        session.close();
        return list;
    }
}

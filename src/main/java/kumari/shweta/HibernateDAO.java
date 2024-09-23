/**
 * Author: Shweta Kumari
 * Date:16-08-2024
 * Time:14:30
 */

package kumari.shweta;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDAO<T>{

protected  Class<T> elemClass;
protected  String name;
Session session =HibernateUtil.getSession();

public HibernateDAO(Class<T> className){
this.elemClass = className;
}

public static <T> HibernateDAO<T> getDAO(Class<T> className){
        return new HibernateDAO<>(className);
}


    public T save(T entity) {
        Transaction tx = session.beginTransaction();
        if (tx.isActive()) {
            session.joinTransaction();
        } else {
            tx = session.beginTransaction();

        }

        try {
            session.save(entity);
            tx.commit();
            ;
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return entity;
    }
}

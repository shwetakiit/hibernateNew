import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final StandardServiceRegistry standardServiceRegistry;
    private static final SessionFactory sessionFactory;

   private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    private static  HibernateUtil hibernateUtil=null;

    private HibernateUtil() {

    }

    static {

        try {
            standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
            sessionFactory =metadata.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }


    public static  HibernateUtil getHibernateUtil(){
        if(hibernateUtil==null){
            synchronized (HibernateUtil.class){
                if(hibernateUtil==null){
                    hibernateUtil=new HibernateUtil();
                }
            }
        }
        return hibernateUtil;
    }

    //Create Hibernate session
    public static Session getSession(){
        Session session=null;
        if(threadLocal.get()==null){
            session = sessionFactory.openSession();
            threadLocal.set(session);
        } else {
            session=threadLocal.get();
        }
        return session;
    }

    //Close session
    public static  void closeSession(){
        Session session= null;
        if(threadLocal.get()!=null){
            session=threadLocal.get();
            session.close();
            threadLocal.remove();
        }
    }


}

import kumari.shweta.DTO.ContactDTO;
import kumari.shweta.DTO.UserDeatilsDTO;
import kumari.shweta.HibernateUtil;
import kumari.shweta.UserDeatilsDAO;
import org.hibernate.Session;


public class HibernateTest {

    public static void main(String[] args) {
     UserDeatilsDTO user = new UserDeatilsDTO();
        user.setUserName("Rag");
        user.setEmailId("sh@gmail.com");
        UserDeatilsDAO userDeatilsDAO= new UserDeatilsDAO(UserDeatilsDTO.class);
        userDeatilsDAO.save(user);
/*
        Session session = HibernateUtil.getSessionFactory().openSession(); //Created new session
        ContactDTO c1 = new ContactDTO();
        c1.setFirstName("Shweta");
        c1.setLastName("Kumari");
        c1.setEmailId("test1@gmail.com");

        session.beginTransaction();
        //session.save(c1);
        session.getTransaction().commit();

*/


    }
}



/**
 * Author: Shweta Kumari
 * Date:22-09-2024
 * Time:12:04
 */

package kumari.shweta.cache;

import kumari.shweta.DTO.ContactDTO;
import kumari.shweta.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SecondLevelCacheTest {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //Created new session

        Session session1 = sessionFactory.openSession();
        ContactDTO contactDTO = session1.get(ContactDTO.class, 1L);
        System.out.println(contactDTO);

        session1.close(); //After session close It will not apply first level cache
        Session session2 = sessionFactory.openSession();
        System.out.println("Second level cache is enabled so Previous data is cached in session factory level so In session 2 Query will not run above record .");
        ContactDTO contactDTO2 = session2.get(ContactDTO.class, 1L); //Since we have enabled cache level 2 This will fetch for cache
        System.out.println(contactDTO2);
    }

}

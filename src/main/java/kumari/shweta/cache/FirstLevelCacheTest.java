/**
 * Author: Shweta Kumari
 * Date:22-09-2024
 * Time:11:32
 */

package kumari.shweta.cache;

import kumari.shweta.DTO.UserDeatilsDTO;
import kumari.shweta.HibernateUtil;
import org.hibernate.Session;


public class FirstLevelCacheTest {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        UserDeatilsDTO userDeatilsDTO = session.get(UserDeatilsDTO.class, 1);
        System.out.println(userDeatilsDTO);


        System.out.println("If we don't close this sesssion  and If we can same userDetail second time select query will not run,It will pick from first level cache ");
        System.out.println("Call same user in this session  you can see select  query would have not executed again");


        UserDeatilsDTO userDetail = session.get(UserDeatilsDTO.class, 1);
        //Check is this object already available in session .
        System.out.println("Is this user available in session ? " +session.contains(userDetail));
        System.out.println(userDetail);


        System.out.println("Now close this session , open new session  fetch same user , It will hit the DB and again select query will execute");
        HibernateUtil.closeSession();
        Session newSession = HibernateUtil.getSession();
        UserDeatilsDTO user = newSession.get(UserDeatilsDTO.class, 1);
        System.out.println(user);
    }
}

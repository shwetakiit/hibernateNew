/**
 * Author: Shweta Kumari
 * Date:17-08-2024
 * Time:23:26
 */

package kumari.shweta.DAO;

import kumari.shweta.DTO.UserDeatilsDTO;
import kumari.shweta.HibernateDAO;

public class UserDetailDAO extends HibernateDAO<UserDeatilsDTO> {
    public UserDetailDAO(Class<UserDeatilsDTO> className) {
        super(className);
    }
}

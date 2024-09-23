/**
 * Author: Shweta Kumari
 * Date:16-08-2024
 * Time:19:45
 */

package kumari.shweta;

import kumari.shweta.DTO.UserDeatilsDTO;

public class UserDeatilsDAO extends HibernateDAO<UserDeatilsDTO>{

    public UserDeatilsDAO(Class<UserDeatilsDTO> className) {
        super(className);
    }
}

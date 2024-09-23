/**
 * Author: Shweta Kumari
 * Date:22-09-2024
 * Time:12:26
 */

package kumari.shweta.DTO;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity(name = "CONTACT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class ContactDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long contactId;

    @Column(name = "FIRST_NAME")
    String firstName;
    @Column(name = "SECOND_NAME")
    String lastName;

    @Column(name = "PHONE_NUMBER")
    String phone;

    @Column(name = "EMAIL_ID")
    String emailId;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public ContactDTO() {

    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

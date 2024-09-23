package kumari.shweta.DTO;


import javax.persistence.*;


@Entity
@Table(name = "USER_DETAIL")//If we don't annotate with this it create table with entity name.
public class UserDeatilsDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;

    @Column(name = "USER_NAME") //If annotated attribute and getter both .It takes getter value for storing in DB table.
    public String userName;

    public String emailId; //If we don't annotate attribute and getter , It the colum in table as attribute name .

    // @Id                    //Annotated getter value of ID ,If you want to annotate getter for other attribute otherwise getter annotation for other attribute will not work.
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    //To get the value from getter annoate on getter level and ID must be annotated on getter level.
    public String getUserName() {
        return userName + "getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserDeatilsDTO() {

    }

    @Override
    public String toString() {
        return "UserDeatilsDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

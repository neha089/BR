package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="U_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;

    @Column(name = "Role", columnDefinition = "VARCHAR(255) DEFAULT 'passenger'")
    private String role;

    @Column(name="Username" , nullable=false,length = 20)
    private String username;

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone_no=" + phone_no +
                '}';
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int u_id, String role, String username, String password, String email, int phone_no) {
        this.u_id = u_id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_no = phone_no;
    }

    @Column(name="Password" , nullable=false,length = 8)
    private String password;
    @Column(name="Email" , nullable=false,length = 50)
    private String email;
    @Column(name="Phone_no" , nullable=false)
    private int phone_no;



    public User() {

    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

}

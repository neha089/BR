package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int U_id;

    @Column(name = "role", columnDefinition = "VARCHAR(255) DEFAULT 'passenger'")
    private String Role;

    @Column(name="username" , nullable=false,length = 20)
    private String Username;
    @Column(name="Password" , nullable=false,length = 8)
    private String Password;
    @Column(name="Email" , nullable=false,length = 50)
    private String Email;
    @Column(name="Phone_No" , nullable=false)
    private int Phone_No;

    public String getRole() {
        return Role;
    }

    @Override
    public String toString() {
        return "User{" +
                "U_id=" + U_id +
                ", role='" + Role + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone_No=" + Phone_No +
                '}';
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public User(int U_id, String role, String Username, String Password, String Email, int Phone_No) {
        this.U_id = U_id;
        this.Role = role;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Phone_No = Phone_No;
    }




    public User() {

    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int U_id) {
        this.U_id = U_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(int Phone_No) {
        this.Phone_No = Phone_No;
    }

}

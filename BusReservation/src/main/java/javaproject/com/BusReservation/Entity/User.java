package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_No")
    private int phone_No;


    @OneToMany(mappedBy = "user")
    private List<Passanger> plist;

    @OneToMany(mappedBy = "roles")
    private List <Role> role;


    @Override
    public String toString() {
        return "User{" +
                "U_id=" + u_id +
                ", Username='" + username + '\'' +
                ", Password='" + password + '\'' +
                ", Email='" + email + '\'' +
                ", Phone_No=" + phone_No +
                ", plist=" + plist +
                ", role=" + role +
                '}';
    }


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

    public int getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(int phone_No) {
        this.phone_No = phone_No;
    }

    public List<Passanger> getPlist() {
        return plist;
    }

    public void setPlist(List<Passanger> plist) {
        this.plist = plist;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
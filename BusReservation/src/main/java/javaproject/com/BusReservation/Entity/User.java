package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int U_id;
    @Column(name="username" , nullable=false,length = 20)
    private String Username;
    @Column(name="Password" , nullable=false,length = 8)
    private String Password;
    @Column(name="Email" , nullable=false,length = 50)
    private String Email;
    @Column(name="Phone_No" , nullable=false)
    private int Phone_No;
  @OneToMany(mappedBy = "user")
  private List<Passanger> plist;
    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable (name="role" , joinColumns={@JoinColumn(name="u_id")} ,inverseJoinColumns={@JoinColumn(name="r_id")})
   private Collection<Role> role;




    public User(int u_id, String username, String password, String email, int phone_No, Collection<Role> role) {
        U_id = u_id;
        Username = username;
        Password = password;
        Email = email;
        Phone_No = phone_No;
        this.role = Collections.singleton((Role) role);
    }


    @Override
    public String toString() {
        return "User{" +
                "U_id=" + U_id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone_No=" + Phone_No +
                ", role=" + role +
                '}';
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

    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }

    public void setPhone_No(int Phone_No) {
        this.Phone_No = Phone_No;
    }

}

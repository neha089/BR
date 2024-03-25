package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="passanger")
public class Passanger {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;
    @Column(name = "age", nullable = false)
    private int age;


    public Passanger(int p_id, String name, User user, int age) {
        this.p_id = p_id;
        this.name = name;
        this.user = user;
        age = age;
    }


    public int getage() {
        return age;
    }

    public void setage(int age) {
        age = age;
    }


    public Passanger() {

    }


    public int getP_id() {
        return p_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "P_id=" + p_id +
                ", Name='" + name + '\'' +
                ", user=" + user +
                ", age=" + age +
                '}';
    }

    public void setP_id(int P_id) {
        this.p_id = P_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

}


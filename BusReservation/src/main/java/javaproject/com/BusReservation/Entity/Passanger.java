package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="passanger")
public class Passanger {

        @Id
        @Column(name="p_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int P_id;
    @Column(name="name" , nullable=false,length = 50)
    private String Name;
    @OneToMany
    @JoinColumn(name="u_id")
    private List<User> user;


    public Passanger(int p_id, String name, List<User> user, int age) {
        this.P_id = p_id;
        this.Name = name;
        this.user = user;
        age = age;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        age = age;
    }

    @Column(name="age" ,nullable = false)
    private int age;

    public Passanger() {

    }


    public int getP_id() {
        return P_id;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "P_id=" + P_id +
                ", Name='" + Name + '\'' +
                ", user=" + user +
                ", age=" + age +
                '}';
    }

    public void setP_id(int P_id) {
        this.P_id = P_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


}

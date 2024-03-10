package Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="passanger")
public class Passanger {

        @Id
        @Column(name="P_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int p_id;
    @Column(name="Name" , nullable=false,length = 50)
    private String name;
    @OneToMany
    @JoinColumn(name="U_id")
    private List<User> user;

    public Passanger(int p_id, String name, List<User> user, int age) {
        this.p_id = p_id;
        this.name = name;
        this.user = user;
        Age = age;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Column(name="Age" ,nullable = false)
    private int Age;

    public Passanger() {

    }


    public int getP_id() {
        return p_id;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "p_id=" + p_id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", Age=" + Age +
                '}';
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

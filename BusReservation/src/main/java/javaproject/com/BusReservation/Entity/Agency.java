package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="agency")
public class Agency {


    @Id
    @Column(name = "a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "phone_no", nullable = false, length = 50)
    private int phone_no;
    @Column(name = "adress", nullable = false, length = 50)
    private String address;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="u_id")
    private User agency ;

    @OneToMany(mappedBy="agency" )
    private Set<Bus> buses;

    public Agency(int a_id, String name, String email, int phone_no, String address, User agency, Set<Bus> buses) {
        this.a_id = a_id;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.address = address;
        this.agency = agency;
        this.buses = buses;
    }

    public User getOwner() {
        return agency;
    }

    public void setOwner(User agency) {
        this.agency = agency;
    }

    public Set<Bus> getBuses() {
        return buses;
    }

    public void setBuses(Set<Bus> buses) {
        this.buses = buses;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "a_id=" + a_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_no=" + phone_no +
                ", address='" + address + '\'' +
                ", agency=" + agency +
                ", buses=" + buses +
                '}';
    }

    public Agency() {

    }

}

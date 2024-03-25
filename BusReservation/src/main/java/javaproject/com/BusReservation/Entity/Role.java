package javaproject.com.BusReservation.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="role")

public class Role {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_id;
    @ManyToOne
    @JoinColumn(name="u_id")
    private User users;
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    public Role() {

    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }

    public Role(int r_id, User users, UserRoles roles) {
        this.r_id = r_id;
        this.users = users;
        this.roles = roles;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }



    public UserRoles getRoles() {
        return roles;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }
}
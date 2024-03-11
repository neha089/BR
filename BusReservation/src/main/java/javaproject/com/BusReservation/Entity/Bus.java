package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus {
    @Id
    @Column(name = "b_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "type", nullable = false, length = 50)
    private String type;
    @Column(name = "capacity", nullable = false)
    private int capacity;


    public Bus(int B_id, String name, String type, int capacity) {
        this.b_id = B_id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }




    public Bus() {

    }

    public int getB_id() {
        return b_id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setB_id(int B_id) {
        this.b_id = B_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "B_id=" + b_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}



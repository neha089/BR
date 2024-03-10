package Entity;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus {
    @Id
    @Column(name = "b_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int B_id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    public Bus(int B_id, String name, String type, int capacity) {
        this.B_id = B_id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Column(name = "Capacity", nullable = false)
    private int capacity;



    public Bus() {

    }

    public int getB_id() {
        return B_id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setB_id(int B_id) {
        this.B_id = B_id;
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
                "B_id=" + B_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}



package Entity;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus {
    @Id
    @Column(name = "B_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_id;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Type", nullable = false, length = 50)
    private String type;

    public Bus(int b_id, String name, String type, int capacity) {
        this.b_id = b_id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Column(name = "Capacity", nullable = false)
    private int capacity;



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

    public void setB_id(int b_id) {
        this.b_id = b_id;
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
                "b_id=" + b_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}



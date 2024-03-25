package javaproject.com.BusReservation.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

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
    @ManyToMany
    @JoinTable(
            name = "bus_stop",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "destiny_id")
    )
    @JsonManagedReference
    private List<DesStop> destiny;


    @ManyToMany
    @JoinTable(
            name = "bus_stop",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id")
    )
    @JsonManagedReference
    private List<SouStop> source;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id", nullable = true)
    private Agency agency;


    public Bus(int b_id, String name, String type, int capacity, List<DesStop> destiny, List<SouStop> source, Agency agency) {
        this.b_id = b_id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.destiny = destiny;
        this.source = source;
        this.agency = agency;
    }


    public Bus() {

    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<DesStop> getDestiny() {
        return destiny;
    }

    public void setDestiny(List<DesStop> destiny) {
        this.destiny = destiny;
    }

    public List<SouStop> getSource() {
        return source;
    }

    public void setSource(List<SouStop> source) {
        this.source = source;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "b_id=" + b_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", destiny=" + destiny +
                ", source=" + source +
                ", agency=" + agency +
                '}';
    }
}
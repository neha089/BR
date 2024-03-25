package javaproject.com.BusReservation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dstop")
public class DesStop {

    @Column(name="name")
    private String name;
    @Column(name="arr_time")
    private LocalDateTime arrivalTime;
    @Id
    @Column(name="ds_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ds_id;
    @Column(name="dept_time")
    private LocalDateTime departureTime;
    @Column(name="code" , nullable=false)
    private String code;
    @ManyToMany(mappedBy = "destiny")
    @JsonIgnore
    private List<Bus> busdest;

    public DesStop(String name, LocalDateTime arrivalTime, int ds_id, LocalDateTime departureTime, String code, List<Bus> busdest) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.ds_id = ds_id;
        this.departureTime = departureTime;
        this.code = code;
        this.busdest = busdest;
    }

    public DesStop() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDs_id() {
        return ds_id;
    }

    public void setDs_id(int ds_id) {
        this.ds_id = ds_id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Bus> getBusdest() {
        return busdest;
    }

    public void setBusdest(List<Bus> busdest) {
        this.busdest = busdest;
    }

    @Override
    public String toString() {
        return "DesStop{" +
                "name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", ds_id=" + ds_id +
                ", departureTime=" + departureTime +
                ", code='" + code + '\'' +
                ", busdest=" + busdest +
                '}';
    }
}

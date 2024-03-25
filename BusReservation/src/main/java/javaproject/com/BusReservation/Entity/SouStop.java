package javaproject.com.BusReservation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="soustop")
public class SouStop {

    @Column(name = "name")
    private String name;
    @Column(name = "arr_time")
    private LocalDateTime arrivalTime;
    @Id
    @Column(name = "ss_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ss_id;
    @Column(name = "dept_time")
    private LocalDateTime departureTime;
    @Column(name = "code", nullable = false)
    private String code;
    @ManyToMany(mappedBy = "source")
    @JsonIgnore
    private List<Bus> bussource;

    public SouStop(String name, LocalDateTime arrivalTime, int ss_id, LocalDateTime departureTime, String code, List<Bus> bussource) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.ss_id = ss_id;
        this.departureTime = departureTime;
        this.code = code;
        this.bussource = bussource;
    }

    public SouStop() {

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

    public int getSs_id() {
        return ss_id;
    }

    public void setSs_id(int ss_id) {
        this.ss_id = ss_id;
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

    public List<Bus> getBussource() {
        return bussource;
    }

    public void setBussource(List<Bus> bussource) {
        this.bussource = bussource;
    }

    @Override
    public String toString() {
        return "SouStop{" +
                "name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", ss_id=" + ss_id +
                ", departureTime=" + departureTime +
                ", code='" + code + '\'' +
                ", bussource=" + bussource +
                '}';
    }
}
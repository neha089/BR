package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name="stop")
public class Stop {
    @Column(name="dept_time")
    private LocalDateTime departureTime;

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Column(name="arr_time")
    private LocalDateTime arrivalTime;
    @Id
    @Column(name="s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int T_id;

    public Stop(LocalDateTime departureTime, LocalDateTime arrivalTime, int t_id, String code) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        T_id = t_id;
        this.code = code;
    }

    @Column(name="code" , nullable=false)
    private String code;



    public Stop() {

    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", T_id=" + T_id +
                ", code='" + code + '\'' +
                '}';
    }

    public String getName() {
        return code;
    }

    public void setName(String name) {
        this.code = name;
    }


    public Stop(int t_id, String name) {
        T_id = t_id;
        this.code = name;
    }
}

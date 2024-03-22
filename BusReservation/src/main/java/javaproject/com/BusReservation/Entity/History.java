package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="history")
public class History {
    @Id
    @Column(name = "h_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int h_id;
    @Column(name = "journey_date", nullable = false, length = 50)
    private Date jdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private User passanger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ts_id")
    private TripSchedule tsp;

    public History(int h_id, Date jdate, User passanger, TripSchedule tsp) {
        this.h_id = h_id;
        this.jdate = jdate;
        this.passanger = passanger;
        this.tsp = tsp;
    }

    public History() {

    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public Date getJdate() {
        return jdate;
    }

    public void setJdate(Date jdate) {
        this.jdate = jdate;
    }

    public User getPassanger() {
        return passanger;
    }

    public void setPassanger(User passanger) {
        this.passanger = passanger;
    }

    public TripSchedule getTsp() {
        return tsp;
    }

    public void setTsp(TripSchedule tsp) {
        this.tsp = tsp;
    }

    @Override
    public String toString() {
        return "History{" +
                "h_id=" + h_id +
                ", jdate=" + jdate +
                ", passanger=" + passanger +
                ", tsp=" + tsp +
                '}';
    }
}


package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name="t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int t_id;
    @ManyToOne
    @JoinColumn(name="u_id")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ts_id")
    private TripSchedule ts ;
    @Column(name="j_date" , nullable=false)
    private Date booking_date;


    @Column(name="canclellable")
    private Boolean cancallable;
    @Column(name="seat_no" ,nullable = false)
    private int Seat_no;

    public Ticket(int t_id, User user, TripSchedule ts, Date booking_date, Boolean cancallable, int seat_no) {
        this.t_id = t_id;
        this.user = user;
        this.ts = ts;
        booking_date = booking_date;
        this.cancallable = cancallable;
        Seat_no = seat_no;
    }

    public Ticket() {

    }

    public int getT_id() {
        return t_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TripSchedule getTs() {
        return ts;
    }

    public void setTs(TripSchedule ts) {
        this.ts = ts;
    }

    public Boolean getCancallable() {
        return cancallable;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "T_id=" + t_id +
                ", user=" + user +
                ", ts=" + ts +
                ", Booking_date=" + booking_date +
                ", cancallable=" + cancallable +
                ", Seat_no=" + Seat_no +
                '}';
    }

    public void setCancallable(Boolean cancallable) {
        this.cancallable = cancallable;
    }

    public void setT_id(int T_id) {
        this.t_id = T_id;
    }
    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date Booking_date) {
        this.booking_date = Booking_date;
    }

    public int getSeat_no() {
        return Seat_no;
    }

    public void setSeat_no(int Seat_no) {
        this.Seat_no = Seat_no;
    }

}

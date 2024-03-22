package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class TripSchedule {

    @Id
    @Column(name = "ts_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ts_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip tripDetail;
    @Column(name = "j_date", nullable = false)
    private Date Booking_date;

    private Boolean cancallable;
    @OneToMany(mappedBy = "ts", cascade = CascadeType.ALL)
    private Set<Ticket> ticketsSold;
    @Column(name = "seat_no", nullable = false)
    private int Seat_no;


    public TripSchedule() {

    }
    public TripSchedule(int ts_id, Trip tripDetail, Date booking_date, Boolean cancallable, Set<Ticket> ticketsSold, int seat_no) {
        this.ts_id = ts_id;
        this.tripDetail = tripDetail;
        Booking_date = booking_date;
        this.cancallable = cancallable;
        this.ticketsSold = ticketsSold;
        Seat_no = seat_no;
    }
    public int getts_id() {
        return ts_id;
    }

    public void setts_id(int t_id) {
        ts_id = t_id;
    }
    public Date getBooking_date() {
        return Booking_date;
    }

    public void setBooking_date(Date booking_date) {
        Booking_date = booking_date;
    }

    public Boolean getCancallable() {
        return cancallable;
    }

    public void setCancallable(Boolean cancallable) {
        this.cancallable = cancallable;
    }

    public int getTs_id() {
        return ts_id;
    }

    public void setTs_id(int ts_id) {
        this.ts_id = ts_id;
    }

    public Trip getTripDetail() {
        return tripDetail;
    }

    public void setTripDetail(Trip tripDetail) {
        this.tripDetail = tripDetail;
    }

    public Set<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(Set<Ticket> ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    @Override
    public String toString() {
        return "TripSchedule{" +
                "ts_id=" + ts_id +
                ", tripDetail=" + tripDetail +
                ", Booking_date=" + Booking_date +
                ", cancallable=" + cancallable +
                ", ticketsSold=" + ticketsSold +
                ", Seat_no=" + Seat_no +
                '}';
    }

    public int getSeat_no() {
        return Seat_no;
    }

    public void setSeat_no(int seat_no) {
        Seat_no = seat_no;
    }
}


package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name="t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int T_id;
    @ManyToOne
    @JoinColumn(name="p_id")
    private Passanger passanger;
    @ManyToOne
    @JoinColumn(name="bt_id")
    private Bus_track busTrack;
    @Column(name="booking_date" , nullable=false)
    private Date Booking_date;

    @Column(name="seat_no" ,nullable = false)
    private int Seat_no;

    public Ticket(int T_id, Passanger p_id, Bus_track bT_id, Date Booking_date, int Seat_no) {
        this.T_id = T_id;
        passanger = p_id;
        busTrack = bT_id;
        this.Booking_date = Booking_date;
        this.Seat_no = Seat_no;
    }

    public Ticket() {

    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int T_id) {
        this.T_id = T_id;
    }

    public Passanger getP_id() {
        return passanger;
    }

    public void setP_id(Passanger p_id) {
        passanger = p_id;
    }

    public Bus_track getBT_id() {
        return busTrack;
    }

    public void setBT_id(Bus_track bT_id) {
        this.busTrack = bT_id;
    }

    public Date getBooking_date() {
        return Booking_date;
    }

    public void setBooking_date(Date Booking_date) {
        this.Booking_date = Booking_date;
    }

    public int getSeat_no() {
        return Seat_no;
    }

    public void setSeat_no(int Seat_no) {
        this.Seat_no = Seat_no;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "T_id=" + T_id +
                ", P_id=" + passanger +
                ", bT_id=" + busTrack +
                ", Booking_date=" + Booking_date +
                ", Seat_no=" + Seat_no +
                '}';
    }
}

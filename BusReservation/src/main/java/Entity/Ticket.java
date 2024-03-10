package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name="T_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int t_id;
    @ManyToOne
    @JoinColumn(name="P_id")
    private Passanger passanger;
    @ManyToOne
    @JoinColumn(name="BT_id")
    private Bus_track busTrack;
    @Column(name="Booking_Date" , nullable=false)
    private Date booking_date;

    @Column(name="Seat_No" ,nullable = false)
    private int seat_no;

    public Ticket(int t_id, Passanger p_id, Bus_track bt_id, Date booking_date, int seat_no) {
        this.t_id = t_id;
        passanger = p_id;
        busTrack = bt_id;
        this.booking_date = booking_date;
        this.seat_no = seat_no;
    }

    public Ticket() {

    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public Passanger getP_id() {
        return passanger;
    }

    public void setP_id(Passanger p_id) {
        passanger = p_id;
    }

    public Bus_track getBt_id() {
        return busTrack;
    }

    public void setBt_id(Bus_track bt_id) {
        this.busTrack = bt_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "t_id=" + t_id +
                ", P_id=" + passanger +
                ", bt_id=" + busTrack +
                ", booking_date=" + booking_date +
                ", seat_no=" + seat_no +
                '}';
    }
}

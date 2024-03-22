package javaproject.com.BusReservation.Entity;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="trip")
public class Trip {

    @Id
    @Column(name="bt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Bt_id;
    private int fare;
    @ManyToOne
    @JoinColumn(name="b_id")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_stop_id")
    private Stop sourceStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_stop_id")
    private Stop destStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    private Agency agency;



    @Column(name="price" ,nullable = false)
    private int Price;




    public Trip() {

    }
    public Trip(int bt_id, int fare, Bus bus, Stop sourceStop, Stop destStop, Agency agency, int price) {
        Bt_id = bt_id;
        this.fare = fare;
        this.bus = bus;
        this.sourceStop = sourceStop;
        this.destStop = destStop;
        this.agency = agency;
        Price = price;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getBt_id() {
        return Bt_id;
    }



    public void setBt_id(int bt_id) {
        this.Bt_id = bt_id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Stop getSourceStop() {
        return sourceStop;
    }

    public void setSourceStop(Stop sourceStop) {
        this.sourceStop = sourceStop;
    }

    public Stop getDestStop() {
        return destStop;
    }

    public void setDestStop(Stop destStop) {
        this.destStop = destStop;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getSeat_no() {
        return Price;
    }

    public void setSeat_no(int seat_no) {
        this.Price = seat_no;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Bt_id=" + Bt_id +
                ", fare=" + fare +
                ", bus=" + bus +
                ", sourceStop=" + sourceStop +
                ", destStop=" + destStop +
                ", agency=" + agency +
                ", Price=" + Price +
                '}';
    }



}

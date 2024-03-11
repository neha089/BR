package javaproject.com.BusReservation.Entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="bus_track")
public class Bus_track {

    @Id
    @Column(name="bT_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Bt_id;
    @ManyToOne
    @JoinColumn(name="b_id")
    private Bus bus;

    @Column(name="service_Date" , nullable=false)
    private Date Service_date;
    @Column(name="dept_time" , nullable=false)
    private Time Dept_time;
    @Column(name="arr_time" , nullable=false)
    private Time Arr_time;
    @Column(name="source" , nullable=false,length = 30)
    private String Source;
    @Column(name="destiny" , nullable=false,length = 30)
    private String Destiny;

    @Column(name="price" ,nullable = false)
    private int Price;

    public Bus_track() {

    }

    public int getBt_id() {
        return Bt_id;
    }

    @Override
    public String toString() {
        return "Bus_track{" +
                "bt_id=" + Bt_id +
                ", bus=" + bus +
                ", service_date=" + Service_date +
                ", dept_time=" + Dept_time +
                ", arr_time=" + Arr_time +
                ", source='" + Source + '\'' +
                ", destiny='" + Destiny + '\'' +
                ", seat_no=" + Price +
                '}';
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

    public Date getService_date() {
        return Service_date;
    }

    public void setService_date(Date service_date) {
        this.Service_date = service_date;
    }

    public Time getDept_time() {
        return Dept_time;
    }

    public void setDept_time(Time dept_time) {
        this.Dept_time = dept_time;
    }

    public Time getArr_time() {
        return Arr_time;
    }

    public void setArr_time(Time arr_time) {
        this.Arr_time = arr_time;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        this.Source = source;
    }

    public String getDestiny() {
        return Destiny;
    }

    public void setDestiny(String destiny) {
        this.Destiny = destiny;
    }

    public int getSeat_no() {
        return Price;
    }

    public void setSeat_no(int seat_no) {
        this.Price = seat_no;
    }

    public Bus_track(int bt_id, Bus bus, Date service_date, Time dept_time, Time arr_time, String source, String destiny, int seat_no) {
        this.Bt_id = bt_id;
        this.bus = bus;
        this.Service_date = service_date;
        this.Dept_time = dept_time;
        this.Arr_time = arr_time;
        this.Source = source;
        this.Destiny = destiny;
        this.Price = seat_no;
    }


}

package Entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="bus_track")
public class Bus_track {

    @Id
    @Column(name="BT_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bt_id;
    @ManyToOne
    @JoinColumn(name="B_id")
    private Bus bus;

    @Column(name="Service_Date" , nullable=false)
    private Date service_date;
    @Column(name="Dept_time" , nullable=false)
    private Time dept_time;
    @Column(name="Arr_time" , nullable=false)
    private Time arr_time;
    @Column(name="Source" , nullable=false,length = 30)
    private String source;
    @Column(name="Destiny" , nullable=false,length = 30)
    private String destiny;

    @Column(name="Price" ,nullable = false)
    private int seat_no;

    public int getBt_id() {
        return bt_id;
    }

    @Override
    public String toString() {
        return "Bus_track{" +
                "bt_id=" + bt_id +
                ", bus=" + bus +
                ", service_date=" + service_date +
                ", dept_time=" + dept_time +
                ", arr_time=" + arr_time +
                ", source='" + source + '\'' +
                ", destiny='" + destiny + '\'' +
                ", seat_no=" + seat_no +
                '}';
    }

    public void setBt_id(int bt_id) {
        this.bt_id = bt_id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public Time getDept_time() {
        return dept_time;
    }

    public void setDept_time(Time dept_time) {
        this.dept_time = dept_time;
    }

    public Time getArr_time() {
        return arr_time;
    }

    public void setArr_time(Time arr_time) {
        this.arr_time = arr_time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public Bus_track(int bt_id, Bus bus, Date service_date, Time dept_time, Time arr_time, String source, String destiny, int seat_no) {
        this.bt_id = bt_id;
        this.bus = bus;
        this.service_date = service_date;
        this.dept_time = dept_time;
        this.arr_time = arr_time;
        this.source = source;
        this.destiny = destiny;
        this.seat_no = seat_no;
    }


}

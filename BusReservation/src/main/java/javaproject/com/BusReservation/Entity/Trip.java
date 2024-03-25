package javaproject.com.BusReservation.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="trip")
public class Trip {

    @Id
    @Column(name="bt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bt_id;
    private int fare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "des_stop")
    private DesStop desStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sou_stop")
    private SouStop souStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    private Agency agency;



    @Column(name="price" ,nullable = false)
    private int Price;




    public Trip() {

    }


    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getBt_id() {
        return bt_id;
    }



    public void setBt_id(int bt_id) {
        this.bt_id = bt_id;
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

    public Trip(int bt_id, int fare, Bus bus, DesStop desStop, SouStop souStop, Agency agency, int price) {
        this.bt_id = bt_id;
        this.fare = fare;
        this.desStop = desStop;
        this.souStop = souStop;
        this.agency = agency;
        Price = price;
    }

    public DesStop getDesStop() {
        return desStop;
    }

    public void setDesStop(DesStop desStop) {
        this.desStop = desStop;
    }

    public SouStop getSouStop() {
        return souStop;
    }

    public void setSouStop(SouStop souStop) {
        this.souStop = souStop;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "bt_id=" + bt_id +
                ", fare=" + fare +
                ", desStop=" + desStop +
                ", souStop=" + souStop +
                ", agency=" + agency +
                ", Price=" + Price +
                '}';
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}

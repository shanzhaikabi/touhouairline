package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "flight", catalog = "")
public class FlightEntity implements Serializable {
    private String flightNo;
    private Timestamp departTime;
    private Timestamp arrivedTime;
    private String departPlace;
    private String destination;
    private int economyPrice;
    private int premiumPrice;
    private int firstPrice;
    private String boardingGate;
    private String flightState;
    //里程
    private Integer mileage;
    private String planeNo;
    private PlaneEntity planeByPlaneNo;

    @Id
    @Column(name = "flightno")
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    @Basic
    @Column(name = "departtime")
    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    @Basic
    @Column(name = "arrivedtime")
    public Timestamp getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(Timestamp arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    @Basic
    @Column(name = "departplace")
    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "economyprice")
    public int getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(int economyPrice) {
        this.economyPrice = economyPrice;
    }

    @Basic
    @Column(name = "premiumprice")
    public int getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(int premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    @Basic
    @Column(name = "firstprice")
    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    @Basic
    @Column(name = "boardinggate")
    public String getBoardingGate() {
        return boardingGate;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    @Basic
    @Column(name = "flightstate")
    public String getFlightState() {
        return flightState;
    }

    public void setFlightState(String flightState) {
        this.flightState = flightState;
    }

    @Basic
    @Column(name = "mileage")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return economyPrice == that.economyPrice &&
                premiumPrice == that.premiumPrice &&
                firstPrice == that.firstPrice &&
                Objects.equals(flightNo, that.flightNo) &&
                //Objects.equals(planeNo, that.planeNo) &&
                Objects.equals(departTime, that.departTime) &&
                Objects.equals(arrivedTime, that.arrivedTime) &&
                Objects.equals(departPlace, that.departPlace) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(boardingGate, that.boardingGate) &&
                Objects.equals(flightState, that.flightState) &&
                Objects.equals(mileage, that.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNo, /*planeNo,*/ departTime, arrivedTime, departPlace, destination, economyPrice, premiumPrice, firstPrice, boardingGate, flightState, mileage);
    }

    @ManyToOne
    @JoinColumn(name = "planeno", referencedColumnName = "planeno", nullable = false)
    public PlaneEntity getPlaneByPlaneNo() {
        return planeByPlaneNo;
    }

    public void setPlaneByPlaneNo(PlaneEntity planeByPlaneNo) {
        this.planeByPlaneNo = planeByPlaneNo;
    }

    @Transient
    public String getPlaneNo() {
        return planeNo;
    }

    public void setPlaneNo(String planeNo) {
        this.planeNo = planeNo;
    }
}

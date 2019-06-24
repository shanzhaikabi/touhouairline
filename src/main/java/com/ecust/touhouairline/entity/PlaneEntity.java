package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "plane", schema = "flight", catalog = "")
public class PlaneEntity implements Serializable {
    private String planeNo;
    private String planeType;
    private int economyClass;
    private int premiumClass;
    private int firstClass;

    @Id
    @Column(name = "planeno")
    public String getPlaneNo() {
        return planeNo;
    }

    public void setPlaneNo(String planeNo) {
        this.planeNo = planeNo;
    }

    @Basic
    @Column(name = "planetype")
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Basic
    @Column(name = "economyclass")
    public int getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    @Basic
    @Column(name = "premiumclass")
    public int getPremiumClass() {
        return premiumClass;
    }

    public void setPremiumClass(int premiumClass) {
        this.premiumClass = premiumClass;
    }

    @Basic
    @Column(name = "firstclass")
    public int getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneEntity that = (PlaneEntity) o;
        return economyClass == that.economyClass &&
                premiumClass == that.premiumClass &&
                firstClass == that.firstClass &&
                Objects.equals(planeNo, that.planeNo) &&
                Objects.equals(planeType, that.planeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeNo, planeType, economyClass, premiumClass, firstClass);
    }

}

package com.project.foodapp.foodapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblorderaddresses")
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String orderNumber;
    private String flatBuildingNo;
    private String streetName;
    private String area;
    private String landmark;
    private String city;
    private String orderFinalStatus;
    private LocalDateTime orderTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

    public String getFlatBuildingNo() { return flatBuildingNo; }
    public void setFlatBuildingNo(String flatBuildingNo) { this.flatBuildingNo = flatBuildingNo; }

    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getOrderFinalStatus() { return orderFinalStatus; }
    public void setOrderFinalStatus(String orderFinalStatus) { this.orderFinalStatus = orderFinalStatus; }

    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }
}
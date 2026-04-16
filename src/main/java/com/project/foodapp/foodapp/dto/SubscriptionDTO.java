package com.project.foodapp.foodapp.dto;

public class SubscriptionDTO {

    private Long userId;
    private Long foodId;
    private String subscriptionPeriod; // "weekly", "monthly", "yearly"
    private String flatBuildingNo;
    private String streetName;
    private String area;
    private String landmark;
    private String city;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getFoodId() { return foodId; }
    public void setFoodId(Long foodId) { this.foodId = foodId; }

    public String getSubscriptionPeriod() { return subscriptionPeriod; }
    public void setSubscriptionPeriod(String subscriptionPeriod) { this.subscriptionPeriod = subscriptionPeriod; }

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
}
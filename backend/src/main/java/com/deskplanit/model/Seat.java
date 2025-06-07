package com.deskplanit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private double x;
    private double y;
    private String assignedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id")
    private MapFile map;

    public Seat() {}

    public Seat(String label, double x, double y, String assignedUser, MapFile map) {
        this.label = label;
        this.x = x;
        this.y = y;
        this.assignedUser = assignedUser;
        this.map = map;
    }

    public Long getId() { return id; }
    public String getLabel() { return label; }
    public double getX() { return x; }
    public double getY() { return y; }
    public String getAssignedUser() { return assignedUser; }
    public MapFile getMap() { return map; }

    public void setId(Long id) { this.id = id; }
    public void setLabel(String label) { this.label = label; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setAssignedUser(String assignedUser) { this.assignedUser = assignedUser; }
    public void setMap(MapFile map) { this.map = map; }
}

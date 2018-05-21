package com.yahoo.reservation.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "room")
    private List<RoomStatus> roomStatusList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoomStatus> getRoomStatusList() {
        return roomStatusList;
    }

    public void setRoomStatusList(List<RoomStatus> roomStatusList) {
        this.roomStatusList = roomStatusList;
    }
}

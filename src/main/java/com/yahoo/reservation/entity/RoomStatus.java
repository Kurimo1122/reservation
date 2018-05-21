package com.yahoo.reservation.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class RoomStatus {
    @Id
    private Long room_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "id")
    private Room room;

    private Date okDate;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getOkDate() {
        return okDate;
    }

    public void setOkDate(Date okDate) {
        this.okDate = okDate;
    }
}

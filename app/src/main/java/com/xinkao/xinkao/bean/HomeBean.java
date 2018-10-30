package com.xinkao.xinkao.bean;


import java.io.Serializable;

/**
 * Create by 钱 on 2018/9/29 0029.
 */
public class HomeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public String state;
    public String name;
    public String roomId;

    public HomeBean(String state, String name, String roomId) {
        this.state = state;
        this.name = name;
        this.roomId = roomId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}

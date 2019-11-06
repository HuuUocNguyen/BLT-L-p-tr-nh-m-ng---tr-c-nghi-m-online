/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hung
 */
public class User {

    private String username;
    private String password;

    private int maxPoint;
    public String status;

    public User(String username, String password, int maxPoint) {
        this.username = username;
        this.password = password;
        this.maxPoint = maxPoint;
        status = "Đang rảnh";
    }

    public User() {
        status = "Đang rảnh";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public String getAllInfor() {
        return username + ":" + maxPoint + ":" + status;
    }

}

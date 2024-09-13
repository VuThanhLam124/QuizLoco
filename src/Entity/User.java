package Entity;

import java.util.Timer;

public class User {
    private int id;
    private String username;
    private String email;
    private String passwordhash;
    private String fullname;
    private String gender;
    private String user_role;
    private String status;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;
    private byte[] avatar;

    public User() {
    }

    public User(int id, String username, String email, String passwordhash, String fullname, String gender, String user_role, String status, java.sql.Timestamp created_at, java.sql.Timestamp updated_at, byte[] avatar) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordhash = passwordhash;
        this.fullname = fullname;
        this.gender = gender;
        this.user_role = user_role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.avatar = avatar;
    }

//    set and get all
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated_at(java.sql.Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(java.sql.Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGender() {
        return gender;
    }

    public String getUser_role() {
        return user_role;
    }

    public String getStatus() {
        return status;
    }

    public java.sql.Timestamp getCreated_at() {
        return created_at;
    }

    public java.sql.Timestamp getUpdated_at() {
        return updated_at;
    }

    public byte[] getAvatar() {
        return avatar;
    }

//    toString method return name + role + id
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", user_role='" + user_role + '\'' +
                '}';
    }

}

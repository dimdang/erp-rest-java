package com.erp.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Created by DANG on 22-Feb-17.
 */
@Entity
@Table(name = "users_tbl")
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @NotNull
    @Length(max = 50)
    private String user_name;

    @NotNull
    @Length(max = 50)
    private String email;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String password;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String photo;

    @NotNull
    @Length(max = 30)
    private String role;

    @NotNull
    private boolean status;

    public Long getUserId(){
        return user_id;
    }
    public String getUser_name(){
        return user_name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword (){
        return password;
    }
    public String getPhoto() {
        return photo;
    }
    public String getRole () {
        return role;
    }
    public boolean isStatus (){
        return status;
    }

    public void setUser_id(Long user_id){
        this.user_id = user_id;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public void setEmail (String email){
        this.email = email;
    }
    public void setPassword (String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.password = hashedPassword;
    }
    public void setPhoto (String photo) {
        this.photo = photo;
    }
    public void setRole (String role) {
        this.role = role;
    }
    public void setStatus (boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}

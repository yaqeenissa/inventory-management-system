package com.example.webServises.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import jakarta.validation.constraints.Size;

@AllArgsConstructor

@NoArgsConstructor(force = true)

@Data
public class   CustomerDto {

    private String ID;
    @NonNull
    @Size(min = 3, max = 250)
    private String Name;
    private String userName;
    private String password;

//    public CustomerDto(String ID ,String name, String username, String password) {
//        this.ID=ID;
//        this.Name = name;
//        this.userName = username;
//        this.password = password;
//    }

    public CustomerDto(String password,String name, String username) {
        this.Name = name;
        this.userName = username;
        this.password=password;
    }
    public CustomerDto(String name, String username) {
        this.Name = name;
        this.userName = username;
    }

    public String getID() {
        return ID;
    }

//    public void setID(String ID) {
//        this.ID = ID;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//

}
package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUserDTO {

    @NotBlank(message = "Username connot be blank")
    public String userName;

    @NotBlank(message = "email connot be blank")
    public String email;

    @NotBlank(message = "password connot ba blank")
    public String password;

    @NotBlank(message = "age cont be a blank")
    public Integer age;

    public CreateUserDTO(String userName, String email, String password, Integer age) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public CreateUserDTO() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package com.example.arif.anjumanev5;

public class UserRegisterInfo {

    private String name,phone,email,dateofbirth,password;

    public UserRegisterInfo() {

    }



    public UserRegisterInfo(String name, String phone, String email, String dateofbirth, String password) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.dateofbirth = dateofbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

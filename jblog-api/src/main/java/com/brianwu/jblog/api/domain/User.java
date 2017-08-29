package com.brianwu.jblog.api.domain;

public class User {

    private long id;
    private String name;
    private String mobile;
    private String password;


    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getMobile() { return mobile; }

}


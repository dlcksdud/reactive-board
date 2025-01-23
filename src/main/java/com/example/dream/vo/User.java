package com.example.dream.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("SERVER_IP")
    private String SERVER_IP;

    @JsonProperty("DATABASE_TYPE")
    private String DATABASE_TYPE;

    @JsonProperty("DATABASE_ID")
    private String DATABASE_ID;

    @JsonProperty("REF_INFO")
    private String REF_INFO;

    @JsonProperty("Num")
    private String Num;

    @JsonProperty("DATABASE_VERSION")
    private String DATABASE_VERSION;

    @JsonProperty("DATABASE_USER_ID")
    private String DATABASE_USER_ID;

    public String getDATABASE_ID() {
        return DATABASE_ID;
    }

    public String getSERVER_IP() {
        return SERVER_IP;
    }

    public String getDATABASE_TYPE() {
        return DATABASE_TYPE;
    }

    public String getREF_INFO() {
        return REF_INFO;
    }

    public String getNum() {
        return Num;
    }

    public String getDATABASE_VERSION() {
        return DATABASE_VERSION;
    }

    public String getDATABASE_USER_ID() {
        return DATABASE_USER_ID;
    }

    public void setSERVER_IP(String SERVER_IP) {
        this.SERVER_IP = SERVER_IP;
    }

    public void setDATABASE_TYPE(String DATABASE_TYPE) {
        this.DATABASE_TYPE = DATABASE_TYPE;
    }

    public void setDATABASE_ID(String DATABASE_ID) {
        this.DATABASE_ID = DATABASE_ID;
    }

    public void setREF_INFO(String REF_INFO) {
        this.REF_INFO = REF_INFO;
    }

    public void setNum(String num) {
        Num = num;
    }

    public void setDATABASE_VERSION(String DATABASE_VERSION) {
        this.DATABASE_VERSION = DATABASE_VERSION;
    }

    public void setDATABASE_USER_ID(String DATABASE_USER_ID) {
        this.DATABASE_USER_ID = DATABASE_USER_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "SERVER_IP='" + SERVER_IP + '\'' +
                ", DATABASE_TYPE='" + DATABASE_TYPE + '\'' +
                ", DATABASE_ID='" + DATABASE_ID + '\'' +
                ", REF_INFO='" + REF_INFO + '\'' +
                ", Num='" + Num + '\'' +
                ", DATABASE_VERSION='" + DATABASE_VERSION + '\'' +
                ", DATABASE_USER_ID='" + DATABASE_USER_ID + '\'' +
                '}';
    }
}

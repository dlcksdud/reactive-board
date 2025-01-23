package com.example.dream.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
//    public String DatabaseType;
//    public String DatabaseVersion;
//    public String ServerIp;
//    public String DatabaseId;
//    public String DatabaseUserId;
//    public String RefInfo; // 이거 빼고 나머지가 not null
//    public int Num;
    @JsonProperty("SERVER_IP")
    private String ServerIp;

    @JsonProperty("DATABASE_TYPE")
    private String DatabaseType;

    @JsonProperty("DATABASE_ID")
    private String DatabaseId;

    @JsonProperty("REF_INFO")
    private String RefInfo;

    @JsonProperty("num")
    private String Num;

    @JsonProperty("DATABASE_VERSION")
    private String DatabaseVersion;

    @JsonProperty("DATABASE_USER_ID")
    private String DatabaseUserId;

    public String getDatabaseType() {
        return DatabaseType;
    }

    public String getDatabaseVersion() {
        return DatabaseVersion;
    }

    public String getServerIp() {
        return ServerIp;
    }

    public String getDatabaseId() {
        return DatabaseId;
    }

    public String getDatabaseUserId() {
        return DatabaseUserId;
    }

    public String getRefInfo() {
        return RefInfo;
    }

    public String getNum() {return Num;}

    public void setDatabaseType(String databaseType) {
        DatabaseType = databaseType;
    }

    public void setDatabaseVersion(String databaseVersion) {
        DatabaseVersion = databaseVersion;
    }

    public void setServerIp(String serverIp) {
        ServerIp = serverIp;
    }

    public void setDatabaseId(String databaseId) {
        DatabaseId = databaseId;
    }

    public void setDatabaseUserId(String databaseUserId) {
        DatabaseUserId = databaseUserId;
    }

    public void setRefInfo(String refInfo) {
        RefInfo = refInfo;
    }

    public void setNum(String num) {Num = num;}

    @Override
    public String toString() {
        return "User{" +
                "DatabaseType='" + DatabaseType + '\'' +
                ", DatabaseVersion='" + DatabaseVersion + '\'' +
                ", ServerIp='" + ServerIp + '\'' +
                ", DatabaseId='" + DatabaseId + '\'' +
                ", DatabaseUserId='" + DatabaseUserId + '\'' +
                ", RefInfo='" + RefInfo + '\'' +
                ", Num='" + Num + '\'' +
                '}';
    }
}

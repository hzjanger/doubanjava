package com.hzj.bookshop.crawlingData;

public class IPAddress {

    private String Ip;
    private Integer port;

    public IPAddress(String ip, Integer port) {
        Ip = ip;
        this.port = port;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "IPAddress{" +
                "Ip='" + Ip + '\'' +
                ", port=" + port +
                '}';
    }
}

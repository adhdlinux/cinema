package com.movie.data.model.cinema;

import java.util.List;

public class KeyResponse {
    private String createTime;
    private int currentNumberOfDevice;
    private List<DevicesBean> devices;
    private String id;
    private int limit;
    private String startTime;
    private long ttl;

    public static class DevicesBean {
        private String id;
        private String name;
        private String startTime;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStartTime(String str) {
            this.startTime = str;
        }
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getCurrentNumberOfDevice() {
        return this.currentNumberOfDevice;
    }

    public List<DevicesBean> getDevices() {
        return this.devices;
    }

    public String getId() {
        return this.id;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public long getTtl() {
        return this.ttl;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCurrentNumberOfDevice(int i2) {
        this.currentNumberOfDevice = i2;
    }

    public void setDevices(List<DevicesBean> list) {
        this.devices = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLimit(int i2) {
        this.limit = i2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTtl(long j2) {
        this.ttl = j2;
    }
}

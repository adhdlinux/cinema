package com.movie.data.model.providers;

import com.google.gson.annotations.JsonAdapter;
import java.util.List;

public class Resolver {
    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    private List<String> domain;
    private String name;
    private String url;
    private String version;

    public List<String> getDomain() {
        return this.domain;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDomain(List<String> list) {
        this.domain = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "Resolver{name='" + this.name + '\'' + ", version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", domain=" + this.domain + '}';
    }
}

package com.movie.data.model.providers;

import java.util.Map;

public class TProviderData {
    Map<String, Resolver> hosts;
    Map<String, Provider> providers;

    public Map<String, Resolver> getHosts() {
        return this.hosts;
    }

    public Map<String, Provider> getProviders() {
        return this.providers;
    }

    public void setHosts(Map<String, Resolver> map) {
        this.hosts = map;
    }

    public void setProviders(Map<String, Provider> map) {
        this.providers = map;
    }

    public String toString() {
        return "TProviderData{providers=" + this.providers.toString() + ", hosts=" + this.hosts.toString() + '}';
    }
}

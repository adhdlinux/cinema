package com.original.tase.model;

import java.util.List;
import java.util.Map;

public class HttpHeaderBodyResult {
    private String body;
    private Map<String, List<String>> headers;

    public HttpHeaderBodyResult(Map<String, List<String>> map, String str) {
        this.headers = map;
        this.body = str;
    }

    public String getBody() {
        return this.body;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }
}

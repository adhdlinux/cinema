package com.movie.data.model.providers;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class RemoteJSModel {
    @SerializedName("direct_quality")
    private List<DirectQualityItem> directQuality;
    @SerializedName("file")
    private String file;
    @SerializedName("headers")
    private Map<String, String> headers;
    @SerializedName("host")
    private String host;
    @SerializedName("provider")
    private String provider;
    @SerializedName("quality")
    private String quality;
    @SerializedName("source")
    private String source;
    @SerializedName("subs")
    private List<SubsItem> subs;

    public List<DirectQualityItem> getDirectQuality() {
        return this.directQuality;
    }

    public String getFile() {
        return this.file;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getHost() {
        return this.host;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getSource() {
        return this.source;
    }

    public List<SubsItem> getSubs() {
        return this.subs;
    }
}

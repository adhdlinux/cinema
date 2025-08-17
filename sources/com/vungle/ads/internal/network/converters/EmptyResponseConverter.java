package com.vungle.ads.internal.network.converters;

import okhttp3.ResponseBody;

public final class EmptyResponseConverter implements Converter<ResponseBody, Void> {
    public Void convert(ResponseBody responseBody) {
        if (responseBody == null) {
            return null;
        }
        responseBody.close();
        return null;
    }
}

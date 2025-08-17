package com.unity3d.services.core.request;

import java.util.List;
import java.util.Map;

public interface IWebRequestProgressListener {
    void onRequestProgress(String str, long j2, long j3);

    void onRequestStart(String str, long j2, int i2, Map<String, List<String>> map);
}

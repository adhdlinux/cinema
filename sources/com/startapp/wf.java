package com.startapp;

import com.startapp.simple.bloomfilter.version.BloomVersion;
import java.util.HashMap;
import java.util.Map;

public class wf {

    /* renamed from: a  reason: collision with root package name */
    public final Map<BloomVersion, vf> f36844a;

    public wf() {
        HashMap hashMap = new HashMap();
        this.f36844a = hashMap;
        hashMap.put(BloomVersion.ZERO, new ag());
        hashMap.put(BloomVersion.THREE, new zf());
        hashMap.put(BloomVersion.FOUR, new yf());
        hashMap.put(BloomVersion.FIVE, new xf());
    }
}

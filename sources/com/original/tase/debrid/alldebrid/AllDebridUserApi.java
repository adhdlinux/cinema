package com.original.tase.debrid.alldebrid;

import com.original.Constants;
import com.utils.Utils;
import java.util.HashMap;

public class AllDebridUserApi {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AllDebridUserApi f33791b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f33792a = false;

    public static HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("User-Agent", Constants.C);
        return hashMap;
    }

    public static AllDebridUserApi d() {
        if (f33791b == null) {
            synchronized (AllDebridUserApi.class) {
                if (f33791b == null) {
                    f33791b = new AllDebridUserApi();
                }
            }
        }
        return f33791b;
    }

    public void a() {
        this.f33792a = Utils.l(Utils.RDTYPE.ALL_DEBRID);
    }

    public boolean b() {
        return this.f33792a;
    }
}

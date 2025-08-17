package com.chartboost.sdk.impl;

import android.util.Log;
import com.applovin.impl.sdk.utils.JsonUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public abstract class d1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17398a = e1.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final Function1 f17399b = a.f17400b;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17400b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final pa invoke(z0 z0Var) {
            JSONObject jSONObject;
            String str = JsonUtils.EMPTY_JSON;
            Intrinsics.f(z0Var, "it");
            try {
                String string = z0Var.f().getString("config", str);
                if (string != null) {
                    str = string;
                }
                jSONObject = new JSONObject(str);
            } catch (Exception e2) {
                Log.e(d1.f17398a, "Error reading config from shared preferences", e2);
                jSONObject = new JSONObject();
            }
            return new pa(jSONObject);
        }
    }
}

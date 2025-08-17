package com.startapp.sdk.adsbase.adrules;

import com.startapp.i0;
import com.startapp.q7;
import java.io.Serializable;
import java.util.List;

@i0(decider = "type", packageName = "com.startapp.sdk.adsbase.adrules")
public abstract class AdRule implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public transient boolean f36301a;

    public abstract boolean a(List<q7> list);
}

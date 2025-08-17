package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FailuresHandler implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean infiniteLastRetry = true;
    @j0(type = ArrayList.class, value = Integer.class)
    private List<Integer> intervals = Arrays.asList(new Integer[]{10, 30, 60, 300});

    public List<Integer> a() {
        return this.intervals;
    }

    public boolean b() {
        return this.infiniteLastRetry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FailuresHandler.class != obj.getClass()) {
            return false;
        }
        FailuresHandler failuresHandler = (FailuresHandler) obj;
        if (this.infiniteLastRetry != failuresHandler.infiniteLastRetry || !lb.a(this.intervals, failuresHandler.intervals)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.intervals, Boolean.valueOf(this.infiniteLastRetry)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}

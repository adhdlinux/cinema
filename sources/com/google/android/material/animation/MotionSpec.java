package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<String, MotionTiming> f29408a = new SimpleArrayMap<>();

    private static void a(MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.h(objectAnimator.getPropertyName(), MotionTiming.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public static MotionSpec b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static MotionSpec c(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return d(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    private static MotionSpec d(List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(motionSpec, list.get(i2));
        }
        return motionSpec;
    }

    public MotionTiming e(String str) {
        if (g(str)) {
            return this.f29408a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f29408a.equals(((MotionSpec) obj).f29408a);
    }

    public long f() {
        int size = this.f29408a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            MotionTiming n2 = this.f29408a.n(i2);
            j2 = Math.max(j2, n2.c() + n2.d());
        }
        return j2;
    }

    public boolean g(String str) {
        return this.f29408a.get(str) != null;
    }

    public void h(String str, MotionTiming motionTiming) {
        this.f29408a.put(str, motionTiming);
    }

    public int hashCode() {
        return this.f29408a.hashCode();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f29408a + "}\n";
    }
}

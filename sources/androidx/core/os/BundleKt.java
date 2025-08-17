package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

public final class BundleKt {
    public static final Bundle a(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.f(pairArr, "pairs");
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String a2 = pair.a();
            Object b2 = pair.b();
            if (b2 == null) {
                bundle.putString(a2, (String) null);
            } else if (b2 instanceof Boolean) {
                bundle.putBoolean(a2, ((Boolean) b2).booleanValue());
            } else if (b2 instanceof Byte) {
                bundle.putByte(a2, ((Number) b2).byteValue());
            } else if (b2 instanceof Character) {
                bundle.putChar(a2, ((Character) b2).charValue());
            } else if (b2 instanceof Double) {
                bundle.putDouble(a2, ((Number) b2).doubleValue());
            } else if (b2 instanceof Float) {
                bundle.putFloat(a2, ((Number) b2).floatValue());
            } else if (b2 instanceof Integer) {
                bundle.putInt(a2, ((Number) b2).intValue());
            } else if (b2 instanceof Long) {
                bundle.putLong(a2, ((Number) b2).longValue());
            } else if (b2 instanceof Short) {
                bundle.putShort(a2, ((Number) b2).shortValue());
            } else if (b2 instanceof Bundle) {
                bundle.putBundle(a2, (Bundle) b2);
            } else if (b2 instanceof CharSequence) {
                bundle.putCharSequence(a2, (CharSequence) b2);
            } else if (b2 instanceof Parcelable) {
                bundle.putParcelable(a2, (Parcelable) b2);
            } else if (b2 instanceof boolean[]) {
                bundle.putBooleanArray(a2, (boolean[]) b2);
            } else if (b2 instanceof byte[]) {
                bundle.putByteArray(a2, (byte[]) b2);
            } else if (b2 instanceof char[]) {
                bundle.putCharArray(a2, (char[]) b2);
            } else if (b2 instanceof double[]) {
                bundle.putDoubleArray(a2, (double[]) b2);
            } else if (b2 instanceof float[]) {
                bundle.putFloatArray(a2, (float[]) b2);
            } else if (b2 instanceof int[]) {
                bundle.putIntArray(a2, (int[]) b2);
            } else if (b2 instanceof long[]) {
                bundle.putLongArray(a2, (long[]) b2);
            } else if (b2 instanceof short[]) {
                bundle.putShortArray(a2, (short[]) b2);
            } else if (b2 instanceof Object[]) {
                Class<?> componentType = b2.getClass().getComponentType();
                Intrinsics.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b2, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(a2, (Parcelable[]) b2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(a2, (String[]) b2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b2, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(a2, (CharSequence[]) b2);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(a2, (Serializable) b2);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + a2 + '\"');
                }
            } else if (b2 instanceof Serializable) {
                bundle.putSerializable(a2, (Serializable) b2);
            } else if (b2 instanceof IBinder) {
                BundleApi18ImplKt.a(bundle, a2, (IBinder) b2);
            } else if (b2 instanceof Size) {
                BundleApi21ImplKt.a(bundle, a2, (Size) b2);
            } else if (b2 instanceof SizeF) {
                BundleApi21ImplKt.b(bundle, a2, (SizeF) b2);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b2.getClass().getCanonicalName() + " for key \"" + a2 + '\"');
            }
        }
        return bundle;
    }
}

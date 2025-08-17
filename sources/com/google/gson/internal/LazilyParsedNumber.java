package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {

    /* renamed from: b  reason: collision with root package name */
    private final String f30954b;

    public LazilyParsedNumber(String str) {
        this.f30954b = str;
    }

    private BigDecimal a() {
        return NumberLimits.b(this.f30954b);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f30954b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            return this.f30954b.equals(((LazilyParsedNumber) obj).f30954b);
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat(this.f30954b);
    }

    public int hashCode() {
        return this.f30954b.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return (int) java.lang.Long.parseLong(r2.f30954b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        return a().intValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f30954b     // Catch:{ NumberFormatException -> 0x0007 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.String r0 = r2.f30954b     // Catch:{ NumberFormatException -> 0x000f }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000f }
            int r1 = (int) r0
            return r1
        L_0x000f:
            java.math.BigDecimal r0 = r2.a()
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LazilyParsedNumber.intValue():int");
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f30954b);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f30954b;
    }
}

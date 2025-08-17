package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public final class JsonPrimitive extends JsonElement {

    /* renamed from: b  reason: collision with root package name */
    private final Object f30892b;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f30892b = bool;
    }

    private static boolean r(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.f30892b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public int a() {
        return s() ? p().intValue() : Integer.parseInt(e());
    }

    public String e() {
        Object obj = this.f30892b;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (s()) {
            return p().toString();
        }
        if (q()) {
            return ((Boolean) this.f30892b).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f30892b.getClass());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f30892b == null) {
            if (jsonPrimitive.f30892b == null) {
                return true;
            }
            return false;
        } else if (!r(this) || !r(jsonPrimitive)) {
            Object obj2 = this.f30892b;
            if (obj2 instanceof Number) {
                Object obj3 = jsonPrimitive.f30892b;
                if (obj3 instanceof Number) {
                    if (!(obj2 instanceof BigDecimal) || !(obj3 instanceof BigDecimal)) {
                        double n2 = n();
                        double n3 = jsonPrimitive.n();
                        if (n2 == n3) {
                            return true;
                        }
                        if (!Double.isNaN(n2) || !Double.isNaN(n3)) {
                            return false;
                        }
                        return true;
                    } else if (k().compareTo(jsonPrimitive.k()) == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return obj2.equals(jsonPrimitive.f30892b);
        } else if ((this.f30892b instanceof BigInteger) || (jsonPrimitive.f30892b instanceof BigInteger)) {
            return l().equals(jsonPrimitive.l());
        } else {
            if (p().longValue() == jsonPrimitive.p().longValue()) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f30892b == null) {
            return 31;
        }
        if (r(this)) {
            doubleToLongBits = p().longValue();
        } else {
            Object obj = this.f30892b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(p().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public BigDecimal k() {
        Object obj = this.f30892b;
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        return NumberLimits.b(e());
    }

    public BigInteger l() {
        Object obj = this.f30892b;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (r(this)) {
            return BigInteger.valueOf(p().longValue());
        }
        return NumberLimits.c(e());
    }

    public boolean m() {
        if (q()) {
            return ((Boolean) this.f30892b).booleanValue();
        }
        return Boolean.parseBoolean(e());
    }

    public double n() {
        return s() ? p().doubleValue() : Double.parseDouble(e());
    }

    public long o() {
        return s() ? p().longValue() : Long.parseLong(e());
    }

    public Number p() {
        Object obj = this.f30892b;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean q() {
        return this.f30892b instanceof Boolean;
    }

    public boolean s() {
        return this.f30892b instanceof Number;
    }

    public boolean t() {
        return this.f30892b instanceof String;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.f30892b = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.f30892b = str;
    }
}

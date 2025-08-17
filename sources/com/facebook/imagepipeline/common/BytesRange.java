package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Locale;
import java.util.regex.Pattern;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BytesRange {
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    private static Pattern sHeaderParsingRegEx;
    public final int from;
    public final int to;

    public BytesRange(int i2, int i3) {
        this.from = i2;
        this.to = i3;
    }

    public static BytesRange from(int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return new BytesRange(i2, Integer.MAX_VALUE);
    }

    public static BytesRange fromContentRangeHeader(String str) throws IllegalArgumentException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (str == null) {
            return null;
        }
        if (sHeaderParsingRegEx == null) {
            sHeaderParsingRegEx = Pattern.compile("[-/ ]");
        }
        try {
            String[] split = sHeaderParsingRegEx.split(str);
            if (split.length == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(Boolean.valueOf(z2));
            Preconditions.checkArgument(Boolean.valueOf(split[0].equals("bytes")));
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            if (parseInt2 > parseInt) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(Boolean.valueOf(z3));
            if (parseInt3 > parseInt2) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(Boolean.valueOf(z4));
            if (parseInt2 < parseInt3 - 1) {
                return new BytesRange(parseInt, parseInt2);
            }
            return new BytesRange(parseInt, Integer.MAX_VALUE);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(String.format((Locale) null, "Invalid Content-Range header value: \"%s\"", new Object[]{str}), e2);
        }
    }

    public static BytesRange toMax(int i2) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return new BytesRange(0, i2);
    }

    private static String valueOrEmpty(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return "";
        }
        return Integer.toString(i2);
    }

    public boolean contains(BytesRange bytesRange) {
        return bytesRange != null && this.from <= bytesRange.from && this.to >= bytesRange.to;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        if (this.from == bytesRange.from && this.to == bytesRange.to) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.from, this.to);
    }

    public String toHttpRangeHeaderValue() {
        return String.format((Locale) null, "bytes=%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }

    public String toString() {
        return String.format((Locale) null, "%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }
}

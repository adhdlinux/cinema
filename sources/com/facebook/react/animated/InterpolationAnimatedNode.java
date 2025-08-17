package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
    public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
    public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
    private static final Pattern fpPattern = Pattern.compile(fpRegex);
    private static final String fpRegex = "[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?";
    private final String mExtrapolateLeft;
    private final String mExtrapolateRight;
    private final boolean mHasStringOutput;
    private final double[] mInputRange;
    private int mNumVals;
    private final double[] mOutputRange;
    private double[][] mOutputs;
    private ValueAnimatedNode mParent;
    private String mPattern;
    private final Matcher mSOutputMatcher;
    private boolean mShouldRound;

    public InterpolationAnimatedNode(ReadableMap readableMap) {
        boolean z2;
        this.mInputRange = fromDoubleArray(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        if (array.getType(0) == ReadableType.String) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mHasStringOutput = z2;
        if (z2) {
            int size = array.size();
            this.mOutputRange = new double[size];
            String string = array.getString(0);
            this.mPattern = string;
            this.mShouldRound = string.startsWith("rgb");
            this.mSOutputMatcher = fpPattern.matcher(this.mPattern);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                Matcher matcher = fpPattern.matcher(array.getString(i2));
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                while (matcher.find()) {
                    arrayList2.add(Double.valueOf(Double.parseDouble(matcher.group())));
                }
                this.mOutputRange[i2] = ((Double) arrayList2.get(0)).doubleValue();
            }
            int size2 = ((ArrayList) arrayList.get(0)).size();
            this.mNumVals = size2;
            this.mOutputs = new double[size2][];
            for (int i3 = 0; i3 < this.mNumVals; i3++) {
                double[] dArr = new double[size];
                this.mOutputs[i3] = dArr;
                for (int i4 = 0; i4 < size; i4++) {
                    dArr[i4] = ((Double) ((ArrayList) arrayList.get(i4)).get(i3)).doubleValue();
                }
            }
        } else {
            this.mOutputRange = fromDoubleArray(array);
            this.mSOutputMatcher = null;
        }
        this.mExtrapolateLeft = readableMap.getString("extrapolateLeft");
        this.mExtrapolateRight = readableMap.getString("extrapolateRight");
    }

    private static int findRangeIndex(double d2, double[] dArr) {
        int i2 = 1;
        while (i2 < dArr.length - 1 && dArr[i2] < d2) {
            i2++;
        }
        return i2 - 1;
    }

    private static double[] fromDoubleArray(ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = readableArray.getDouble(i2);
        }
        return dArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r1.equals(EXTRAPOLATE_TYPE_CLAMP) == false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double interpolate(double r13, double r15, double r17, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            r0 = r23
            r1 = r24
            java.lang.String r2 = "Invalid extrapolation type "
            r3 = 2
            java.lang.String r4 = "clamp"
            r5 = 1
            java.lang.String r6 = "identity"
            r7 = 0
            java.lang.String r8 = "extend"
            r9 = -1
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 >= 0) goto L_0x005a
            r23.hashCode()
            int r11 = r23.hashCode()
            switch(r11) {
                case -1289044198: goto L_0x0032;
                case -135761730: goto L_0x0029;
                case 94742715: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r11 = -1
            goto L_0x003a
        L_0x0020:
            boolean r11 = r0.equals(r4)
            if (r11 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            r11 = 2
            goto L_0x003a
        L_0x0029:
            boolean r11 = r0.equals(r6)
            if (r11 != 0) goto L_0x0030
            goto L_0x001e
        L_0x0030:
            r11 = 1
            goto L_0x003a
        L_0x0032:
            boolean r11 = r0.equals(r8)
            if (r11 != 0) goto L_0x0039
            goto L_0x001e
        L_0x0039:
            r11 = 0
        L_0x003a:
            switch(r11) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0059;
                case 2: goto L_0x0057;
                default: goto L_0x003d;
            }
        L_0x003d:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = "for left extrapolation"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0057:
            r11 = r15
            goto L_0x005b
        L_0x0059:
            return r13
        L_0x005a:
            r11 = r13
        L_0x005b:
            int r0 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a4
            r24.hashCode()
            int r0 = r24.hashCode()
            switch(r0) {
                case -1289044198: goto L_0x007b;
                case -135761730: goto L_0x0072;
                case 94742715: goto L_0x006b;
                default: goto L_0x0069;
            }
        L_0x0069:
            r3 = -1
            goto L_0x0083
        L_0x006b:
            boolean r0 = r1.equals(r4)
            if (r0 != 0) goto L_0x0083
            goto L_0x0069
        L_0x0072:
            boolean r0 = r1.equals(r6)
            if (r0 != 0) goto L_0x0079
            goto L_0x0069
        L_0x0079:
            r3 = 1
            goto L_0x0083
        L_0x007b:
            boolean r0 = r1.equals(r8)
            if (r0 != 0) goto L_0x0082
            goto L_0x0069
        L_0x0082:
            r3 = 0
        L_0x0083:
            switch(r3) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00a3;
                case 2: goto L_0x00a0;
                default: goto L_0x0086;
            }
        L_0x0086:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = "for right extrapolation"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a0:
            r11 = r17
            goto L_0x00a4
        L_0x00a3:
            return r11
        L_0x00a4:
            int r0 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x00a9
            return r19
        L_0x00a9:
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x00b1
            if (r10 > 0) goto L_0x00b0
            return r19
        L_0x00b0:
            return r21
        L_0x00b1:
            double r0 = r21 - r19
            double r11 = r11 - r15
            double r0 = r0 * r11
            double r2 = r17 - r15
            double r0 = r0 / r2
            double r0 = r19 + r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.interpolate(double, double, double, double, double, java.lang.String, java.lang.String):double");
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
        if (this.mParent != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            this.mParent = (ValueAnimatedNode) animatedNode;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
        if (animatedNode == this.mParent) {
            this.mParent = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public String prettyPrint() {
        return "InterpolationAnimatedNode[" + this.mTag + "] super: " + super.prettyPrint();
    }

    public void update() {
        String str;
        boolean z2;
        String str2;
        ValueAnimatedNode valueAnimatedNode = this.mParent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            double interpolate = interpolate(value, this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
            this.mValue = interpolate;
            if (!this.mHasStringOutput) {
                return;
            }
            if (this.mNumVals > 1) {
                StringBuffer stringBuffer = new StringBuffer(this.mPattern.length());
                this.mSOutputMatcher.reset();
                int i2 = 0;
                while (this.mSOutputMatcher.find()) {
                    int i3 = i2 + 1;
                    double interpolate2 = interpolate(value, this.mInputRange, this.mOutputs[i2], this.mExtrapolateLeft, this.mExtrapolateRight);
                    if (this.mShouldRound) {
                        if (i3 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            interpolate2 *= 1000.0d;
                        }
                        int round = (int) Math.round(interpolate2);
                        if (z2) {
                            str2 = Double.toString(((double) round) / 1000.0d);
                        } else {
                            str2 = Integer.toString(round);
                        }
                        this.mSOutputMatcher.appendReplacement(stringBuffer, str2);
                    } else {
                        int i4 = (int) interpolate2;
                        if (((double) i4) != interpolate2) {
                            str = Double.toString(interpolate2);
                        } else {
                            str = Integer.toString(i4);
                        }
                        this.mSOutputMatcher.appendReplacement(stringBuffer, str);
                    }
                    i2 = i3;
                }
                this.mSOutputMatcher.appendTail(stringBuffer);
                this.mAnimatedObject = stringBuffer.toString();
                return;
            }
            this.mAnimatedObject = this.mSOutputMatcher.replaceFirst(String.valueOf(interpolate));
        }
    }

    static double interpolate(double d2, double[] dArr, double[] dArr2, String str, String str2) {
        int findRangeIndex = findRangeIndex(d2, dArr);
        int i2 = findRangeIndex + 1;
        return interpolate(d2, dArr[findRangeIndex], dArr[i2], dArr2[findRangeIndex], dArr2[i2], str, str2);
    }
}

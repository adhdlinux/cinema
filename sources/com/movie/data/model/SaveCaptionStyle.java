package com.movie.data.model;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class SaveCaptionStyle {
    @SerializedName("backgroundColor")
    private int backgroundColor;
    @SerializedName("edgeColor")
    private int edgeColor;
    @SerializedName("edgeType")
    private int edgeType;
    @SerializedName("elevation")
    private int elevation;
    @SerializedName("fixedTextSize")
    private Float fixedTextSize;
    @SerializedName("foregroundColor")
    private int foregroundColor;
    @SerializedName("removeBloat")
    private boolean removeBloat;
    @SerializedName("removeCaptions")
    private boolean removeCaptions;
    @SerializedName("typeface")
    private Integer typeface;
    @SerializedName("typefaceFilePath")
    private String typefaceFilePath;
    @SerializedName("upperCase")
    private boolean upperCase;
    @SerializedName("windowColor")
    private int windowColor;

    public SaveCaptionStyle(int i2, int i3, int i4, int i5, int i6, Integer num, String str, int i7, Float f2, boolean z2, boolean z3, boolean z4) {
        this.foregroundColor = i2;
        this.backgroundColor = i3;
        this.windowColor = i4;
        this.edgeType = i5;
        this.edgeColor = i6;
        this.typeface = num;
        this.typefaceFilePath = str;
        this.elevation = i7;
        this.fixedTextSize = f2;
        this.removeCaptions = z2;
        this.removeBloat = z3;
        this.upperCase = z4;
    }

    public static /* synthetic */ SaveCaptionStyle copy$default(SaveCaptionStyle saveCaptionStyle, int i2, int i3, int i4, int i5, int i6, Integer num, String str, int i7, Float f2, boolean z2, boolean z3, boolean z4, int i8, Object obj) {
        SaveCaptionStyle saveCaptionStyle2 = saveCaptionStyle;
        int i9 = i8;
        return saveCaptionStyle.copy((i9 & 1) != 0 ? saveCaptionStyle2.foregroundColor : i2, (i9 & 2) != 0 ? saveCaptionStyle2.backgroundColor : i3, (i9 & 4) != 0 ? saveCaptionStyle2.windowColor : i4, (i9 & 8) != 0 ? saveCaptionStyle2.edgeType : i5, (i9 & 16) != 0 ? saveCaptionStyle2.edgeColor : i6, (i9 & 32) != 0 ? saveCaptionStyle2.typeface : num, (i9 & 64) != 0 ? saveCaptionStyle2.typefaceFilePath : str, (i9 & 128) != 0 ? saveCaptionStyle2.elevation : i7, (i9 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? saveCaptionStyle2.fixedTextSize : f2, (i9 & 512) != 0 ? saveCaptionStyle2.removeCaptions : z2, (i9 & 1024) != 0 ? saveCaptionStyle2.removeBloat : z3, (i9 & 2048) != 0 ? saveCaptionStyle2.upperCase : z4);
    }

    public final int component1() {
        return this.foregroundColor;
    }

    public final boolean component10() {
        return this.removeCaptions;
    }

    public final boolean component11() {
        return this.removeBloat;
    }

    public final boolean component12() {
        return this.upperCase;
    }

    public final int component2() {
        return this.backgroundColor;
    }

    public final int component3() {
        return this.windowColor;
    }

    public final int component4() {
        return this.edgeType;
    }

    public final int component5() {
        return this.edgeColor;
    }

    public final Integer component6() {
        return this.typeface;
    }

    public final String component7() {
        return this.typefaceFilePath;
    }

    public final int component8() {
        return this.elevation;
    }

    public final Float component9() {
        return this.fixedTextSize;
    }

    public final SaveCaptionStyle copy(int i2, int i3, int i4, int i5, int i6, Integer num, String str, int i7, Float f2, boolean z2, boolean z3, boolean z4) {
        return new SaveCaptionStyle(i2, i3, i4, i5, i6, num, str, i7, f2, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaveCaptionStyle)) {
            return false;
        }
        SaveCaptionStyle saveCaptionStyle = (SaveCaptionStyle) obj;
        return this.foregroundColor == saveCaptionStyle.foregroundColor && this.backgroundColor == saveCaptionStyle.backgroundColor && this.windowColor == saveCaptionStyle.windowColor && this.edgeType == saveCaptionStyle.edgeType && this.edgeColor == saveCaptionStyle.edgeColor && Intrinsics.a(this.typeface, saveCaptionStyle.typeface) && Intrinsics.a(this.typefaceFilePath, saveCaptionStyle.typefaceFilePath) && this.elevation == saveCaptionStyle.elevation && Intrinsics.a(this.fixedTextSize, saveCaptionStyle.fixedTextSize) && this.removeCaptions == saveCaptionStyle.removeCaptions && this.removeBloat == saveCaptionStyle.removeBloat && this.upperCase == saveCaptionStyle.upperCase;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final int getEdgeType() {
        return this.edgeType;
    }

    public final int getElevation() {
        return this.elevation;
    }

    public final Float getFixedTextSize() {
        return this.fixedTextSize;
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final boolean getRemoveBloat() {
        return this.removeBloat;
    }

    public final boolean getRemoveCaptions() {
        return this.removeCaptions;
    }

    public final Integer getTypeface() {
        return this.typeface;
    }

    public final String getTypefaceFilePath() {
        return this.typefaceFilePath;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public final int getWindowColor() {
        return this.windowColor;
    }

    public int hashCode() {
        int i2 = ((((((((this.foregroundColor * 31) + this.backgroundColor) * 31) + this.windowColor) * 31) + this.edgeType) * 31) + this.edgeColor) * 31;
        Integer num = this.typeface;
        int i3 = 0;
        int hashCode = (i2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.typefaceFilePath;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.elevation) * 31;
        Float f2 = this.fixedTextSize;
        if (f2 != null) {
            i3 = f2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 31;
        boolean z2 = this.removeCaptions;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int i5 = (i4 + (z2 ? 1 : 0)) * 31;
        boolean z4 = this.removeBloat;
        if (z4) {
            z4 = true;
        }
        int i6 = (i5 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.upperCase;
        if (!z5) {
            z3 = z5;
        }
        return i6 + (z3 ? 1 : 0);
    }

    public final void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public final void setEdgeColor(int i2) {
        this.edgeColor = i2;
    }

    public final void setEdgeType(int i2) {
        this.edgeType = i2;
    }

    public final void setElevation(int i2) {
        this.elevation = i2;
    }

    public final void setFixedTextSize(Float f2) {
        this.fixedTextSize = f2;
    }

    public final void setForegroundColor(int i2) {
        this.foregroundColor = i2;
    }

    public final void setRemoveBloat(boolean z2) {
        this.removeBloat = z2;
    }

    public final void setRemoveCaptions(boolean z2) {
        this.removeCaptions = z2;
    }

    public final void setTypeface(Integer num) {
        this.typeface = num;
    }

    public final void setTypefaceFilePath(String str) {
        this.typefaceFilePath = str;
    }

    public final void setUpperCase(boolean z2) {
        this.upperCase = z2;
    }

    public final void setWindowColor(int i2) {
        this.windowColor = i2;
    }

    public String toString() {
        return "SaveCaptionStyle(foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", windowColor=" + this.windowColor + ", edgeType=" + this.edgeType + ", edgeColor=" + this.edgeColor + ", typeface=" + this.typeface + ", typefaceFilePath=" + this.typefaceFilePath + ", elevation=" + this.elevation + ", fixedTextSize=" + this.fixedTextSize + ", removeCaptions=" + this.removeCaptions + ", removeBloat=" + this.removeBloat + ", upperCase=" + this.upperCase + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SaveCaptionStyle(int r17, int r18, int r19, int r20, int r21, java.lang.Integer r22, java.lang.String r23, int r24, java.lang.Float r25, boolean r26, boolean r27, boolean r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r13 = 0
            goto L_0x000b
        L_0x0009:
            r13 = r26
        L_0x000b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            r14 = 1
            goto L_0x0014
        L_0x0012:
            r14 = r27
        L_0x0014:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x001a
            r15 = 0
            goto L_0x001c
        L_0x001a:
            r15 = r28
        L_0x001c:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.data.model.SaveCaptionStyle.<init>(int, int, int, int, int, java.lang.Integer, java.lang.String, int, java.lang.Float, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

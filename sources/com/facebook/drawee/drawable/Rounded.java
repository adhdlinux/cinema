package com.facebook.drawee.drawable;

public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    boolean getPaintFilterBitmap();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int i2, float f2);

    void setCircle(boolean z2);

    void setPadding(float f2);

    void setPaintFilterBitmap(boolean z2);

    void setRadii(float[] fArr);

    void setRadius(float f2);

    void setScaleDownInsideBorders(boolean z2);
}

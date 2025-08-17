package com.facebook.yoga;

public interface YogaProps {
    YogaAlign getAlignContent();

    YogaAlign getAlignItems();

    YogaAlign getAlignSelf();

    float getAspectRatio();

    float getBorder(YogaEdge yogaEdge);

    YogaValue getFlexBasis();

    YogaFlexDirection getFlexDirection();

    float getFlexGrow();

    float getFlexShrink();

    YogaValue getHeight();

    YogaJustify getJustifyContent();

    YogaValue getMargin(YogaEdge yogaEdge);

    YogaValue getMaxHeight();

    YogaValue getMaxWidth();

    YogaValue getMinHeight();

    YogaValue getMinWidth();

    YogaValue getPadding(YogaEdge yogaEdge);

    YogaValue getPosition(YogaEdge yogaEdge);

    YogaPositionType getPositionType();

    YogaDirection getStyleDirection();

    YogaValue getWidth();

    void setAlignContent(YogaAlign yogaAlign);

    void setAlignItems(YogaAlign yogaAlign);

    void setAlignSelf(YogaAlign yogaAlign);

    void setAspectRatio(float f2);

    void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    void setBorder(YogaEdge yogaEdge, float f2);

    void setDirection(YogaDirection yogaDirection);

    void setFlex(float f2);

    void setFlexBasis(float f2);

    void setFlexBasisAuto();

    void setFlexBasisPercent(float f2);

    void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    void setFlexGrow(float f2);

    void setFlexShrink(float f2);

    void setHeight(float f2);

    void setHeightAuto();

    void setHeightPercent(float f2);

    void setIsReferenceBaseline(boolean z2);

    void setJustifyContent(YogaJustify yogaJustify);

    void setMargin(YogaEdge yogaEdge, float f2);

    void setMarginAuto(YogaEdge yogaEdge);

    void setMarginPercent(YogaEdge yogaEdge, float f2);

    void setMaxHeight(float f2);

    void setMaxHeightPercent(float f2);

    void setMaxWidth(float f2);

    void setMaxWidthPercent(float f2);

    void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction);

    void setMinHeight(float f2);

    void setMinHeightPercent(float f2);

    void setMinWidth(float f2);

    void setMinWidthPercent(float f2);

    void setPadding(YogaEdge yogaEdge, float f2);

    void setPaddingPercent(YogaEdge yogaEdge, float f2);

    void setPosition(YogaEdge yogaEdge, float f2);

    void setPositionPercent(YogaEdge yogaEdge, float f2);

    void setPositionType(YogaPositionType yogaPositionType);

    void setWidth(float f2);

    void setWidthAuto();

    void setWidthPercent(float f2);

    void setWrap(YogaWrap yogaWrap);
}

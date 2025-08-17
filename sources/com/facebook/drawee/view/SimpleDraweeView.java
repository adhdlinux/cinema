package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class SimpleDraweeView extends GenericDraweeView {
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private AbstractDraweeControllerBuilder mControllerBuilder;

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        int resourceId;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                Preconditions.checkNotNull(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = (AbstractDraweeControllerBuilder) sDraweecontrollerbuildersupplier.get();
            }
            if (attributeSet != null) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleDraweeView);
                int i2 = R.styleable.SimpleDraweeView_actualImageUri;
                if (obtainStyledAttributes.hasValue(i2)) {
                    setImageURI(Uri.parse(obtainStyledAttributes.getString(i2)), (Object) null);
                } else {
                    int i3 = R.styleable.SimpleDraweeView_actualImageResource;
                    if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, -1)) != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    /* access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setActualImageResource(int i2) {
        setActualImageResource(i2, (Object) null);
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }

    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setActualImageResource(int i2, Object obj) {
        setImageURI(UriUtil.getUriForResourceId(i2), obj);
    }

    public void setImageURI(String str) {
        setImageURI(str, (Object) null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public void setImageURI(Uri uri, Object obj) {
        setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(context, attributeSet);
    }

    public void setImageURI(String str, Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }
}

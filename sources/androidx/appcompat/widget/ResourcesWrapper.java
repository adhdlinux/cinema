package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.resources.Compatibility$Api15Impl;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1347a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1347a = resources;
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i2) throws Resources.NotFoundException {
        return super.getDrawable(i2);
    }

    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        return this.f1347a.getAnimation(i2);
    }

    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        return this.f1347a.getBoolean(i2);
    }

    public int getColor(int i2) throws Resources.NotFoundException {
        return this.f1347a.getColor(i2);
    }

    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return this.f1347a.getColorStateList(i2);
    }

    public Configuration getConfiguration() {
        return this.f1347a.getConfiguration();
    }

    public float getDimension(int i2) throws Resources.NotFoundException {
        return this.f1347a.getDimension(i2);
    }

    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        return this.f1347a.getDimensionPixelOffset(i2);
    }

    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        return this.f1347a.getDimensionPixelSize(i2);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f1347a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.e(this.f1347a, i2, theme);
    }

    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        return ResourcesCompat.f(this.f1347a, i2, i3, (Resources.Theme) null);
    }

    public float getFraction(int i2, int i3, int i4) {
        return this.f1347a.getFraction(i2, i3, i4);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f1347a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        return this.f1347a.getIntArray(i2);
    }

    public int getInteger(int i2) throws Resources.NotFoundException {
        return this.f1347a.getInteger(i2);
    }

    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        return this.f1347a.getLayout(i2);
    }

    public Movie getMovie(int i2) throws Resources.NotFoundException {
        return this.f1347a.getMovie(i2);
    }

    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        return this.f1347a.getQuantityString(i2, i3, objArr);
    }

    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        return this.f1347a.getQuantityText(i2, i3);
    }

    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return this.f1347a.getResourceEntryName(i2);
    }

    public String getResourceName(int i2) throws Resources.NotFoundException {
        return this.f1347a.getResourceName(i2);
    }

    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return this.f1347a.getResourcePackageName(i2);
    }

    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return this.f1347a.getResourceTypeName(i2);
    }

    public String getString(int i2) throws Resources.NotFoundException {
        return this.f1347a.getString(i2);
    }

    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        return this.f1347a.getStringArray(i2);
    }

    public CharSequence getText(int i2) throws Resources.NotFoundException {
        return this.f1347a.getText(i2);
    }

    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        return this.f1347a.getTextArray(i2);
    }

    public void getValue(int i2, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f1347a.getValue(i2, typedValue, z2);
    }

    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        Compatibility$Api15Impl.a(this.f1347a, i2, i3, typedValue, z2);
    }

    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return this.f1347a.getXml(i2);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1347a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return this.f1347a.obtainTypedArray(i2);
    }

    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return this.f1347a.openRawResource(i2);
    }

    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        return this.f1347a.openRawResourceFd(i2);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f1347a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f1347a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1347a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return ResourcesCompat.f(this.f1347a, i2, i3, theme);
    }

    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        return this.f1347a.getQuantityString(i2, i3);
    }

    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f1347a.getString(i2, objArr);
    }

    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.f1347a.getText(i2, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f1347a.getValue(str, typedValue, z2);
    }

    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f1347a.openRawResource(i2, typedValue);
    }
}

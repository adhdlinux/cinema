package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;

public abstract class DialogPreference extends Preference {
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;

    public interface TargetFragment {
        <T extends Preference> T findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.D, i2, i3);
        String o2 = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.N, R$styleable.E);
        this.mDialogTitle = o2;
        if (o2 == null) {
            this.mDialogTitle = getTitle();
        }
        this.mDialogMessage = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.M, R$styleable.F);
        this.mDialogIcon = TypedArrayUtils.c(obtainStyledAttributes, R$styleable.K, R$styleable.G);
        this.mPositiveButtonText = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.P, R$styleable.H);
        this.mNegativeButtonText = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.O, R$styleable.I);
        this.mDialogLayoutResId = TypedArrayUtils.n(obtainStyledAttributes, R$styleable.L, R$styleable.J, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        getPreferenceManager().t(this);
    }

    public void setDialogIcon(Drawable drawable) {
        this.mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i2) {
        this.mDialogLayoutResId = i2;
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.mDialogMessage = charSequence;
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.mDialogTitle = charSequence;
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.mNegativeButtonText = charSequence;
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.mPositiveButtonText = charSequence;
    }

    public void setDialogIcon(int i2) {
        this.mDialogIcon = AppCompatResources.b(getContext(), i2);
    }

    public void setDialogMessage(int i2) {
        setDialogMessage((CharSequence) getContext().getString(i2));
    }

    public void setDialogTitle(int i2) {
        setDialogTitle((CharSequence) getContext().getString(i2));
    }

    public void setNegativeButtonText(int i2) {
        setNegativeButtonText((CharSequence) getContext().getString(i2));
    }

    public void setPositiveButtonText(int i2) {
        setPositiveButtonText((CharSequence) getContext().getString(i2));
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.dialogPreferenceStyle, 16842897));
    }

    public DialogPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}

package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;
import com.facebook.imageutils.JfifUtil;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final b f14634a;

    /* renamed from: o  reason: collision with root package name */
    private final Context f14635o;

    public a(b bVar, Context context) {
        super(c.b.DETAIL);
        this.f14634a = bVar;
        this.f14635o = context;
        this.f14702d = q();
        this.f14703e = r();
    }

    private SpannedString q() {
        return StringUtils.createSpannedString(this.f14634a.i(), b() ? -16777216 : -7829368, 18, 1);
    }

    private SpannedString r() {
        if (!b()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(s());
        spannableStringBuilder.append(new SpannableString(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
        spannableStringBuilder.append(t());
        if (this.f14634a.a() == b.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append(new SpannableString(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString("Invalid Integration", -65536));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!this.f14634a.d()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", -65536);
        }
        if (!TextUtils.isEmpty(this.f14634a.j())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f14634a.j(), -16777216));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString(this.f14634a.e() ? "Retrieving SDK Version..." : "SDK Found", -16777216);
    }

    private SpannedString t() {
        String str;
        int i2;
        if (this.f14634a.e()) {
            i2 = -16777216;
            if (!TextUtils.isEmpty(this.f14634a.k())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
                spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f14634a.k(), -16777216));
                if (this.f14634a.f()) {
                    spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 127, 0)));
                    spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f14634a.l(), -16777216));
                }
                return new SpannedString(spannableStringBuilder);
            }
            str = "Adapter Found";
        } else {
            str = "Adapter Missing";
            i2 = -65536;
        }
        return StringUtils.createListItemDetailSpannedString(str, i2);
    }

    public boolean b() {
        return this.f14634a.a() != b.a.MISSING;
    }

    public b d() {
        return this.f14634a;
    }

    public int e() {
        int o2 = this.f14634a.o();
        return o2 > 0 ? o2 : R.drawable.applovin_ic_mediation_placeholder;
    }

    public int f() {
        return b() ? R.drawable.applovin_ic_disclosure_arrow : super.e();
    }

    public int g() {
        return f.a(R.color.applovin_sdk_disclosureButtonColor, this.f14635o);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + this.f14702d + ", detailText=" + this.f14703e + ", network=" + this.f14634a + "}";
    }
}

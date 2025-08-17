package com.nononsenseapps.filepicker;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.nononsenseapps.filepicker.AbstractFilePickerFragment;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFilePickerActivity<T> extends AppCompatActivity implements AbstractFilePickerFragment.OnFilePickedListener {

    /* renamed from: b  reason: collision with root package name */
    protected String f33685b = null;

    /* renamed from: c  reason: collision with root package name */
    protected int f33686c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f33687d = false;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f33688e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33689f = true;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f33690g = false;

    @TargetApi(16)
    public void g(List<Uri> list) {
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        ArrayList arrayList = new ArrayList();
        for (Uri uri : list) {
            arrayList.add(uri.toString());
        }
        intent.putStringArrayListExtra("nononsense.intent.PATHS", arrayList);
        ClipData clipData = null;
        for (Uri next : list) {
            if (clipData == null) {
                clipData = new ClipData("Paths", new String[0], new ClipData.Item(next));
            } else {
                clipData.addItem(new ClipData.Item(next));
            }
        }
        intent.setClipData(clipData);
        setResult(-1, intent);
        finish();
    }

    public void k() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.nnf_activity_filepicker);
        Intent intent = getIntent();
        if (intent != null) {
            this.f33685b = intent.getStringExtra("nononsense.intent.START_PATH");
            this.f33686c = intent.getIntExtra("nononsense.intent.MODE", this.f33686c);
            this.f33687d = intent.getBooleanExtra("nononsense.intent.ALLOW_CREATE_DIR", this.f33687d);
            this.f33688e = intent.getBooleanExtra("android.intent.extra.ALLOW_MULTIPLE", this.f33688e);
            this.f33689f = intent.getBooleanExtra("android.intent.extra.ALLOW_EXISTING_FILE", this.f33689f);
            this.f33690g = intent.getBooleanExtra("nononsense.intent.SINGLE_CLICK", this.f33690g);
        }
        setResult(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment i02 = supportFragmentManager.i0("filepicker_fragment");
        if (i02 == null) {
            i02 = z(this.f33685b, this.f33686c, this.f33688e, this.f33687d, this.f33689f, this.f33690g);
        }
        if (i02 != null) {
            supportFragmentManager.n().q(R$id.fragment, i02, "filepicker_fragment").h();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(bundle);
    }

    public void v(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public abstract AbstractFilePickerFragment<T> z(String str, int i2, boolean z2, boolean z3, boolean z4, boolean z5);
}

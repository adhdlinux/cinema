package com.movie.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.movie.AppComponent;
import com.movie.ui.widget.AspectLockedImageView;
import com.yoku.marumovie.R;

public class BarcodeActivity extends BaseActivity {
    @BindView(2131362275)
    AspectLockedImageView imgbarcode;
    @BindView(2131362826)
    Toolbar toolbar;
    @BindView(2131362868)
    TextView tvText;

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        finish();
    }

    public void B(String str) {
        int i2;
        try {
            BitMatrix a2 = new QRCodeWriter().a(str, BarcodeFormat.QR_CODE, 512, 512);
            int d2 = a2.d();
            int c2 = a2.c();
            Bitmap createBitmap = Bitmap.createBitmap(d2, c2, Bitmap.Config.RGB_565);
            for (int i3 = 0; i3 < d2; i3++) {
                for (int i4 = 0; i4 < c2; i4++) {
                    if (a2.b(i3, i4)) {
                        i2 = -16777216;
                    } else {
                        i2 = -1;
                    }
                    createBitmap.setPixel(i3, i4, i2);
                }
            }
            this.imgbarcode.setImageBitmap(createBitmap);
        } catch (WriterException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_barcode);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.t(true);
            this.toolbar.setTitle((CharSequence) "Barcode");
            this.toolbar.setNavigationOnClickListener(new b(this));
        }
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("extra_barcode");
        String string2 = extras.getString("extra_barcode");
        if (string2 == null || string2.isEmpty()) {
            this.tvText.setText(string);
        } else {
            this.tvText.setText(string2);
        }
        B(string);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}

package com.utils.download;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.MainActivity;
import com.movie.ui.activity.settings.SettingsActivity;
import com.original.tase.utils.NetworkUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.Calendar;
import us.shandian.giga.service.DownloadManagerService;
import us.shandian.giga.ui.fragment.AllMissionsFragment;

public class DownloadActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    private long f37646b = 0;

    /* access modifiers changed from: private */
    public void A() {
        getSupportFragmentManager().n().p(R.id.frame, new AllMissionsFragment()).u(4099).h();
    }

    public void onBackPressed() {
        long j2;
        if (!NetworkUtils.a() || !isTaskRoot()) {
            super.onBackPressed();
        } else {
            Utils.f0();
            long time = Calendar.getInstance().getTime().getTime() - this.f37646b;
            Handler handler = new Handler();
            AnonymousClass2 r3 = new Runnable() {
                public void run() {
                    int S = Utils.S(FreeMoviesApp.p().getString("pref_choose_default_tab", "Latest"));
                    Intent intent = new Intent(DownloadActivity.this, MainActivity.class);
                    intent.putExtra("GotNavID", S);
                    DownloadActivity.this.startActivity(intent);
                }
            };
            if (time < 200) {
                j2 = 200 - time;
            } else {
                j2 = 0;
            }
            handler.postDelayed(r3, j2);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, DownloadManagerService.class);
        startService(intent);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_downloader);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.B("Download Free size: " + ("[" + Formatter.formatFileSize(Utils.v(), Utils.J()) + "]"));
            supportActionBar.u(true);
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                DownloadActivity.this.A();
                DownloadActivity.this.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.download_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}

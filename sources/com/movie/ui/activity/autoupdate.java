package com.movie.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.utils.PrefUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class autoupdate {

    /* renamed from: a  reason: collision with root package name */
    public static ProgressBar f32188a = null;

    /* renamed from: b  reason: collision with root package name */
    public static TextView f32189b = null;

    /* renamed from: c  reason: collision with root package name */
    public static ImageView f32190c = null;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadTask f32191d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Dialog f32192e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Dialog f32193f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Dialog f32194g = null;

    /* renamed from: h  reason: collision with root package name */
    public static Dialog f32195h = null;

    /* renamed from: i  reason: collision with root package name */
    public static Activity f32196i = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f32197j = "";

    /* renamed from: k  reason: collision with root package name */
    public static String f32198k = "";

    /* renamed from: l  reason: collision with root package name */
    public static Integer f32199l = 100;

    /* renamed from: m  reason: collision with root package name */
    public static String f32200m = "";

    /* renamed from: n  reason: collision with root package name */
    public static String f32201n = "";

    /* renamed from: o  reason: collision with root package name */
    public static String f32202o = "";

    /* renamed from: p  reason: collision with root package name */
    public static int f32203p = 22597408;

    /* renamed from: q  reason: collision with root package name */
    public static int f32204q = 0;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f32205r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f32206s = false;

    /* renamed from: t  reason: collision with root package name */
    public static int f32207t = 0;

    private static class DownloadTask extends AsyncTask<String, Integer, Long> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f32211a;

        /* renamed from: b  reason: collision with root package name */
        public double f32212b;

        private DownloadTask() {
            this.f32211a = false;
            this.f32212b = (double) System.currentTimeMillis();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Long doInBackground(String... strArr) {
            long j2;
            int length = strArr.length;
            try {
                autoupdate.f32197j = autoupdate.f32196i.getExternalFilesDir((String) null).toString() + "/" + autoupdate.f32199l + ".apk";
                j2 = (long) b(strArr[0]);
            } catch (IOException e2) {
                e2.printStackTrace();
                j2 = -1;
            }
            return Long.valueOf(j2);
        }

        public int b(String str) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                httpURLConnection.getHeaderField("Content-Disposition");
                httpURLConnection.getContentType();
                httpURLConnection.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                new BufferedInputStream(httpURLConnection.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(autoupdate.f32197j);
                int available = bufferedInputStream.available();
                autoupdate.f32204q = available;
                byte[] bArr = new byte[1024];
                if (available == 0) {
                    autoupdate.f32204q = autoupdate.f32203p;
                }
                int read = bufferedInputStream.read(bArr);
                float f2 = 0.0f;
                while (read != -1) {
                    if (!this.f32211a) {
                        f2 += (float) read;
                        publishProgress(new Integer[]{Integer.valueOf((int) f2)});
                        fileOutputStream.write(bArr, 0, read);
                        read = bufferedInputStream.read(bArr);
                    }
                }
                publishProgress(new Integer[]{100});
                fileOutputStream.close();
                bufferedInputStream.close();
                return 1;
            }
            PrintStream printStream = System.out;
            printStream.println("No file to download. Server replied HTTP code: " + responseCode);
            httpURLConnection.disconnect();
            return -1;
        }

        public void c() {
            this.f32211a = true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(Long l2) {
            if (l2.longValue() == 1) {
                if (autoupdate.b()) {
                    autoupdate.f();
                } else {
                    autoupdate.j(autoupdate.f32196i);
                }
                autoupdate.f32192e.dismiss();
                return;
            }
            autoupdate.f32192e.dismiss();
            autoupdate.l(autoupdate.f32196i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void onProgressUpdate(Integer... numArr) {
            double currentTimeMillis = (double) System.currentTimeMillis();
            if (currentTimeMillis - this.f32212b >= 100.0d) {
                autoupdate.h(numArr[0].intValue());
                this.f32212b = currentTimeMillis;
            }
        }

        public void f() {
            this.f32211a = false;
        }
    }

    public static boolean a(Activity activity, boolean z2) {
        String str;
        int b02 = Utils.b0();
        f32196i = activity;
        f32199l = Integer.valueOf(GlobalVariable.c().b().getUpdate().getVersionCode());
        f32200m = GlobalVariable.c().b().getUpdate().getLink();
        f32202o = GlobalVariable.c().b().getUpdate().getDescription();
        f32203p = GlobalVariable.c().b().getUpdate().getSize();
        f32206s = GlobalVariable.c().b().getUpdate().isForceUpdate();
        String packagename = GlobalVariable.c().b().getUpdate().getPackagename();
        f32201n = packagename;
        if (packagename.isEmpty()) {
            f32201n = activity.getPackageName();
        }
        int i2 = FreeMoviesApp.p().getInt("pref_clean_apk", -1);
        if (i2 < 0) {
            for (int i3 = 55; i3 <= f32199l.intValue(); i3++) {
                c(String.format(d(), new Object[]{Integer.valueOf(i3)}));
            }
            FreeMoviesApp.p().edit().putInt("pref_clean_apk", f32199l.intValue()).apply();
        } else {
            c(String.format(d(), new Object[]{Integer.valueOf(i2)}));
        }
        if ((!f32206s && !z2 && PrefUtils.i(f32196i)) || f32199l.intValue() <= b02 || (str = f32200m) == null || str.equals("")) {
            return false;
        }
        i(activity);
        return true;
    }

    public static boolean b() {
        try {
            if (Settings.Secure.getInt(f32196i.getContentResolver(), "install_non_market_apps") == 1) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void c(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static String d() {
        if (f32198k.isEmpty()) {
            f32198k = f32196i.getExternalFilesDir((String) null).toString() + "/%s.apk";
        }
        return f32198k;
    }

    public static void e(Activity activity, Dialog dialog, int i2) {
        f32207t = i2;
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                int i3 = autoupdate.f32207t;
                if (i3 == 1) {
                    autoupdate.f32194g.dismiss();
                } else if (i3 == 2) {
                    autoupdate.k(autoupdate.f32196i);
                } else if (i3 == 3) {
                    autoupdate.f32193f.dismiss();
                } else if (i3 == 4) {
                    autoupdate.f32195h.dismiss();
                }
                return true;
            }
        });
    }

    public static void f() {
        Uri uri;
        try {
            FreeMoviesApp.p().edit().putInt("pref_clean_apk", f32199l.intValue()).apply();
            File file = new File(f32197j);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.INSTALL_PACKAGE");
            if (Build.VERSION.SDK_INT < 24) {
                uri = Uri.fromFile(file);
            } else {
                Activity activity = f32196i;
                uri = FileProvider.f(activity, f32196i.getPackageName() + ".provider", file);
                intent.setFlags(1);
            }
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            intent.addFlags(268468224);
            intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", f32201n);
            intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
            f32196i.startActivityForResult(intent, 444);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void g(Activity activity) {
        Dialog dialog = new Dialog(activity);
        f32192e = dialog;
        dialog.requestWindowFeature(1);
        f32192e.setCancelable(false);
        f32192e.setContentView(R.layout.dialog_autoupdate_processdownload);
        f32188a = (ProgressBar) f32192e.findViewById(R.id.autoupdate_progressBar);
        f32190c = (ImageView) f32192e.findViewById(R.id.diag_downloading_image_close);
        f32189b = (TextView) f32192e.findViewById(R.id.diag_tv_prosess_kb);
        if (f32206s) {
            f32190c.setVisibility(4);
        } else {
            e(activity, f32192e, 2);
        }
        f32190c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                autoupdate.f32191d.c();
                autoupdate.k(autoupdate.f32196i);
            }
        });
        f32188a.setProgress(1);
        f32192e.show();
        String str = f32200m;
        c(f32197j);
        DownloadTask downloadTask = new DownloadTask();
        f32191d = downloadTask;
        downloadTask.execute(new String[]{str});
    }

    public static void h(int i2) {
        int i3 = (int) ((((float) i2) / ((float) f32204q)) * 100.0f);
        if (i3 > 2) {
            TextView textView = f32189b;
            textView.setText("" + (i2 / 1024) + "kb");
            f32189b.invalidate();
            f32188a.setProgress(i3);
        }
    }

    public static void i(final Activity activity) {
        f32196i = activity;
        Dialog dialog = new Dialog(activity);
        f32194g = dialog;
        dialog.requestWindowFeature(1);
        f32194g.setCancelable(false);
        f32194g.setContentView(R.layout.dialog_autoupdate);
        TextView textView = (TextView) f32194g.findViewById(R.id.message_autoupdate);
        String str = f32202o;
        if (str != null && !str.equals("")) {
            textView.setText(f32202o);
        }
        Button button = (Button) f32194g.findViewById(R.id.btn_update);
        Button button2 = (Button) f32194g.findViewById(R.id.diag_btn_autoupdate_cancel);
        CheckBox checkBox = (CheckBox) f32194g.findViewById(R.id.autoupdate_checkBox4);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (compoundButton.isChecked()) {
                    PrefUtils.s(autoupdate.f32196i, true);
                } else {
                    PrefUtils.s(autoupdate.f32196i, false);
                }
            }
        });
        if (f32206s) {
            checkBox.setVisibility(8);
            button2.setVisibility(8);
        } else {
            e(activity, f32194g, 1);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    autoupdate.f32194g.dismiss();
                }
            });
        }
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                autoupdate.f32194g.dismiss();
                autoupdate.g(activity);
                NotificationManagerCompat.d(activity).b(2000);
            }
        });
        button.requestFocus();
        f32194g.show();
    }

    public static void j(Activity activity) {
        f32196i = activity;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_autoupdate_unknowsource);
        ((Button) dialog.findViewById(R.id.btn_update_unknowsource_oke)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                autoupdate.f();
            }
        });
        dialog.show();
    }

    public static void k(Activity activity) {
        if (f32193f == null) {
            f32191d.c();
            Dialog dialog = new Dialog(activity);
            f32193f = dialog;
            dialog.requestWindowFeature(1);
            f32193f.setCancelable(false);
            f32193f.setContentView(R.layout.dialog_confirm_yesno);
            ((Button) f32193f.findViewById(R.id.diag_btn_confirm_no)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    autoupdate.f32191d.f();
                    autoupdate.f32193f.dismiss();
                    autoupdate.f32193f = null;
                }
            });
            ((Button) f32193f.findViewById(R.id.diag_btnconfirm_yes)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    autoupdate.f32191d.cancel(true);
                    autoupdate.f32192e.dismiss();
                    autoupdate.f32193f.dismiss();
                    autoupdate.f32193f = null;
                }
            });
            f32193f.show();
        }
    }

    public static void l(final Activity activity) {
        Dialog dialog = new Dialog(activity);
        f32195h = dialog;
        dialog.requestWindowFeature(1);
        f32195h.setCancelable(false);
        f32195h.setContentView(R.layout.dialog_autoupdate_error);
        e(activity, f32195h, 4);
        ((Button) f32195h.findViewById(R.id.btn_update_error)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                autoupdate.f32195h.dismiss();
                autoupdate.g(activity);
            }
        });
        ((Button) f32195h.findViewById(R.id.dig_autoupdate_error_cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                autoupdate.f32195h.dismiss();
            }
        });
        f32195h.show();
    }
}

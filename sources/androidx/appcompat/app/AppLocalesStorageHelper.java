package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.hermes.intl.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlSerializer;

class AppLocalesStorageHelper {

    static class SerialExecutor implements Executor {

        /* renamed from: b  reason: collision with root package name */
        private final Object f498b = new Object();

        /* renamed from: c  reason: collision with root package name */
        final Queue<Runnable> f499c = new ArrayDeque();

        /* renamed from: d  reason: collision with root package name */
        final Executor f500d;

        /* renamed from: e  reason: collision with root package name */
        Runnable f501e;

        SerialExecutor(Executor executor) {
            this.f500d = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            synchronized (this.f498b) {
                Runnable poll = this.f499c.poll();
                this.f501e = poll;
                if (poll != null) {
                    this.f500d.execute(poll);
                }
            }
        }

        public void execute(Runnable runnable) {
            synchronized (this.f498b) {
                this.f499c.add(new l(this, runnable));
                if (this.f501e == null) {
                    c();
                }
            }
        }
    }

    static class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    static void a(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, (String) null);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag((String) null, "locales");
                newSerializer.attribute((String) null, "application_locales", str);
                newSerializer.endTag((String) null, "locales");
                newSerializer.endDocument();
                Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                if (openFileOutput == null) {
                    return;
                }
            } catch (Exception e2) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: " + str, e2);
                if (openFileOutput == null) {
                    return;
                }
            } catch (Throwable th) {
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                openFileOutput.close();
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{"androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"}));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r3 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        if (r3 == null) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String b(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0077 }
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            int r5 = r4.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004a }
        L_0x0017:
            int r6 = r4.next()     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            r7 = 1
            if (r6 == r7) goto L_0x0040
            r7 = 3
            if (r6 != r7) goto L_0x0027
            int r8 = r4.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            if (r8 <= r5) goto L_0x0040
        L_0x0027:
            if (r6 == r7) goto L_0x0017
            r7 = 4
            if (r6 != r7) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            java.lang.String r6 = r4.getName()     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch:{ IOException | XmlPullParserException -> 0x004a }
            if (r6 == 0) goto L_0x0017
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch:{ IOException | XmlPullParserException -> 0x004a }
        L_0x0040:
            if (r3 == 0) goto L_0x0052
        L_0x0042:
            r3.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0052
        L_0x0046:
            goto L_0x0052
        L_0x0048:
            r9 = move-exception
            goto L_0x0071
        L_0x004a:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0052
            goto L_0x0042
        L_0x0052:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x006d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r1, r9)
            goto L_0x0070
        L_0x006d:
            r9.deleteFile(r0)
        L_0x0070:
            return r2
        L_0x0071:
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ IOException -> 0x0076 }
        L_0x0076:
            throw r9
        L_0x0077:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppLocalesStorageHelper.b(android.content.Context):java.lang.String");
    }

    static void c(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (AppCompatDelegate.k().f()) {
                    String b2 = b(context);
                    Object systemService = context.getSystemService(Constants.LOCALE);
                    if (systemService != null) {
                        AppCompatDelegate.Api33Impl.b(systemService, AppCompatDelegate.Api24Impl.a(b2));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }
}

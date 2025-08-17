package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigFactory {

        /* renamed from: a  reason: collision with root package name */
        private final DefaultEmojiCompatConfigHelper f3044a;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.f3044a = defaultEmojiCompatConfigHelper == null ? e() : defaultEmojiCompatConfigHelper;
        }

        private EmojiCompat.Config a(Context context, FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        private List<List<byte[]>> b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature byteArray : signatureArr) {
                arrayList.add(byteArray.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private FontRequest d(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new FontRequest(str, str2, "emojicompat-emoji-font", b(this.f3044a.b(packageManager, str2)));
        }

        private static DefaultEmojiCompatConfigHelper e() {
            if (Build.VERSION.SDK_INT >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            return new DefaultEmojiCompatConfigHelper_API19();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r2 = r2.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean f(android.content.pm.ProviderInfo r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r2 = r2.applicationInfo
                if (r2 == 0) goto L_0x000d
                int r2 = r2.flags
                r0 = 1
                r2 = r2 & r0
                if (r2 != r0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.f(android.content.pm.ProviderInfo):boolean");
        }

        private ProviderInfo g(PackageManager packageManager) {
            for (ResolveInfo a2 : this.f3044a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0)) {
                ProviderInfo a3 = this.f3044a.a(a2);
                if (f(a3)) {
                    return a3;
                }
            }
            return null;
        }

        public EmojiCompat.Config c(Context context) {
            return a(context, h(context));
        }

        /* access modifiers changed from: package-private */
        public FontRequest h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.h(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g2 = g(packageManager);
            if (g2 == null) {
                return null;
            }
            try {
                return d(g2, packageManager);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                return null;
            }
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i2) {
            return Collections.emptyList();
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i2) {
            return packageManager.queryIntentContentProviders(intent, i2);
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig a(Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfigHelper) null).c(context);
    }
}

package us.shandian.giga.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.Toast;
import com.yoku.marumovie.R;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {

    /* renamed from: us.shandian.giga.util.Utility$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42292a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                us.shandian.giga.util.Utility$FileType[] r0 = us.shandian.giga.util.Utility.FileType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42292a = r0
                us.shandian.giga.util.Utility$FileType r1 = us.shandian.giga.util.Utility.FileType.MUSIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42292a     // Catch:{ NoSuchFieldError -> 0x001d }
                us.shandian.giga.util.Utility$FileType r1 = us.shandian.giga.util.Utility.FileType.VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: us.shandian.giga.util.Utility.AnonymousClass1.<clinit>():void");
        }
    }

    public enum FileType {
        VIDEO,
        MUSIC,
        UNKNOWN
    }

    public static String a(String str, String str2) {
        int i2;
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException unused) {
                    }
                }
                byte[] digest = instance.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (FileNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void b(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
        Toast.makeText(context, R.string.msg_copied, 0).show();
    }

    public static String c(long j2) {
        if (j2 < 1024) {
            return String.format("%d B", new Object[]{Long.valueOf(j2)});
        } else if (j2 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%.2f kB", new Object[]{Float.valueOf(((float) j2) / 1024.0f)});
        } else if (j2 < 1073741824) {
            return String.format("%.2f MB", new Object[]{Float.valueOf((((float) j2) / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.2f GB", new Object[]{Float.valueOf(((((float) j2) / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static String d(float f2) {
        if (f2 < 1024.0f) {
            return String.format("%.2f B/s", new Object[]{Float.valueOf(f2)});
        } else if (f2 < 1048576.0f) {
            return String.format("%.2f kB/s", new Object[]{Float.valueOf(f2 / 1024.0f)});
        } else if (f2 < 1.07374182E9f) {
            return String.format("%.2f MB/s", new Object[]{Float.valueOf((f2 / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.2f GB/s", new Object[]{Float.valueOf(((f2 / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static int e(FileType fileType) {
        int i2 = AnonymousClass1.f42292a[fileType.ordinal()];
        return i2 != 1 ? i2 != 2 ? R.color.gray : R.color.video_left_to_load_color : R.color.audio_left_to_load_color;
    }

    public static FileType f(String str) {
        if (str.endsWith(".mp3") || str.endsWith(".wav") || str.endsWith(".flac") || str.endsWith(".m4a")) {
            return FileType.MUSIC;
        }
        if (str.endsWith(".mp4") || str.endsWith(".mpeg") || str.endsWith(".rm") || str.endsWith(".rmvb") || str.endsWith(".flv") || str.endsWith(".webp") || str.endsWith(".webm")) {
            return FileType.VIDEO;
        }
        return FileType.UNKNOWN;
    }

    public static int g(FileType fileType) {
        int i2 = AnonymousClass1.f42292a[fileType.ordinal()];
        return i2 != 1 ? i2 != 2 ? R.color.gray : R.color.video_already_load_color : R.color.audio_already_load_color;
    }

    public static int h(FileType fileType) {
        return AnonymousClass1.f42292a[fileType.ordinal()] != 1 ? R.drawable.video : R.drawable.music;
    }

    public static <T> T i(String str) {
        ObjectInputStream objectInputStream;
        T t2 = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(str));
            try {
                t2 = objectInputStream.readObject();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            objectInputStream = null;
        }
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (Exception unused3) {
            }
        }
        return t2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[SYNTHETIC, Splitter:B:13:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0027 A[SYNTHETIC, Splitter:B:19:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void j(java.lang.String r4, java.io.Serializable r5) {
        /*
            r0 = 0
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r1.writeObject(r5)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r1.close()     // Catch:{ Exception -> 0x002a }
            goto L_0x002a
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001a:
            r0 = r1
            goto L_0x0025
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r4
        L_0x0024:
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.shandian.giga.util.Utility.j(java.lang.String, java.io.Serializable):void");
    }
}

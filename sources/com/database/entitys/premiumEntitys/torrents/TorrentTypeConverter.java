package com.database.entitys.premiumEntitys.torrents;

import com.movie.data.model.TorrentObject;

public class TorrentTypeConverter {

    /* renamed from: com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19352a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.movie.data.model.TorrentObject$Type[] r0 = com.movie.data.model.TorrentObject.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19352a = r0
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19352a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter.AnonymousClass1.<clinit>():void");
        }
    }

    public static TorrentObject.Type a(String str) {
        str.hashCode();
        if (str.equals("AD")) {
            return TorrentObject.Type.AD;
        }
        if (!str.equals("PM")) {
            return TorrentObject.Type.RD;
        }
        return TorrentObject.Type.PM;
    }

    public static String b(TorrentObject.Type type) {
        int i2 = AnonymousClass1.f19352a[type.ordinal()];
        return i2 != 1 ? i2 != 2 ? "RD" : "PM" : "AD";
    }
}

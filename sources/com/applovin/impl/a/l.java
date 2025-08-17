package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final DateFormat f13807a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    private static final Random f13808b = new Random(System.currentTimeMillis());

    public static Uri a(String str, long j2, Uri uri, f fVar, m mVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String num = Integer.toString(fVar.a());
                String replace = str.replace("[ERRORCODE]", num).replace("[REASON]", num);
                if (j2 >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", a(j2));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
            } catch (Throwable th) {
                if (v.a()) {
                    v A = mVar.A();
                    A.b("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                return null;
            }
        } else {
            if (v.a()) {
                mVar.A().e("VastUtils", "Unable to replace macros in invalid URL string.");
            }
            return null;
        }
    }

    public static f a(a aVar) {
        if (b(aVar) || c(aVar)) {
            return null;
        }
        return f.GENERAL_WRAPPER_ERROR;
    }

    private static String a() {
        return Integer.toString(f13808b.nextInt(89999999) + 10000000);
    }

    private static String a(long j2) {
        if (j2 <= 0) {
            return "00:00:00.000";
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j2);
        long minutes = timeUnit.toMinutes(j2);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        long seconds = j2 % timeUnit2.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1)), Long.valueOf(seconds)});
    }

    public static String a(e eVar) {
        r c2;
        if (eVar != null) {
            List<r> b2 = eVar.b();
            int size = eVar.b().size();
            if (size <= 0 || (c2 = b2.get(size - 1).c("VASTAdTagURI")) == null) {
                return null;
            }
            return c2.c();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static String a(r rVar, String str, String str2) {
        r b2 = rVar.b(str);
        if (b2 != null) {
            String c2 = b2.c();
            if (StringUtils.isValidString(c2)) {
                return c2;
            }
        }
        return str2;
    }

    private static Set<j> a(e eVar, m mVar) {
        if (eVar == null) {
            return null;
        }
        List<r> b2 = eVar.b();
        Set<j> hashSet = new HashSet<>(b2.size());
        for (r next : b2) {
            r c2 = next.c("Wrapper");
            if (c2 == null) {
                c2 = next.c("InLine");
            }
            hashSet = a(hashSet, c2 != null ? c2.a("Error") : next.a("Error"), eVar, mVar);
        }
        if (v.a()) {
            v A = mVar.A();
            A.b("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static Set<j> a(Set<j> set, List<r> list, e eVar, m mVar) {
        if (list != null) {
            for (r a2 : list) {
                j a3 = j.a(a2, eVar, mVar);
                if (a3 != null) {
                    set.add(a3);
                }
            }
        }
        return set;
    }

    public static void a(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, f fVar, int i2, m mVar) {
        if (mVar != null) {
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i2);
            }
            a(a(eVar, mVar), fVar, mVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    public static void a(r rVar, Map<String, Set<j>> map, e eVar, m mVar) {
        List<r> a2;
        if (mVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        } else if (rVar == null) {
            if (v.a()) {
                mVar.A().e("VastUtils", "Unable to render event trackers; null node provided");
            }
        } else if (map != null) {
            r b2 = rVar.b("TrackingEvents");
            if (b2 != null && (a2 = b2.a("Tracking")) != null) {
                for (r next : a2) {
                    String str = next.b().get("event");
                    if (StringUtils.isValidString(str)) {
                        j a3 = j.a(next, eVar, mVar);
                        if (a3 != null) {
                            Set set = map.get(str);
                            if (set != null) {
                                set.add(a3);
                            } else {
                                HashSet hashSet = new HashSet();
                                hashSet.add(a3);
                                map.put(str, hashSet);
                            }
                        }
                    } else if (v.a()) {
                        v A = mVar.A();
                        A.e("VastUtils", "Could not find event for tracking node = " + next);
                    }
                }
            }
        } else if (v.a()) {
            mVar.A().e("VastUtils", "Unable to render event trackers; null event trackers provided");
        }
    }

    public static void a(List<r> list, Set<j> set, e eVar, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        } else if (list == null) {
            if (v.a()) {
                mVar.A().e("VastUtils", "Unable to render trackers; null nodes provided");
            }
        } else if (set != null) {
            for (r a2 : list) {
                j a3 = j.a(a2, eVar, mVar);
                if (a3 != null) {
                    set.add(a3);
                }
            }
        } else if (v.a()) {
            mVar.A().e("VastUtils", "Unable to render trackers; null trackers provided");
        }
    }

    public static void a(Set<j> set, long j2, Uri uri, f fVar, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (j b2 : set) {
                Uri a2 = a(b2.b(), j2, uri, fVar, mVar);
                if (a2 != null) {
                    mVar.U().a(h.o().c(a2.toString()).a(false).a(), false);
                }
            }
        }
    }

    public static void a(Set<j> set, f fVar, m mVar) {
        a(set, -1, (Uri) null, fVar, mVar);
    }

    public static void a(Set<j> set, m mVar) {
        a(set, -1, (Uri) null, f.UNSPECIFIED, mVar);
    }

    public static boolean a(r rVar) {
        if (rVar != null) {
            return rVar.c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    private static String b() {
        DateFormat dateFormat = f13807a;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = (r1 = r1.m()).a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(com.applovin.impl.a.a r1) {
        /*
            r0 = 0
            if (r1 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.a.m r1 = r1.m()
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = r1.a()
            if (r1 == 0) goto L_0x0017
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.l.b(com.applovin.impl.a.a):boolean");
    }

    public static boolean b(r rVar) {
        if (rVar != null) {
            return rVar.c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static boolean c(a aVar) {
        d aM;
        h b2;
        if (aVar == null || (aM = aVar.aM()) == null || (b2 = aM.b()) == null) {
            return false;
        }
        return b2.b() != null || StringUtils.isValidString(b2.c());
    }
}

package com.startapp;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.startapp.ic;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34714a;

    /* renamed from: b  reason: collision with root package name */
    public final ua<AnalyticsConfig> f34715b;

    public j3(Context context, ua<AnalyticsConfig> uaVar) {
        this.f34714a = context;
        this.f34715b = uaVar;
    }

    public void a(k3 k3Var) {
        long j2;
        long j3;
        List list;
        String group;
        k3 k3Var2 = k3Var;
        AnalyticsConfig call = this.f34715b.call();
        if (call != null && Math.random() < call.b()) {
            StringBuilder sb = new StringBuilder();
            boolean z2 = k3Var2.f34803d;
            sb.append("preLoading");
            sb.append('=');
            sb.append(z2 ? 1 : 0);
            sb.append(", ");
            if (k3Var2.f34804e) {
                boolean z3 = k3Var2.f34806g;
                sb.append("appPresent");
                sb.append('=');
                sb.append(z3 ? 1 : 0);
                sb.append(", ");
            }
            k3.a(sb);
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            List<String> a2 = call.a();
            k3.a(sb, "adId", k3Var2.f34801b, true);
            long j4 = k3Var2.f34802c.f34703d;
            sb.append(ViewProps.START);
            sb.append('=');
            sb.append(j4);
            sb.append(", ");
            Map<String, List<String>> map = k3Var2.f34802c.f34702c;
            if (map != null && (list = map.get("Server-Timing")) != null) {
                Pattern pattern = k3.f34800a;
                if (pattern == null) {
                    pattern = Pattern.compile("^total;dur=(\\d+(\\.\\d*)?)$");
                    k3.f34800a = pattern;
                }
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Matcher matcher = pattern.matcher((String) it2.next());
                    if (matcher.matches() && (group = matcher.group(1)) != null) {
                        j2 = (long) (Double.parseDouble(group) * 1000000.0d);
                        break;
                    }
                }
            }
            j2 = 0;
            if (j2 > 0) {
                k3.a(sb, "serverTotal", k3.a(j2), false);
            }
            ic.a aVar = k3Var2.f34802c;
            String str = sb2;
            k3.a(sb, "network", k3.a((aVar.f34705f - aVar.f34704e) - j2), false);
            long j5 = k3Var2.f34807h;
            if (j5 > 0) {
                k3.a(sb, "parsing", k3.a(j5 - k3Var2.f34802c.f34705f), false);
                if (k3Var2.f34803d) {
                    long j6 = k3Var2.f34808i;
                    if (j6 > 0) {
                        k3.a(sb, "beforeLoad", k3.a(j6 - k3Var2.f34807h), false);
                        if (k3Var2.f34805f) {
                            sb.append("preLoadingSkipped");
                            sb.append('=');
                            sb.append(1);
                            sb.append(", ");
                            j3 = k3Var2.f34808i;
                        } else {
                            long j7 = k3Var2.f34809j;
                            if (j7 > 0) {
                                k3.a(sb, "init", k3.a(j7 - k3Var2.f34808i), false);
                                k3.a(sb, "loading", k3.a(k3Var2.f34810k - k3Var2.f34809j), false);
                                boolean z4 = k3Var2.f34812m;
                                sb.append("pageFinished");
                                sb.append('=');
                                sb.append(z4 ? 1 : 0);
                                sb.append(", ");
                                j3 = k3Var2.f34810k;
                            } else {
                                sb.append(MRAIDPresenter.ERROR);
                                sb.append('=');
                                sb.append((long) k3Var2.f34811l);
                                sb.append(", ");
                                j3 = k3Var2.f34808i;
                            }
                        }
                    }
                }
                j3 = k3Var2.f34807h;
            } else {
                j3 = k3Var2.f34802c.f34705f;
            }
            k3.a(sb, "total", k3.a(j3 - k3Var2.f34802c.f34704e), false);
            Map<String, List<String>> map2 = k3Var2.f34802c.f34702c;
            if (!(map2 == null || a2 == null)) {
                sb.append("headers");
                sb.append("={");
                for (Map.Entry next : map2.entrySet()) {
                    if (a2.contains(next.getKey()) && next.getValue() != null) {
                        sb.append((String) next.getKey());
                        sb.append("=[");
                        for (String a3 : (List) next.getValue()) {
                            k3.a(sb, (String) null, a3, true);
                        }
                        k3.a(sb);
                        sb.append(']');
                        sb.append(", ");
                    }
                }
                k3.a(sb);
                sb.append("}");
                sb.append(", ");
            }
            k3.a(sb);
            String sb3 = sb.toString();
            y8 y8Var = new y8(z8.f36995b);
            y8Var.f36954d = "ADM";
            y8Var.f36959i = str;
            y8Var.f36955e = sb3;
            y8Var.a(this.f34714a);
        }
    }
}

package com.utils.Getlink.Resolver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.crypto.AES256Cryptor;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.kotlin.KotlinHelper;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class RabitStream extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    private boolean f37527e = false;

    /* renamed from: f  reason: collision with root package name */
    List<RabitConfig> f37528f = new ArrayList();

    class RabitConfig {

        /* renamed from: a  reason: collision with root package name */
        public String f37530a;

        /* renamed from: b  reason: collision with root package name */
        public String f37531b;

        /* renamed from: c  reason: collision with root package name */
        public String f37532c;

        /* renamed from: d  reason: collision with root package name */
        public String f37533d;

        /* renamed from: e  reason: collision with root package name */
        public String f37534e;

        /* renamed from: f  reason: collision with root package name */
        public String f37535f;

        /* renamed from: g  reason: collision with root package name */
        public String f37536g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37537h;
    }

    private void n() {
        if (!this.f37527e) {
            this.f37527e = true;
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(Constants.E + Deobfuscator$app$ProductionRelease.a(-183085579317444L), new Map[0]);
            if (!m2.isEmpty()) {
                this.f37528f = (List) new Gson().m(m2, new TypeToken<ArrayList<RabitConfig>>() {
                }.d());
            }
        }
    }

    public String c() {
        return Deobfuscator$app$ProductionRelease.a(-184623177609412L);
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        n();
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, Deobfuscator$app$ProductionRelease.a(-184593112838340L), 2, 2);
        if (!b2.isEmpty()) {
            if (mediaSource.getPlayHeader() == null || !mediaSource.getPlayHeader().containsKey(Deobfuscator$app$ProductionRelease.a(-182561593307332L))) {
                str = streamLink;
            } else {
                str = mediaSource.getPlayHeader().get(Deobfuscator$app$ProductionRelease.a(-182527233568964L));
            }
            String j2 = BaseProvider.j(streamLink);
            try {
                j2 = new URL(streamLink).getHost();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            String a2 = Regex.a(j2, Deobfuscator$app$ProductionRelease.a(-182767751737540L), 1);
            if (a2.isEmpty()) {
                a2 = Regex.a(j2, Deobfuscator$app$ProductionRelease.a(-182759161802948L), 1);
            }
            String str2 = a2.substring(0, 1).toUpperCase() + a2.substring(1);
            if (!this.f37528f.isEmpty()) {
                for (RabitConfig next : this.f37528f) {
                    if (!next.f37531b.isEmpty()) {
                        if (next.f37531b.contains(Deobfuscator$app$ProductionRelease.a(-182724802064580L))) {
                            next.f37534e = HttpHelper.i().m(next.f37531b, new Map[0]);
                        } else {
                            next.f37534e = next.f37531b;
                        }
                    }
                    Deobfuscator$app$ProductionRelease.a(-182668967489732L);
                    String str3 = next.f37533d + Deobfuscator$app$ProductionRelease.a(-182664672522436L) + next.f37532c + b2;
                    String str4 = next.f37535f;
                    if (str4 != null && !str4.isEmpty()) {
                        str3 = str3 + next.f37535f;
                    }
                    HashMap<String, String> c2 = Constants.c();
                    String str5 = next.f37536g;
                    if (str5 == null || str5.isEmpty()) {
                        c2.put(Deobfuscator$app$ProductionRelease.a(-182690442326212L), streamLink);
                    } else {
                        c2.put(Deobfuscator$app$ProductionRelease.a(-183480716308676L), next.f37536g + Deobfuscator$app$ProductionRelease.a(-183446356570308L));
                    }
                    ArrayList arrayList = new ArrayList();
                    String replace = HttpHelper.i().m(str3, c2).replace(Deobfuscator$app$ProductionRelease.a(-183437766635716L), Deobfuscator$app$ProductionRelease.a(-183390521995460L));
                    arrayList.add(replace);
                    String a3 = Regex.a(replace, Deobfuscator$app$ProductionRelease.a(-183381932060868L), 1);
                    if (next.f37537h && !a3.isEmpty()) {
                        if (next.f37530a.equals(Deobfuscator$app$ProductionRelease.a(-183540845850820L))) {
                            try {
                                String str6 = KotlinHelper.f37692a.f(next.f37531b, Regex.a(next.f37535f, Deobfuscator$app$ProductionRelease.a(-183497896177860L), 1)).toString();
                                next.f37534e = str6;
                                String c3 = AES256Cryptor.c(a3, str6);
                                if (c3 != null) {
                                    arrayList.add(c3);
                                    if (JsUnpacker.m30920(replace)) {
                                        arrayList.addAll(JsUnpacker.m30916(replace));
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (next.f37530a.equals(Deobfuscator$app$ProductionRelease.a(-183188658532548L))) {
                            String m2 = HttpHelper.i().m(next.f37531b + DateTimeHelper.e(), new Map[0]);
                            String obj = KotlinHelper.f37692a.g(m2).toString();
                            next.f37534e = obj;
                            if (!obj.isEmpty()) {
                                String o2 = o(a3, next.f37534e);
                                if (o2 != null) {
                                    arrayList.add(o2);
                                    if (JsUnpacker.m30920(m2)) {
                                        arrayList.addAll(JsUnpacker.m30916(m2));
                                    }
                                }
                            }
                        }
                    }
                    Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
                    HashMap hashMap = new HashMap();
                    hashMap.put(Deobfuscator$app$ProductionRelease.a(-183180068597956L), str);
                    hashMap.put(Deobfuscator$app$ProductionRelease.a(-183145708859588L), Constants.C);
                    while (it2.hasNext()) {
                        ResolveResult next2 = it2.next();
                        if (next2.getResolvedQuality() != null && next2.getResolvedQuality().trim().toLowerCase().equals(Deobfuscator$app$ProductionRelease.a(-183132823957700L))) {
                            next2.setResolvedQuality(mediaSource.getQuality());
                        }
                        next2.setResolverName(str2);
                        next2.setPlayHeader(hashMap);
                        observableEmitter.onNext(BaseResolver.a(mediaSource, next2));
                    }
                    MediaSource mediaSource2 = mediaSource;
                    ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                }
            }
        }
    }

    public String o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            int i2 = 0;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                int i4 = jSONArray2.getInt(0) + i2;
                int i5 = jSONArray2.getInt(1) + i4;
                while (i4 < i5) {
                    sb.append(charArray[i4]);
                    charArray[i4] = ' ';
                    i4++;
                }
                i2 += jSONArray2.getInt(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return AES256Cryptor.c(new String(charArray).replaceAll(Deobfuscator$app$ProductionRelease.a(-183283147813060L), Deobfuscator$app$ProductionRelease.a(-183257378009284L)), sb.toString());
    }
}

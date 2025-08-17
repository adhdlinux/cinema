package com.utils.Getlink.Provider;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.sstream.SSModel;
import com.movie.data.model.sstream.sourceUrls;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import com.squareup.duktape.Duktape;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Smashystream extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public static String f37451e = Deobfuscator$app$ProductionRelease.a(-231429731201220L);

    /* renamed from: f  reason: collision with root package name */
    public static String f37452f = Deobfuscator$app$ProductionRelease.a(-231425436233924L);

    private String J(String str) {
        if (f37451e.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            f37451e = i2.m(Constants.E + Deobfuscator$app$ProductionRelease.a(-232232890085572L), new Map[0]);
        }
        String replace = f37451e.replace(Deobfuscator$app$ProductionRelease.a(-232164170608836L), str);
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate(replace);
            if (evaluate != null && !evaluate.toString().isEmpty()) {
                String obj = evaluate.toString();
                Logger.b(A(), obj);
                String a2 = Regex.a(Utils.b(obj), Deobfuscator$app$ProductionRelease.a(-232932969754820L), 1);
                if (!a2.isEmpty()) {
                    obj = a2;
                }
                create.close();
                return obj;
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
        create.close();
        return Deobfuscator$app$ProductionRelease.a(-232859955310788L);
    }

    private void K(String str, String str2, ObservableEmitter<? super MediaSource> observableEmitter, String str3) {
        ArrayList<ArrayList<String>> e2 = Regex.e(str, Deobfuscator$app$ProductionRelease.a(-234096905892036L), 2, 32);
        if (e2.size() != 2 || e2.get(0).isEmpty()) {
            String replace = str.replace(Deobfuscator$app$ProductionRelease.a(-232460523352260L), Deobfuscator$app$ProductionRelease.a(-232451933417668L));
            String e3 = Utils.e(replace);
            MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-232447638450372L), false);
            HashMap<String, String> hashMap = new HashMap<>();
            if (!e3.isEmpty()) {
                String replace2 = replace.replace(e3, Deobfuscator$app$ProductionRelease.a(-232108336033988L));
                replace = replace2.substring(0, replace2.length() - 1);
                String a2 = Regex.a(Utils.b(replace), Deobfuscator$app$ProductionRelease.a(-232104041066692L), 1);
                if (!a2.isEmpty()) {
                    if (!a2.startsWith(Deobfuscator$app$ProductionRelease.a(-232031026622660L))) {
                        a2 = BaseProvider.d(a2);
                    }
                    replace = a2;
                }
                hashMap = Utils.f(e3);
                if (!hashMap.isEmpty()) {
                    mediaSource.setPlayHeader(hashMap);
                }
            }
            if (hashMap.isEmpty()) {
                hashMap.put(Deobfuscator$app$ProductionRelease.a(-232250069954756L), BaseProvider.j(str2));
            }
            mediaSource.setStreamLink(replace);
            mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-232220005183684L));
            mediaSource.setPlayHeader(hashMap);
            observableEmitter.onNext(mediaSource);
            return;
        }
        ArrayList arrayList = e2.get(0);
        ArrayList arrayList2 = e2.get(1);
        int i2 = 0;
        while (i2 < arrayList.size() && i2 < arrayList2.size()) {
            String str4 = (String) arrayList.get(i2);
            String replace3 = ((String) arrayList2.get(i2)).replace(Deobfuscator$app$ProductionRelease.a(-233830617919684L), Deobfuscator$app$ProductionRelease.a(-233822027985092L));
            String a3 = Regex.a(Utils.b(replace3), Deobfuscator$app$ProductionRelease.a(-233852092756164L), 1);
            if (!a3.isEmpty()) {
                if (!a3.startsWith(Deobfuscator$app$ProductionRelease.a(-232370329039044L))) {
                    replace3 = BaseProvider.d(a3);
                } else {
                    replace3 = a3;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(Deobfuscator$app$ProductionRelease.a(-232314494464196L), str2);
            hashMap2.put(Deobfuscator$app$ProductionRelease.a(-232280134725828L), BaseProvider.j(str2));
            MediaSource mediaSource2 = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-232524947861700L), false);
            mediaSource2.setStreamLink(replace3);
            mediaSource2.setQuality(str4);
            mediaSource2.setPlayHeader(hashMap2);
            observableEmitter.onNext(mediaSource2);
            i2++;
        }
    }

    private void L(ArrayList arrayList, String str, ObservableEmitter<? super MediaSource> observableEmitter, String str2) {
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof String) {
                String obj = next.toString();
                if (!obj.contains(Deobfuscator$app$ProductionRelease.a(-232890020081860L))) {
                    obj = J(obj);
                }
                if (obj.endsWith(Deobfuscator$app$ProductionRelease.a(-232834185507012L))) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                if (!obj.isEmpty()) {
                    K(obj, str, observableEmitter, str2);
                }
            } else {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) next;
                String obj2 = linkedTreeMap.get(Deobfuscator$app$ProductionRelease.a(-232825595572420L)).toString();
                MediaSource mediaSource = new MediaSource(A(), linkedTreeMap.get(Deobfuscator$app$ProductionRelease.a(-233078998642884L)).toString(), false);
                HashMap<String, String> hashMap = new HashMap<>();
                if (!obj2.isEmpty()) {
                    if (!obj2.contains(Deobfuscator$app$ProductionRelease.a(-233087588577476L))) {
                        obj2 = J(obj2);
                        String e2 = Utils.e(obj2);
                        if (!e2.isEmpty()) {
                            String replace = obj2.replace(e2, Deobfuscator$app$ProductionRelease.a(-233031754002628L));
                            obj2 = replace.substring(0, replace.length() - 1);
                            hashMap = Utils.f(e2);
                            if (!hashMap.isEmpty()) {
                                mediaSource.setPlayHeader(hashMap);
                            }
                        }
                    }
                    if (obj2.endsWith(Deobfuscator$app$ProductionRelease.a(-233061818773700L))) {
                        obj2 = obj2.substring(0, obj2.length() - 1);
                    }
                    if (hashMap.isEmpty()) {
                        hashMap.put(Deobfuscator$app$ProductionRelease.a(-233053228839108L), str);
                        hashMap.put(Deobfuscator$app$ProductionRelease.a(-233018869100740L), BaseProvider.j(str));
                    }
                    mediaSource.setStreamLink(obj2.replace(Deobfuscator$app$ProductionRelease.a(-232988804329668L), Deobfuscator$app$ProductionRelease.a(-232980214395076L)));
                    mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-232666681782468L));
                    mediaSource.setPlayHeader(hashMap);
                    observableEmitter.onNext(mediaSource);
                }
            }
        }
    }

    private void M(ArrayList arrayList, String str, ObservableEmitter<? super MediaSource> observableEmitter, HashMap<String, String> hashMap) {
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof String) {
                String obj = next.toString();
                if (!obj.contains(Deobfuscator$app$ProductionRelease.a(-232679566684356L))) {
                    obj = J(obj);
                }
                if (!obj.isEmpty()) {
                    MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-232623732109508L), false);
                    mediaSource.setStreamLink(obj.replace(Deobfuscator$app$ProductionRelease.a(-232559307600068L), Deobfuscator$app$ProductionRelease.a(-232550717665476L)));
                    mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-232580782436548L));
                    mediaSource.setPlayHeader(hashMap);
                    observableEmitter.onNext(mediaSource);
                }
            } else {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) next;
                String obj2 = linkedTreeMap.get(Deobfuscator$app$ProductionRelease.a(-232799825768644L)).toString();
                String obj3 = linkedTreeMap.get(Deobfuscator$app$ProductionRelease.a(-232812710670532L)).toString();
                if (!obj2.isEmpty()) {
                    if (obj2.startsWith(Deobfuscator$app$ProductionRelease.a(-232786940866756L))) {
                        if (!obj2.contains(Deobfuscator$app$ProductionRelease.a(-232778350932164L))) {
                            obj2 = J(obj2);
                        }
                        if (obj2.endsWith(Deobfuscator$app$ProductionRelease.a(-232722516357316L))) {
                            obj2 = obj2.substring(0, obj2.length() - 1);
                        }
                    }
                    if (!obj2.contains(Deobfuscator$app$ProductionRelease.a(-232748286161092L))) {
                        String str2 = BaseProvider.j(str) + Deobfuscator$app$ProductionRelease.a(-232692451586244L) + obj2.replace(Deobfuscator$app$ProductionRelease.a(-231305177149636L), Deobfuscator$app$ProductionRelease.a(-231296587215044L));
                        if (!str2.endsWith(Deobfuscator$app$ProductionRelease.a(-231257932509380L))) {
                            str2 = str2 + Deobfuscator$app$ProductionRelease.a(-231270817411268L);
                        }
                        obj2 = HttpHelper.i().l(str2, Deobfuscator$app$ProductionRelease.a(-231214982836420L), hashMap).replace(Deobfuscator$app$ProductionRelease.a(-231210687869124L), Deobfuscator$app$ProductionRelease.a(-231232162705604L));
                    }
                    if (!obj2.isEmpty()) {
                        MediaSource mediaSource2 = new MediaSource(A(), obj3, false);
                        mediaSource2.setStreamLink(obj2.replace(Deobfuscator$app$ProductionRelease.a(-231189213032644L), Deobfuscator$app$ProductionRelease.a(-231180623098052L)));
                        mediaSource2.setQuality(Deobfuscator$app$ProductionRelease.a(-231176328130756L));
                        mediaSource2.setPlayHeader(hashMap);
                        observableEmitter.onNext(mediaSource2);
                    }
                }
            }
        }
    }

    private List<SSModel.Player> N(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-235127698043076L), Deobfuscator$app$ProductionRelease.a(-235097633272004L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-235282316865732L), Deobfuscator$app$ProductionRelease.a(-235247957127364L));
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (f37452f.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            f37452f = i2.m(Constants.E + Deobfuscator$app$ProductionRelease.a(-234844230201540L), new Map[0]);
        }
        if (f37452f.isEmpty()) {
            f37452f = BaseProvider.j(str) + Deobfuscator$app$ProductionRelease.a(-234766920790212L);
        }
        try {
            JSONArray jSONArray = new JSONObject(HttpHelper.i().m(String.format(f37452f, new Object[]{str2}), new Map[0])).getJSONArray(Deobfuscator$app$ProductionRelease.a(-234930129547460L));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                SSModel.Player player = new SSModel.Player();
                player.status = SSModel.ServerStatus.UNKNOW;
                player.url = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-234887179874500L));
                player.name = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-234904359743684L));
                player.status = SSModel.ServerStatus.SUCCESS;
                arrayList.add(player);
            }
        } catch (Exception unused) {
        }
        if (arrayList.isEmpty()) {
            HttpHelper i4 = HttpHelper.i();
            try {
                JSONArray jSONArray2 = new JSONObject(i4.m(Deobfuscator$app$ProductionRelease.a(-233508495372484L) + str2, new Map[0])).getJSONArray(Deobfuscator$app$ProductionRelease.a(-233602984652996L));
                for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                    SSModel.Player player2 = new SSModel.Player();
                    player2.status = SSModel.ServerStatus.UNKNOW;
                    player2.url = jSONObject2.getString(Deobfuscator$app$ProductionRelease.a(-233547150078148L));
                    player2.name = jSONObject2.getString(Deobfuscator$app$ProductionRelease.a(-233564329947332L));
                    player2.status = SSModel.ServerStatus.SUCCESS;
                    arrayList.add(player2);
                }
            } catch (Exception unused2) {
            }
        }
        if (arrayList.isEmpty()) {
            Iterator it2 = Jsoup.b(m2).q0(Deobfuscator$app$ProductionRelease.a(-233542855110852L)).iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (element.p(Deobfuscator$app$ProductionRelease.a(-233134833217732L))) {
                    SSModel.Player player3 = new SSModel.Player();
                    player3.status = SSModel.ServerStatus.UNKNOW;
                    player3.url = element.c(Deobfuscator$app$ProductionRelease.a(-233130538250436L));
                    player3.name = element.v0();
                    Elements d02 = element.d0(Deobfuscator$app$ProductionRelease.a(-233366761451716L));
                    if (d02.size() > 0) {
                        String lowerCase = d02.toString().toLowerCase();
                        if (lowerCase.contains(Deobfuscator$app$ProductionRelease.a(-233310926876868L))) {
                            player3.status = SSModel.ServerStatus.SUCCESS;
                        } else if (lowerCase.contains(Deobfuscator$app$ProductionRelease.a(-233289452040388L))) {
                            player3.status = SSModel.ServerStatus.WARNING;
                        }
                    }
                    arrayList.add(player3);
                } else if (element.p(Deobfuscator$app$ProductionRelease.a(-234058251186372L))) {
                    SSModel.Player player4 = new SSModel.Player();
                    player4.status = SSModel.ServerStatus.UNKNOW;
                    player4.url = element.c(Deobfuscator$app$ProductionRelease.a(-234023891448004L));
                    player4.name = element.v0();
                    Elements d03 = element.d0(Deobfuscator$app$ProductionRelease.a(-233989531709636L));
                    if (d03.size() > 0) {
                        String lowerCase2 = d03.toString().toLowerCase();
                        if (lowerCase2.contains(Deobfuscator$app$ProductionRelease.a(-233933697134788L))) {
                            player4.status = SSModel.ServerStatus.SUCCESS;
                        } else if (lowerCase2.contains(Deobfuscator$app$ProductionRelease.a(-234187100205252L))) {
                            player4.status = SSModel.ServerStatus.WARNING;
                        }
                    }
                    arrayList.add(player4);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<SSModel.Player>() {
            /* renamed from: a */
            public int compare(SSModel.Player player, SSModel.Player player2) {
                if (player.status.ordinal() > player2.status.ordinal()) {
                    return 1;
                }
                if (player.status.ordinal() < player2.status.ordinal()) {
                    return -1;
                }
                return 0;
            }
        });
        return arrayList;
    }

    private void O(String str, ObservableEmitter<? super MediaSource> observableEmitter, String str2) {
        for (SSModel.Player next : N(str, str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-240522176966852L), Deobfuscator$app$ProductionRelease.a(-240762695135428L));
            String replace = HttpHelper.i().m(next.url, hashMap).replace(Deobfuscator$app$ProductionRelease.a(-240358968209604L), Deobfuscator$app$ProductionRelease.a(-240380443046084L));
            if (replace.contains(Deobfuscator$app$ProductionRelease.a(-240371853111492L))) {
                String a2 = Deobfuscator$app$ProductionRelease.a(-240251594027204L);
                replace = HttpHelper.i().l(a2, Deobfuscator$app$ProductionRelease.a(-238993168609476L) + Utils.d(12) + Deobfuscator$app$ProductionRelease.a(-235647389085892L), hashMap);
                if (replace.contains(Deobfuscator$app$ProductionRelease.a(-235827777712324L))) {
                    Logger.a(Deobfuscator$app$ProductionRelease.a(-235784828039364L));
                    replace = HttpHelper.i().m(next.url, hashMap).replace(Deobfuscator$app$ProductionRelease.a(-235754763268292L), Deobfuscator$app$ProductionRelease.a(-235776238104772L));
                }
            }
            String a3 = Regex.a(replace, Deobfuscator$app$ProductionRelease.a(-235767648170180L), 1);
            Logger.a(a3);
            try {
                SSModel.Playerjs playerjs = (SSModel.Playerjs) new Gson().l(a3, SSModel.Playerjs.class);
                if (playerjs != null) {
                    Object obj = playerjs.file;
                    if (obj instanceof ArrayList) {
                        L((ArrayList) obj, next.url, observableEmitter, next.name);
                    } else if (obj instanceof String) {
                        K(obj.toString(), next.url, observableEmitter, next.name);
                    }
                } else {
                    sourceUrls sourceurls = (sourceUrls) new Gson().l(replace, sourceUrls.class);
                    if (!sourceurls.getSourceUrls().isEmpty()) {
                        L((ArrayList) sourceurls.getSourceUrls(), next.url, observableEmitter, next.name);
                    }
                }
            } catch (Exception unused) {
                if (!a3.isEmpty()) {
                    K(Regex.a(a3, Deobfuscator$app$ProductionRelease.a(-235398280982724L), 1), next.url, observableEmitter, next.name);
                } else {
                    String a4 = Regex.a(replace, Deobfuscator$app$ProductionRelease.a(-236051116011716L), 1);
                    if (!a4.isEmpty()) {
                        String replace2 = HttpHelper.i().m(a4, hashMap).replace(Deobfuscator$app$ProductionRelease.a(-234474863014084L), Deobfuscator$app$ProductionRelease.a(-234496337850564L));
                        String j2 = BaseProvider.j(a4);
                        String a5 = Regex.a(replace2, Deobfuscator$app$ProductionRelease.a(-234728266084548L), 1);
                        String a6 = Regex.a(replace2, Deobfuscator$app$ProductionRelease.a(-234315949224132L), 1);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-234217164976324L), a6);
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-234436208308420L), j2);
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-234371783798980L), a4);
                        if (!a5.isEmpty()) {
                            if (a5.startsWith(Deobfuscator$app$ProductionRelease.a(-234337424060612L))) {
                                a5 = j2 + a5;
                            }
                            String replace3 = HttpHelper.i().l(a5, Deobfuscator$app$ProductionRelease.a(-234363193864388L), hashMap2).replace(Deobfuscator$app$ProductionRelease.a(-234358898897092L), Deobfuscator$app$ProductionRelease.a(-235136287977668L));
                            ArrayList arrayList = (ArrayList) new Gson().l(replace3, ArrayList.class);
                            if (arrayList == null || arrayList.isEmpty()) {
                                K(replace3, j2, observableEmitter, next.name);
                            } else {
                                M(arrayList, j2, observableEmitter, hashMap2);
                            }
                        }
                    }
                }
            }
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-240556536705220L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        O(Deobfuscator$app$ProductionRelease.a(-239993895989444L) + movieInfo.tmdbID, observableEmitter, String.valueOf(movieInfo.tmdbID));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        String str = movieInfo.tmdbID + Deobfuscator$app$ProductionRelease.a(-239783442591940L) + movieInfo.session + Deobfuscator$app$ProductionRelease.a(-239710428147908L) + movieInfo.eps;
        O(Deobfuscator$app$ProductionRelease.a(-239942356381892L) + str, observableEmitter, str);
    }
}

package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.startapp.common.parser.TypeParser;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.json.JSONObject;

public class RcdTargets implements Serializable {
    private static final long serialVersionUID = 6963217195144137950L;
    @j0
    private final SortedMap<String, Pair<Integer, String>> nameToScopesIds;
    @j0
    private final SortedMap<Integer, SortedMap<String, String>> scopeToNamesIds;

    @Keep
    public static class Parser implements TypeParser<RcdTargets> {
        private static void add(String str, String str2, int i2, SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
            if (str2.length() >= 1) {
                String replaceAll = str2.replaceAll("~", ".");
                sortedMap.put(replaceAll, new Pair(Integer.valueOf(i2), str));
                for (int i3 = 0; i3 < 16; i3++) {
                    int i4 = 1 << i3;
                    if ((i2 & i4) == i4) {
                        Map map = sortedMap2.get(Integer.valueOf(i4));
                        if (map == null) {
                            map = new TreeMap();
                            sortedMap2.put(Integer.valueOf(i4), map);
                        }
                        map.put(replaceAll, str);
                    }
                }
            }
        }

        public static void parseRec(String str, String str2, JSONObject jSONObject, SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("~")) {
                        add(str, str2, jSONObject.optInt(next), sortedMap, sortedMap2);
                    } else if (next.endsWith("~") && (jSONObject.opt(next) instanceof JSONObject)) {
                        parseRec(str, str2 + next, jSONObject.optJSONObject(next), sortedMap, sortedMap2);
                    } else if (next.length() > 0) {
                        add(str, str2 + next, jSONObject.optInt(next), sortedMap, sortedMap2);
                    }
                }
            }
        }

        public RcdTargets parse(Class<RcdTargets> cls, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                parseRec(next, "", jSONObject.optJSONObject(next), treeMap, treeMap2);
            }
            return new RcdTargets(treeMap, treeMap2);
        }
    }

    public RcdTargets(SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
        this.nameToScopesIds = sortedMap;
        this.scopeToNamesIds = sortedMap2;
    }

    public Collection<String> a(int i2) {
        SortedMap sortedMap = this.scopeToNamesIds.get(Integer.valueOf(i2));
        return sortedMap != null ? Collections.unmodifiableCollection(sortedMap.keySet()) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RcdTargets.class != obj.getClass()) {
            return false;
        }
        RcdTargets rcdTargets = (RcdTargets) obj;
        if (!lb.a(this.nameToScopesIds, rcdTargets.nameToScopesIds) || !lb.a(this.scopeToNamesIds, rcdTargets.scopeToNamesIds)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.nameToScopesIds, this.scopeToNamesIds};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public String a(Map<String, Integer> map) {
        Pair pair;
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Integer num = (Integer) next.getValue();
            if (!(str == null || num == null || (pair = this.nameToScopesIds.get(str)) == null)) {
                String str2 = (String) pair.second;
                Integer num2 = (Integer) treeMap.get(str2);
                if (num2 == null) {
                    num2 = 0;
                }
                treeMap.put(str2, Integer.valueOf(num.intValue() | num2.intValue()));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append(':');
            sb.append((String) entry.getKey());
            sb.append(':');
            int intValue = ((Integer) entry.getValue()).intValue();
            int i2 = 1;
            boolean z2 = (57344 & intValue) != 0;
            boolean z3 = (intValue & 7680) != 0;
            if (z2 && z3) {
                i2 = 6;
            } else if (z2) {
                i2 = 5;
            } else if (z3) {
                i2 = 4;
            } else if ((intValue & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
                i2 = 3;
            } else if ((intValue & 172) != 0) {
                i2 = 2;
            } else if ((intValue & 83) == 0) {
                i2 = 0;
            }
            sb.append(i2);
        }
        if (sb.length() > 0) {
            sb.append(':');
        }
        return sb.toString();
    }
}

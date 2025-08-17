package com.startapp;

import com.startapp.common.parser.TypeParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class jb<T> implements TypeParser<List<T>> {
    private static final String LOG_TAG = "jb";
    private final Class<T> itemClass;

    public class a implements sa<Integer, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f34766a;

        public a(jb jbVar, Object obj) {
            this.f34766a = obj;
        }

        public Object a(Object obj) {
            try {
                return ((JSONArray) this.f34766a).getJSONObject(((Integer) obj).intValue());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class b implements sa<Integer, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f34767a;

        public b(jb jbVar, Object obj) {
            this.f34767a = obj;
        }

        public Object a(Object obj) {
            try {
                return ((JSONObject) this.f34767a).getJSONObject(((Integer) obj).toString());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public jb(Class<T> cls) {
        this.itemClass = cls;
    }

    public List<T> parse(Class<List<T>> cls, Object obj) {
        int i2;
        sa saVar;
        if (obj instanceof JSONArray) {
            i2 = ((JSONArray) obj).length();
            saVar = new a(this, obj);
        } else if (!(obj instanceof JSONObject)) {
            return null;
        } else {
            i2 = ((JSONObject) obj).length();
            saVar = new b(this, obj);
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                arrayList.add(g0.a(this.itemClass, (JSONObject) saVar.a(Integer.valueOf(i3))));
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}

package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzezn;
import com.google.android.gms.internal.ads.zzfos;
import com.google.android.gms.internal.ads.zzfpu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbx {
    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzj = zzj(view);
        return new Point(((int) motionEvent.getRawX()) - zzj[0], ((int) motionEvent.getRawY()) - zzj[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzba.zzc().zzb(zzbbm.zzhD)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("x", zzay.zzb().zzb(context, point2.x));
                    jSONObject3.put("y", zzay.zzb().zzb(context, point2.y));
                    jSONObject3.put("start_x", zzay.zzb().zzb(context, point.x));
                    jSONObject3.put("start_y", zzay.zzb().zzb(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e2) {
                    zzbzr.zzh("Error occurred while putting signals into JSON object.", e2);
                }
                jSONObject2.put("click_point", jSONObject);
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e3) {
                e = e3;
                jSONObject = jSONObject2;
                zzbzr.zzh("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e4) {
            e = e4;
            zzbzr.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static JSONObject zzd(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        String str;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Context context2 = context;
        Map map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject3 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject3;
        }
        int[] zzj = zzj(view);
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] zzj2 = zzj(view2);
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                Iterator it3 = it2;
                try {
                    JSONObject jSONObject6 = jSONObject3;
                    try {
                        jSONObject5.put("width", zzay.zzb().zzb(context2, view2.getMeasuredWidth()));
                        jSONObject5.put("height", zzay.zzb().zzb(context2, view2.getMeasuredHeight()));
                        jSONObject5.put("x", zzay.zzb().zzb(context2, zzj2[0] - zzj[0]));
                        jSONObject5.put("y", zzay.zzb().zzb(context2, zzj2[1] - zzj[1]));
                        jSONObject5.put(str4, str3);
                        jSONObject4.put("frame", jSONObject5);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject2 = zzk(context2, rect);
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("width", 0);
                            jSONObject2.put("height", 0);
                            jSONObject2.put("x", zzay.zzb().zzb(context2, zzj2[0] - zzj[0]));
                            jSONObject2.put("y", zzay.zzb().zzb(context2, zzj2[1] - zzj[1]));
                            jSONObject2.put(str4, str3);
                        }
                        jSONObject4.put("visible_bounds", jSONObject2);
                        if (((String) entry.getKey()).equals("3010")) {
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhx)).booleanValue()) {
                                jSONObject4.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                            }
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhy)).booleanValue()) {
                                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                jSONObject4.put("view_width_layout_type", zzl(layoutParams.width) - 1);
                                jSONObject4.put("view_height_layout_type", zzl(layoutParams.height) - 1);
                            }
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhz)).booleanValue()) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf(view2.getId()));
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    arrayList.add(Integer.valueOf(((View) parent).getId()));
                                }
                                jSONObject4.put("view_path", TextUtils.join("/", arrayList));
                            }
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhA)).booleanValue() && scaleType != null) {
                                jSONObject4.put("mediaview_scale_type", scaleType.ordinal());
                            }
                        }
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject4.put("text_color", textView.getCurrentTextColor());
                            str2 = str3;
                            str = str4;
                            try {
                                jSONObject4.put("font_size", (double) textView.getTextSize());
                                jSONObject4.put("text", textView.getText());
                            } catch (JSONException unused) {
                                jSONObject = jSONObject6;
                                zzbzr.zzj("Unable to get asset views information");
                                it2 = it3;
                                jSONObject3 = jSONObject;
                                str3 = str2;
                                str4 = str;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                        }
                        jSONObject4.put("is_clickable", map3 != null && map3.containsKey(entry.getKey()) && view2.isClickable());
                        jSONObject = jSONObject6;
                        try {
                            jSONObject.put((String) entry.getKey(), jSONObject4);
                        } catch (JSONException unused2) {
                        }
                    } catch (JSONException unused3) {
                        str2 = str3;
                        str = str4;
                        jSONObject = jSONObject6;
                        zzbzr.zzj("Unable to get asset views information");
                        it2 = it3;
                        jSONObject3 = jSONObject;
                        str3 = str2;
                        str4 = str;
                    }
                } catch (JSONException unused4) {
                    str2 = str3;
                    str = str4;
                    jSONObject = jSONObject3;
                    zzbzr.zzj("Unable to get asset views information");
                    it2 = it3;
                    jSONObject3 = jSONObject;
                    str3 = str2;
                    str4 = str;
                }
                it2 = it3;
                jSONObject3 = jSONObject;
                str3 = str2;
                str4 = str;
            }
        }
        return jSONObject3;
    }

    public static JSONObject zze(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzt.zzp();
            jSONObject.put("can_show_on_lock_screen", zzs.zzl(view));
            zzt.zzp();
            jSONObject.put("is_keyguard_locked", zzs.zzz(context));
        } catch (JSONException unused) {
            zzbzr.zzj("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zzf(View view) {
        int i2;
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            boolean z2 = false;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhw)).booleanValue()) {
                zzt.zzp();
                ViewParent parent = view.getParent();
                while (parent != null && !(parent instanceof ScrollView)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    z2 = true;
                }
                jSONObject.put("contained_in_scroll_view", z2);
            } else {
                zzt.zzp();
                ViewParent parent2 = view.getParent();
                while (parent2 != null && !(parent2 instanceof AdapterView)) {
                    parent2 = parent2.getParent();
                }
                if (parent2 == null) {
                    i2 = -1;
                } else {
                    i2 = ((AdapterView) parent2).getPositionForView(view);
                }
                if (i2 != -1) {
                    z2 = true;
                }
                jSONObject.put("contained_in_scroll_view", z2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0170 A[Catch:{ JSONException -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzg(android.content.Context r16, android.view.View r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "window"
            java.lang.String r3 = "relative_to"
            java.lang.String r4 = "y"
            java.lang.String r5 = "x"
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r1 != 0) goto L_0x0018
            return r8
        L_0x0018:
            r9 = 2
            r10 = 1
            r11 = 0
            int[] r12 = zzj(r17)     // Catch:{ Exception -> 0x00fd }
            int[] r13 = new int[r9]     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r14     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r14     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r17.getParent()     // Catch:{ Exception -> 0x00fd }
        L_0x0031:
            boolean r15 = r14 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x00fd }
            if (r15 == 0) goto L_0x0058
            r15 = r14
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r10 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r9     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r15 = r13[r10]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r15)     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r9     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00fd }
            r9 = 2
            r10 = 1
            goto L_0x0031
        L_0x0058:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r7, r10)     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x00fd }
            r10 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r5, r10)     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r14 = r12[r10]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r10 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r10.zzb(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put(r4, r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_width"
            r14 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r15 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r14 = r15.zzb(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put(r10, r14)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_height"
            r14 = 1
            r13 = r13[r14]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r13 = r14.zzb(r0, r13)     // Catch:{ Exception -> 0x00fd }
            r9.put(r10, r13)     // Catch:{ Exception -> 0x00fd }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "frame"
            r8.put(r10, r9)     // Catch:{ Exception -> 0x00fd }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            boolean r10 = r1.getGlobalVisibleRect(r9)     // Catch:{ Exception -> 0x00fd }
            if (r10 == 0) goto L_0x00cd
            org.json.JSONObject r0 = zzk(r0, r9)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00f7
        L_0x00cd:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            r9.put(r7, r11)     // Catch:{ Exception -> 0x00fd }
            r9.put(r6, r11)     // Catch:{ Exception -> 0x00fd }
            r6 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r7 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r6 = r7.zzb(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put(r5, r6)     // Catch:{ Exception -> 0x00fd }
            r5 = 1
            r6 = r12[r5]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbzk r5 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fd }
            int r0 = r5.zzb(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put(r4, r0)     // Catch:{ Exception -> 0x00fd }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fd }
            r0 = r9
        L_0x00f7:
            java.lang.String r2 = "visible_bounds"
            r8.put(r2, r0)     // Catch:{ Exception -> 0x00fd }
            goto L_0x0102
        L_0x00fd:
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzbzr.zzj(r0)
        L_0x0102:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzfY
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = -1
            if (r0 == 0) goto L_0x017b
            android.view.ViewParent r0 = r17.getParent()
            if (r0 == 0) goto L_0x013a
            java.lang.Class r3 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            java.lang.String r4 = "getTemplateTypeName"
            java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            java.lang.Object[] r4 = new java.lang.Object[r11]     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            java.lang.Object r0 = r3.invoke(r0, r4)     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x013a, SecurityException -> 0x0134, IllegalAccessException -> 0x0132, InvocationTargetException -> 0x0130 }
            goto L_0x013c
        L_0x0130:
            r0 = move-exception
            goto L_0x0135
        L_0x0132:
            r0 = move-exception
            goto L_0x0135
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            java.lang.String r3 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzbzr.zzh(r3, r0)
        L_0x013a:
            java.lang.String r0 = ""
        L_0x013c:
            int r3 = r0.hashCode()     // Catch:{ JSONException -> 0x0175 }
            r4 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r3 == r4) goto L_0x0155
            r4 = 2019754500(0x78630204, float:1.8417067E34)
            if (r3 == r4) goto L_0x014b
            goto L_0x015f
        L_0x014b:
            java.lang.String r3 = "medium_template"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x015f
            r0 = 1
            goto L_0x0160
        L_0x0155:
            java.lang.String r3 = "small_template"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x015f
            r0 = 0
            goto L_0x0160
        L_0x015f:
            r0 = -1
        L_0x0160:
            java.lang.String r3 = "native_template_type"
            if (r0 == 0) goto L_0x0170
            r4 = 1
            if (r0 == r4) goto L_0x016b
            r8.put(r3, r11)     // Catch:{ JSONException -> 0x0175 }
            goto L_0x017b
        L_0x016b:
            r4 = 2
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0175 }
            goto L_0x017b
        L_0x0170:
            r4 = 1
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0175 }
            goto L_0x017b
        L_0x0175:
            r0 = move-exception
            java.lang.String r3 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzbzr.zzh(r3, r0)
        L_0x017b:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzhy
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01af
            android.view.ViewGroup$LayoutParams r0 = r17.getLayoutParams()     // Catch:{ Exception -> 0x01aa }
            java.lang.String r1 = "view_width_layout_type"
            int r3 = r0.width     // Catch:{ Exception -> 0x01aa }
            int r3 = zzl(r3)     // Catch:{ Exception -> 0x01aa }
            int r3 = r3 + r2
            r8.put(r1, r3)     // Catch:{ Exception -> 0x01aa }
            java.lang.String r1 = "view_height_layout_type"
            int r0 = r0.height     // Catch:{ Exception -> 0x01aa }
            int r0 = zzl(r0)     // Catch:{ Exception -> 0x01aa }
            int r0 = r0 + r2
            r8.put(r1, r0)     // Catch:{ Exception -> 0x01aa }
            goto L_0x01af
        L_0x01aa:
            java.lang.String r0 = "Unable to get native ad view layout types"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
        L_0x01af:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbx.zzg(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean zzh(Context context, zzezn zzezn) {
        if (!zzezn.zzO) {
            return false;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhB)).booleanValue()) {
            return ((Boolean) zzba.zzc().zzb(zzbbm.zzhE)).booleanValue();
        }
        String str = (String) zzba.zzc().zzb(zzbbm.zzhC);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            for (String equals : zzfpu.zzc(zzfos.zzc(';')).zzd(str)) {
                if (equals.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzi(int i2) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzde)).booleanValue()) {
            return true;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdf)).booleanValue() || i2 <= 15299999) {
            return true;
        }
        return false;
    }

    public static int[] zzj(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzay.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzay.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzay.zzb().zzb(context, rect.left));
        jSONObject.put("y", zzay.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int zzl(int i2) {
        if (i2 != -2) {
            return i2 != -1 ? 2 : 3;
        }
        return 4;
    }
}

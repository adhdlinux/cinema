package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

public final class zzccz implements zzbij {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i2) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                zzay.zzb();
                i2 = zzbzk.zzx(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                zzbzr.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (zze.zzc()) {
            zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i2 + ".");
        }
        return i2;
    }

    private static void zzc(zzcbo zzcbo, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcbo.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbzr.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzcbo.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcbo.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcbo.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcbo.zzD(Integer.parseInt(str5));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x02d2 A[SYNTHETIC, Splitter:B:151:0x02d2] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r22, java.util.Map r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r2 = r22
            com.google.android.gms.internal.ads.zzcca r2 = (com.google.android.gms.internal.ads.zzcca) r2
            java.lang.String r3 = "action"
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0018
            java.lang.String r1 = "Action missing from video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0018:
            java.lang.String r4 = "playerId"
            boolean r5 = r1.containsKey(r4)
            if (r5 == 0) goto L_0x002f
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            com.google.android.gms.internal.ads.zzcbp r5 = r2.zzo()
            if (r5 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzcbp r5 = r2.zzo()
            java.lang.Integer r5 = r5.zzb()
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            java.lang.String r7 = "load"
            r8 = 1
            r9 = 0
            if (r4 == 0) goto L_0x0068
            if (r5 == 0) goto L_0x0068
            boolean r10 = r4.equals(r5)
            if (r10 != 0) goto L_0x0068
            boolean r10 = r3.equals(r7)
            if (r10 == 0) goto L_0x0055
            goto L_0x0068
        L_0x0055:
            java.util.Locale r1 = java.util.Locale.US
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r9] = r4
            r2[r8] = r5
            java.lang.String r3 = "Event intended for player %s, but sent to player %d - event ignored"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            com.google.android.gms.internal.ads.zzbzr.zzi(r1)
            return
        L_0x0068:
            r5 = 3
            boolean r5 = com.google.android.gms.internal.ads.zzbzr.zzm(r5)
            if (r5 == 0) goto L_0x0099
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r1)
            java.lang.String r10 = "google.afma.Notify_dt"
            r5.remove(r10)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Video GMSG: "
            r10.append(r11)
            r10.append(r3)
            java.lang.String r11 = " "
            r10.append(r11)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            com.google.android.gms.internal.ads.zzbzr.zze(r5)
        L_0x0099:
            java.lang.String r5 = "background"
            boolean r5 = r5.equals(r3)
            java.lang.String r10 = "color"
            if (r5 == 0) goto L_0x00c3
            java.lang.Object r1 = r1.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x00b5
            java.lang.String r1 = "Color parameter missing from background video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x00b5:
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ IllegalArgumentException -> 0x00bd }
            r2.setBackgroundColor(r1)     // Catch:{ IllegalArgumentException -> 0x00bd }
            return
        L_0x00bd:
            java.lang.String r1 = "Invalid color parameter in background video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x00c3:
            java.lang.String r5 = "playerBackground"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x00eb
            java.lang.Object r1 = r1.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x00dd
            java.lang.String r1 = "Color parameter missing from playerBackground video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x00dd:
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ IllegalArgumentException -> 0x00e5 }
            r2.zzB(r1)     // Catch:{ IllegalArgumentException -> 0x00e5 }
            return
        L_0x00e5:
            java.lang.String r1 = "Invalid color parameter in playerBackground video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x00eb:
            java.lang.String r5 = "decoderProps"
            boolean r10 = r5.equals(r3)
            java.lang.String r11 = "onVideoEvent"
            java.lang.String r12 = "event"
            if (r10 == 0) goto L_0x0146
            java.lang.String r3 = "mimeTypes"
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0119
            java.lang.String r1 = "No MIME types specified for decoder properties inspection."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.put(r12, r5)
            java.lang.String r3 = "error"
            java.lang.String r4 = "missingMimeTypes"
            r1.put(r3, r4)
            r2.zzd(r11, r1)
            return
        L_0x0119:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r6 = ","
            java.lang.String[] r1 = r1.split(r6)
            int r6 = r1.length
        L_0x0125:
            if (r9 >= r6) goto L_0x0137
            r7 = r1[r9]
            java.lang.String r8 = r7.trim()
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzch.zza(r8)
            r4.put(r7, r8)
            int r9 = r9 + 1
            goto L_0x0125
        L_0x0137:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.put(r12, r5)
            r1.put(r3, r4)
            r2.zzd(r11, r1)
            return
        L_0x0146:
            com.google.android.gms.internal.ads.zzcbp r5 = r2.zzo()
            if (r5 != 0) goto L_0x0152
            java.lang.String r1 = "Could not get underlay container for a video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0152:
            java.lang.String r10 = "new"
            boolean r10 = r10.equals(r3)
            java.lang.String r13 = "position"
            boolean r13 = r13.equals(r3)
            java.lang.String r14 = "y"
            java.lang.String r15 = "x"
            if (r10 != 0) goto L_0x036e
            if (r13 == 0) goto L_0x0168
            goto L_0x036e
        L_0x0168:
            com.google.android.gms.internal.ads.zzcfv r10 = r2.zzq()
            java.lang.String r13 = "currentTime"
            if (r10 == 0) goto L_0x01a5
            java.lang.String r6 = "timeupdate"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x0198
            java.lang.Object r1 = r1.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0186
            java.lang.String r1 = "currentTime parameter missing from timeupdate video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0186:
            float r2 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x018e }
            r10.zzt(r2)     // Catch:{ NumberFormatException -> 0x018e }
            return
        L_0x018e:
            java.lang.String r2 = "Could not parse currentTime parameter from timeupdate video GMSG: "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0198:
            java.lang.String r6 = "skip"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x01a1
            goto L_0x01a5
        L_0x01a1:
            r10.zzu()
            return
        L_0x01a5:
            com.google.android.gms.internal.ads.zzcbo r5 = r5.zza()
            if (r5 != 0) goto L_0x01b9
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "no_video_view"
            r1.put(r12, r3)
            r2.zzd(r11, r1)
            return
        L_0x01b9:
            java.lang.String r6 = "click"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x01e1
            android.content.Context r2 = r2.getContext()
            int r3 = zzb(r2, r1, r15, r9)
            int r1 = zzb(r2, r1, r14, r9)
            float r11 = (float) r3
            float r12 = (float) r1
            long r8 = android.os.SystemClock.uptimeMillis()
            r10 = 0
            r13 = 0
            r6 = r8
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r6, r8, r10, r11, r12, r13)
            r5.zzx(r1)
            r1.recycle()
            return
        L_0x01e1:
            boolean r6 = r13.equals(r3)
            if (r6 == 0) goto L_0x020e
            java.lang.String r2 = "time"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x01f7
            java.lang.String r1 = "Time parameter missing from currentTime video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x01f7:
            float r2 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0204 }
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r3
            int r2 = (int) r2     // Catch:{ NumberFormatException -> 0x0204 }
            r5.zzw(r2)     // Catch:{ NumberFormatException -> 0x0204 }
            return
        L_0x0204:
            java.lang.String r2 = "Could not parse time parameter from currentTime video GMSG: "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x020e:
            java.lang.String r6 = "hide"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x0233
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzG
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x022e
            r1 = 8
            r5.setVisibility(r1)
            return
        L_0x022e:
            r1 = 4
            r5.setVisibility(r1)
            return
        L_0x0233:
            boolean r6 = r7.equals(r3)
            if (r6 == 0) goto L_0x023d
            r5.zzr(r4)
            return
        L_0x023d:
            java.lang.String r4 = "loadControl"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0249
            zzc(r5, r1)
            return
        L_0x0249:
            java.lang.String r4 = "muted"
            boolean r6 = r4.equals(r3)
            if (r6 == 0) goto L_0x0265
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            if (r1 == 0) goto L_0x0261
            r5.zzs()
            return
        L_0x0261:
            r5.zzI()
            return
        L_0x0265:
            java.lang.String r4 = "pause"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0271
            r5.zzu()
            return
        L_0x0271:
            java.lang.String r4 = "play"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x027d
            r5.zzv()
            return
        L_0x027d:
            java.lang.String r4 = "show"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0289
            r5.setVisibility(r9)
            return
        L_0x0289:
            java.lang.String r4 = "src"
            boolean r6 = r4.equals(r3)
            if (r6 == 0) goto L_0x0309
            java.lang.Object r3 = r1.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "periodicReportIntervalMs"
            boolean r6 = r1.containsKey(r4)
            if (r6 != 0) goto L_0x02a1
        L_0x029f:
            r6 = 0
            goto L_0x02c4
        L_0x02a1:
            java.lang.Object r6 = r1.get(r4)     // Catch:{ NumberFormatException -> 0x02b0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x02b0 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x02b0 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x02b0 }
            goto L_0x02c4
        L_0x02b0:
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r6 = "Video gmsg invalid numeric parameter 'periodicReportIntervalMs': "
            java.lang.String r4 = r6.concat(r4)
            com.google.android.gms.internal.ads.zzbzr.zzj(r4)
            goto L_0x029f
        L_0x02c4:
            java.lang.String[] r4 = new java.lang.String[r8]
            r4[r9] = r3
            java.lang.String r7 = "demuxed"
            java.lang.Object r1 = r1.get(r7)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x02fc
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x02ef }
            r4.<init>(r1)     // Catch:{ JSONException -> 0x02ef }
            int r7 = r4.length()     // Catch:{ JSONException -> 0x02ef }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ JSONException -> 0x02ef }
            r10 = 0
        L_0x02de:
            int r11 = r4.length()     // Catch:{ JSONException -> 0x02ef }
            if (r10 >= r11) goto L_0x02ed
            java.lang.String r11 = r4.getString(r10)     // Catch:{ JSONException -> 0x02ef }
            r7[r10] = r11     // Catch:{ JSONException -> 0x02ef }
            int r10 = r10 + 1
            goto L_0x02de
        L_0x02ed:
            r4 = r7
            goto L_0x02fc
        L_0x02ef:
            java.lang.String r4 = "Malformed demuxed URL list for playback: "
            java.lang.String r1 = r4.concat(r1)
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            java.lang.String[] r4 = new java.lang.String[r8]
            r4[r9] = r3
        L_0x02fc:
            if (r6 == 0) goto L_0x0305
            int r1 = r6.intValue()
            r2.zzA(r1)
        L_0x0305:
            r5.zzE(r3, r4)
            return
        L_0x0309:
            java.lang.String r4 = "touchMove"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0330
            android.content.Context r3 = r2.getContext()
            java.lang.String r4 = "dx"
            int r4 = zzb(r3, r1, r4, r9)
            java.lang.String r6 = "dy"
            int r1 = zzb(r3, r1, r6, r9)
            float r3 = (float) r4
            float r1 = (float) r1
            r5.zzH(r3, r1)
            boolean r1 = r0.zza
            if (r1 != 0) goto L_0x0486
            r2.zzu()
            r0.zza = r8
            return
        L_0x0330:
            java.lang.String r2 = "volume"
            boolean r4 = r2.equals(r3)
            if (r4 == 0) goto L_0x0358
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0346
            java.lang.String r1 = "Level parameter missing from volume video GMSG."
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0346:
            float r2 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x034e }
            r5.zzG(r2)     // Catch:{ NumberFormatException -> 0x034e }
            return
        L_0x034e:
            java.lang.String r2 = "Could not parse volume parameter from volume video GMSG: "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x0358:
            java.lang.String r1 = "watermark"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0364
            r5.zzn()
            return
        L_0x0364:
            java.lang.String r1 = "Unknown video action: "
            java.lang.String r1 = r1.concat(r3)
            com.google.android.gms.internal.ads.zzbzr.zzj(r1)
            return
        L_0x036e:
            android.content.Context r3 = r2.getContext()
            int r4 = zzb(r3, r1, r15, r9)
            int r15 = zzb(r3, r1, r14, r9)
            java.lang.String r6 = "w"
            r7 = -1
            int r6 = zzb(r3, r1, r6, r7)
            com.google.android.gms.internal.ads.zzbbe r8 = com.google.android.gms.internal.ads.zzbbm.zzdB
            com.google.android.gms.internal.ads.zzbbk r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r11 = r11.zzb(r8)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            java.lang.String r12 = "."
            if (r11 == 0) goto L_0x03a5
            if (r6 != r7) goto L_0x039c
            int r6 = r2.zzh()
            goto L_0x03df
        L_0x039c:
            int r11 = r2.zzh()
            int r6 = java.lang.Math.min(r6, r11)
            goto L_0x03df
        L_0x03a5:
            boolean r11 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r11 == 0) goto L_0x03d6
            int r11 = r2.zzh()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Calculate width with original width "
            r13.append(r14)
            r13.append(r6)
            java.lang.String r14 = ", videoHost.getVideoBoundingWidth() "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = ", x "
            r13.append(r11)
            r13.append(r4)
            r13.append(r12)
            java.lang.String r11 = r13.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r11)
        L_0x03d6:
            int r11 = r2.zzh()
            int r11 = r11 - r4
            int r6 = java.lang.Math.min(r6, r11)
        L_0x03df:
            java.lang.String r11 = "h"
            int r3 = zzb(r3, r1, r11, r7)
            com.google.android.gms.internal.ads.zzbbk r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r8 = r11.zzb(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0405
            if (r3 != r7) goto L_0x03fc
            int r2 = r2.zzg()
            goto L_0x043f
        L_0x03fc:
            int r2 = r2.zzg()
            int r2 = java.lang.Math.min(r3, r2)
            goto L_0x043f
        L_0x0405:
            boolean r7 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r7 == 0) goto L_0x0436
            int r7 = r2.zzg()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "Calculate height with original height "
            r8.append(r11)
            r8.append(r3)
            java.lang.String r11 = ", videoHost.getVideoBoundingHeight() "
            r8.append(r11)
            r8.append(r7)
            java.lang.String r7 = ", y "
            r8.append(r7)
            r8.append(r15)
            r8.append(r12)
            java.lang.String r7 = r8.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r7)
        L_0x0436:
            int r2 = r2.zzg()
            int r2 = r2 - r15
            int r2 = java.lang.Math.min(r3, r2)
        L_0x043f:
            java.lang.String r3 = "player"
            java.lang.Object r3 = r1.get(r3)     // Catch:{ NumberFormatException -> 0x044e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x044e }
            int r9 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x044e }
            r18 = r9
            goto L_0x0451
        L_0x044e:
            r18 = 0
        L_0x0451:
            java.lang.String r3 = "spherical"
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r19 = java.lang.Boolean.parseBoolean(r3)
            if (r10 == 0) goto L_0x0487
            com.google.android.gms.internal.ads.zzcbo r3 = r5.zza()
            if (r3 != 0) goto L_0x0487
            com.google.android.gms.internal.ads.zzcbz r3 = new com.google.android.gms.internal.ads.zzcbz
            java.lang.String r7 = "flags"
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            r3.<init>(r7)
            r13 = r5
            r14 = r4
            r16 = r6
            r17 = r2
            r20 = r3
            r13.zzd(r14, r15, r16, r17, r18, r19, r20)
            com.google.android.gms.internal.ads.zzcbo r2 = r5.zza()
            if (r2 == 0) goto L_0x0486
            zzc(r2, r1)
        L_0x0486:
            return
        L_0x0487:
            r5.zzc(r4, r15, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccz.zza(java.lang.Object, java.util.Map):void");
    }
}

package com.utils.subtitle.subtitleView;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.exoplayer2.Player;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CaptionsView extends AppCompatTextView implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static String f37767f;

    /* renamed from: b  reason: collision with root package name */
    private Player f37768b;

    /* renamed from: c  reason: collision with root package name */
    private TreeMap<Long, Line> f37769c;

    /* renamed from: d  reason: collision with root package name */
    private CMime f37770d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f37771e = null;

    public enum CMime {
        SUBRIP,
        WEBVTT
    }

    public interface CaptionsViewLoadListener {
    }

    private enum TrackParseState {
        NEW_TRACK,
        PARSED_CUE,
        PARSED_TIME
    }

    public CaptionsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private static void e(TreeMap<Long, Line> treeMap, Line line) {
        treeMap.put(Long.valueOf(line.f37775a), line);
    }

    private String f(String str) {
        try {
            return str.substring(str.lastIndexOf(".") + 1);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d A[SYNTHETIC, Splitter:B:37:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00af A[SYNTHETIC, Splitter:B:59:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bd A[SYNTHETIC, Splitter:B:65:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cd A[SYNTHETIC, Splitter:B:72:0x00cd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.TreeMap<java.lang.Long, com.utils.subtitle.subtitleView.CaptionsView.Line> g(java.util.List<java.io.File> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "UTF-8"
            java.util.Iterator r7 = r7.iterator()
            boolean r1 = r7.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0031
            java.lang.Object r7 = r7.next()
            java.io.File r7 = (java.io.File) r7
            java.lang.String r1 = r7.getName()
            java.lang.String r1 = r6.f(r1)
            com.utils.subtitle.subtitleView.CaptionsView$CMime r3 = r6.f37770d
            com.utils.subtitle.subtitleView.CaptionsView$CMime r4 = com.utils.subtitle.subtitleView.CaptionsView.CMime.WEBVTT
            if (r3 != r4) goto L_0x002c
            java.lang.String r3 = "vtt"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002c
            r6.f37770d = r4
            goto L_0x0032
        L_0x002c:
            com.utils.subtitle.subtitleView.CaptionsView$CMime r1 = com.utils.subtitle.subtitleView.CaptionsView.CMime.SUBRIP
            r6.f37770d = r1
            goto L_0x0032
        L_0x0031:
            r7 = r2
        L_0x0032:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            com.utils.UnicodeBOMInputStream r3 = new com.utils.UnicodeBOMInputStream     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
            java.lang.String r4 = com.utils.Utils.K(r3)     // Catch:{ Exception -> 0x0066 }
            f37767f = r4     // Catch:{ Exception -> 0x0066 }
            if (r4 != 0) goto L_0x004e
            com.utils.UnicodeBOMInputStream$BOM r4 = r3.a()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0066 }
            f37767f = r4     // Catch:{ Exception -> 0x0066 }
        L_0x004e:
            java.lang.String r4 = f37767f     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = "NONE"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0066 }
            if (r4 == 0) goto L_0x005a
            f37767f = r0     // Catch:{ Exception -> 0x0066 }
        L_0x005a:
            r1.close()     // Catch:{ IOException -> 0x0061 }
            r3.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0083
        L_0x0061:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0083
        L_0x0066:
            r4 = move-exception
            goto L_0x0076
        L_0x0068:
            r7 = move-exception
            r3 = r2
        L_0x006a:
            r2 = r1
            goto L_0x00cb
        L_0x006d:
            r4 = move-exception
            r3 = r2
            goto L_0x0076
        L_0x0070:
            r7 = move-exception
            r3 = r2
            goto L_0x00cb
        L_0x0073:
            r4 = move-exception
            r1 = r2
            r3 = r1
        L_0x0076:
            f37767f = r0     // Catch:{ all -> 0x00c9 }
            r4.printStackTrace()     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x0083
            r1.close()     // Catch:{ IOException -> 0x0061 }
            r3.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0083:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a9 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x00a9 }
            com.utils.UnicodeBOMInputStream r1 = new com.utils.UnicodeBOMInputStream     // Catch:{ Exception -> 0x00a4, all -> 0x00a1 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00a4, all -> 0x00a1 }
            com.utils.subtitle.subtitleView.CaptionsView$CMime r3 = r6.f37770d     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            java.util.TreeMap r3 = j(r1, r3)     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            int r3 = r3.size()     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            r7.getAbsolutePath()     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            throw r2     // Catch:{ Exception -> 0x009e, all -> 0x009b }
        L_0x009b:
            r7 = move-exception
            r3 = r1
            goto L_0x00a2
        L_0x009e:
            r7 = move-exception
            r3 = r1
            goto L_0x00a5
        L_0x00a1:
            r7 = move-exception
        L_0x00a2:
            r1 = r0
            goto L_0x00bb
        L_0x00a4:
            r7 = move-exception
        L_0x00a5:
            r1 = r0
            goto L_0x00aa
        L_0x00a7:
            r7 = move-exception
            goto L_0x00bb
        L_0x00a9:
            r7 = move-exception
        L_0x00aa:
            r7.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x00ba
            r1.close()     // Catch:{ IOException -> 0x00b6 }
            r3.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ba:
            return r2
        L_0x00bb:
            if (r1 == 0) goto L_0x00c8
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            r3.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c8:
            throw r7
        L_0x00c9:
            r7 = move-exception
            goto L_0x006a
        L_0x00cb:
            if (r2 == 0) goto L_0x00d8
            r2.close()     // Catch:{ IOException -> 0x00d4 }
            r3.close()     // Catch:{ IOException -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.subtitleView.CaptionsView.g(java.util.List):java.util.TreeMap");
    }

    private String h(long j2) {
        String str = "";
        for (Map.Entry next : this.f37769c.entrySet()) {
            if (j2 < ((Long) next.getKey()).longValue()) {
                break;
            } else if (j2 < ((Line) next.getValue()).f37776b) {
                str = ((Line) next.getValue()).f37777c;
            }
        }
        return str;
    }

    private static boolean i(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (i2 == 0 && str.charAt(i2) == '-') {
                if (str.length() == 1) {
                    return false;
                }
            } else if (Character.digit(str.charAt(i2), 10) < 0) {
                return false;
            }
        }
        return true;
    }

    public static TreeMap<Long, Line> j(InputStream inputStream, CMime cMime) throws IOException {
        if (cMime == CMime.SUBRIP) {
            return l(inputStream);
        }
        if (cMime == CMime.WEBVTT) {
            return n(inputStream);
        }
        return l(inputStream);
    }

    private static long k(String str) {
        try {
            String[] split = str.split(":");
            String[] split2 = split[2].split(",");
            return (Long.parseLong(split[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(split[1].trim()) * 60 * 1000) + (Long.parseLong(split2[0].trim()) * 1000) + Long.parseLong(split2[1].trim());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static TreeMap<Long, Line> l(InputStream inputStream) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, f37767f));
        TreeMap<Long, Line> treeMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        TrackParseState trackParseState = TrackParseState.NEW_TRACK;
        Line line = null;
        int i2 = 0;
        while (true) {
            String readLine = lineNumberReader.readLine();
            if (readLine == null) {
                break;
            }
            System.out.println(readLine);
            i2++;
            TrackParseState trackParseState2 = TrackParseState.NEW_TRACK;
            if (trackParseState == trackParseState2) {
                if (!readLine.isEmpty()) {
                    if (i(readLine)) {
                        trackParseState = TrackParseState.PARSED_CUE;
                        if (line != null && sb.length() > 0) {
                            String sb2 = sb.toString();
                            line.a(sb2.substring(0, sb2.length() - 5));
                            e(treeMap, line);
                            sb.setLength(0);
                            line = null;
                        }
                    } else if (sb.length() > 0) {
                        sb.append(readLine);
                        sb.append("<br/>");
                    } else {
                        Log.w("SubtitleView", "No cue number found at line: " + i2);
                    }
                }
            }
            if (trackParseState == TrackParseState.PARSED_CUE) {
                String[] split = readLine.split("-->");
                if (split.length == 2) {
                    line = new Line(k(split[0]), k(split[1]));
                    trackParseState = TrackParseState.PARSED_TIME;
                } else {
                    Log.w("SubtitleView", "No time-code found at line: " + i2);
                }
            }
            if (trackParseState == TrackParseState.PARSED_TIME) {
                if (!readLine.isEmpty()) {
                    sb.append(readLine);
                    sb.append("<br/>");
                } else {
                    trackParseState = trackParseState2;
                }
            }
        }
        if (line != null && sb.length() > 0) {
            String sb3 = sb.toString();
            line.a(sb3.substring(0, sb3.length() - 5));
            e(treeMap, line);
        }
        return treeMap;
    }

    private static long m(String str) {
        boolean z2;
        long parseLong;
        long j2;
        String[] split = str.split(":");
        if (split.length == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String[] split2 = split[2].split("\\.");
            long parseLong2 = Long.parseLong(split[0].trim());
            long parseLong3 = Long.parseLong(split[1].trim());
            long parseLong4 = Long.parseLong(split2[0].trim());
            parseLong = Long.parseLong(split2[1].trim());
            j2 = (parseLong2 * 60 * 60 * 1000) + (parseLong3 * 60 * 1000) + (parseLong4 * 1000);
        } else {
            String[] split3 = split[1].split("\\.");
            long parseLong5 = Long.parseLong(split[0].trim());
            long parseLong6 = Long.parseLong(split3[0].trim());
            parseLong = Long.parseLong(split3[1].trim());
            j2 = (parseLong5 * 60 * 1000) + (parseLong6 * 1000);
        }
        return j2 + parseLong;
    }

    public static TreeMap<Long, Line> n(InputStream inputStream) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, "UTF-8"));
        TreeMap<Long, Line> treeMap = new TreeMap<>();
        lineNumberReader.readLine();
        lineNumberReader.readLine();
        while (true) {
            String readLine = lineNumberReader.readLine();
            if (readLine == null) {
                return treeMap;
            }
            String str = "";
            while (true) {
                String readLine2 = lineNumberReader.readLine();
                if (readLine2 == null || readLine2.trim().equals("")) {
                    String substring = str.substring(0, str.length() - 5);
                    String[] split = readLine.split(" --> ");
                } else {
                    str = str + readLine2 + "<br/>";
                }
            }
            String substring2 = str.substring(0, str.length() - 5);
            String[] split2 = readLine.split(" --> ");
            if (split2.length == 2) {
                long m2 = m(split2[0]);
                treeMap.put(Long.valueOf(m2), new Line(m2, m(split2[1]), substring2));
            }
        }
    }

    public TreeMap<Long, Line> getTrack() {
        return this.f37769c;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 300);
        setShadowLayer(6.0f, 6.0f, 6.0f, -16777216);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    public void run() {
        Player player = this.f37768b;
        if (!(player == null || this.f37769c == null)) {
            long K = player.K() / 1000;
            setText(Html.fromHtml("" + h(this.f37768b.getCurrentPosition())));
        }
        postDelayed(this, 50);
    }

    public void setActivity(Activity activity) {
        this.f37771e = activity;
    }

    public void setCaptionsSource(List<File> list) {
        this.f37769c = g(list);
    }

    public void setCaptionsViewLoadListener(CaptionsViewLoadListener captionsViewLoadListener) {
    }

    public void setPlayer(Player player) {
        this.f37768b = player;
    }

    public static class Line {

        /* renamed from: a  reason: collision with root package name */
        long f37775a;

        /* renamed from: b  reason: collision with root package name */
        long f37776b;

        /* renamed from: c  reason: collision with root package name */
        String f37777c;

        public Line(long j2, long j3, String str) {
            this.f37775a = j2;
            this.f37776b = j3;
            this.f37777c = str;
        }

        public void a(String str) {
            this.f37777c = str;
        }

        public Line(long j2, long j3) {
            this.f37775a = j2;
            this.f37776b = j3;
        }
    }
}

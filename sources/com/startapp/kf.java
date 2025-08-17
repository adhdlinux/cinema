package com.startapp;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public class kf implements nf {

    /* renamed from: a  reason: collision with root package name */
    public final mf f34847a;

    public kf(mf mfVar) {
        this.f34847a = mfVar;
    }

    public String a(String str) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes());
                jf.a(gZIPOutputStream2);
                String a2 = this.f34847a.a(gf.b(byteArrayOutputStream.toByteArray()));
                jf.a(gZIPOutputStream2);
                return a2;
            } catch (Exception unused) {
                gZIPOutputStream = gZIPOutputStream2;
                jf.a(gZIPOutputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                jf.a(gZIPOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
            jf.a(gZIPOutputStream);
            return "";
        } catch (Throwable th2) {
            th = th2;
            jf.a(gZIPOutputStream);
            throw th;
        }
    }
}

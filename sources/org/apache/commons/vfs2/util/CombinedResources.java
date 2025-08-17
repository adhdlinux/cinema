package org.apache.commons.vfs2.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class CombinedResources extends ResourceBundle {

    /* renamed from: a  reason: collision with root package name */
    private final String f41470a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41471b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Properties f41472c = new Properties();

    public CombinedResources(String str) {
        this.f41470a = str;
    }

    public String b() {
        return this.f41470a;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!this.f41471b) {
            d(b());
            e(Locale.getDefault());
            e(getLocale());
            this.f41471b = true;
        }
    }

    /* access modifiers changed from: protected */
    public void d(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            Enumeration<URL> resources = classLoader.getResources(str.replace('.', '/') + ".properties");
            while (resources.hasMoreElements()) {
                try {
                    this.f41472c.load(resources.nextElement().openConnection().getInputStream());
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
        }
    }

    /* access modifiers changed from: protected */
    public void e(Locale locale) {
        if (locale != null) {
            String[] strArr = {locale.getLanguage(), locale.getCountry(), locale.getVariant()};
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 3; i2++) {
                sb.append(b());
                for (int i3 = 0; i3 < i2; i3++) {
                    sb.append('_');
                    sb.append(strArr[i3]);
                }
                if (strArr[i2].length() != 0) {
                    sb.append('_');
                    sb.append(strArr[i2]);
                    d(sb.toString());
                }
                sb.setLength(0);
            }
        }
    }

    public Enumeration<String> getKeys() {
        if (!this.f41471b) {
            c();
        }
        return new Enumeration<String>() {
            /* renamed from: a */
            public String nextElement() {
                return (String) CombinedResources.this.f41472c.keys().nextElement();
            }

            public boolean hasMoreElements() {
                return CombinedResources.this.f41472c.keys().hasMoreElements();
            }
        };
    }

    /* access modifiers changed from: protected */
    public Object handleGetObject(String str) {
        if (!this.f41471b) {
            c();
        }
        return this.f41472c.get(str);
    }
}

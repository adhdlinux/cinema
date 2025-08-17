package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f684e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f685f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f686a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f687b;

    /* renamed from: c  reason: collision with root package name */
    Context f688c;

    /* renamed from: d  reason: collision with root package name */
    private Object f689d;

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: d  reason: collision with root package name */
        private static final Class<?>[] f690d = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f691b;

        /* renamed from: c  reason: collision with root package name */
        private Method f692c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f691b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f692c = cls.getMethod(str, f690d);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f692c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f692c.invoke(this.f691b, new Object[]{menuItem})).booleanValue();
                }
                this.f692c.invoke(this.f691b, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class MenuState {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f693a;

        /* renamed from: b  reason: collision with root package name */
        private int f694b;

        /* renamed from: c  reason: collision with root package name */
        private int f695c;

        /* renamed from: d  reason: collision with root package name */
        private int f696d;

        /* renamed from: e  reason: collision with root package name */
        private int f697e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f698f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f699g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f700h;

        /* renamed from: i  reason: collision with root package name */
        private int f701i;

        /* renamed from: j  reason: collision with root package name */
        private int f702j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f703k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f704l;

        /* renamed from: m  reason: collision with root package name */
        private int f705m;

        /* renamed from: n  reason: collision with root package name */
        private char f706n;

        /* renamed from: o  reason: collision with root package name */
        private int f707o;

        /* renamed from: p  reason: collision with root package name */
        private char f708p;

        /* renamed from: q  reason: collision with root package name */
        private int f709q;

        /* renamed from: r  reason: collision with root package name */
        private int f710r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f711s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f712t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f713u;

        /* renamed from: v  reason: collision with root package name */
        private int f714v;

        /* renamed from: w  reason: collision with root package name */
        private int f715w;

        /* renamed from: x  reason: collision with root package name */
        private String f716x;

        /* renamed from: y  reason: collision with root package name */
        private String f717y;

        /* renamed from: z  reason: collision with root package name */
        private String f718z;

        public MenuState(Menu menu) {
            this.f693a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f688c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2;
            MenuItem enabled = menuItem.setChecked(this.f711s).setVisible(this.f712t).setEnabled(this.f713u);
            boolean z3 = false;
            if (this.f710r >= 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            enabled.setCheckable(z2).setTitleCondensed(this.f704l).setIcon(this.f705m);
            int i2 = this.f714v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.f718z != null) {
                if (!SupportMenuInflater.this.f688c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.f718z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f710r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).h(true);
                }
            }
            String str = this.f716x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.f684e, SupportMenuInflater.this.f686a));
                z3 = true;
            }
            int i3 = this.f715w;
            if (i3 > 0) {
                if (!z3) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.b(menuItem, actionProvider);
            }
            MenuItemCompat.d(menuItem, this.B);
            MenuItemCompat.i(menuItem, this.C);
            MenuItemCompat.c(menuItem, this.f706n, this.f707o);
            MenuItemCompat.g(menuItem, this.f708p, this.f709q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.f(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.e(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f700h = true;
            i(this.f693a.add(this.f694b, this.f701i, this.f702j, this.f703k));
        }

        public SubMenu b() {
            this.f700h = true;
            SubMenu addSubMenu = this.f693a.addSubMenu(this.f694b, this.f701i, this.f702j, this.f703k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f700h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f688c.obtainStyledAttributes(attributeSet, R$styleable.y1);
            this.f694b = obtainStyledAttributes.getResourceId(R$styleable.A1, 0);
            this.f695c = obtainStyledAttributes.getInt(R$styleable.C1, 0);
            this.f696d = obtainStyledAttributes.getInt(R$styleable.D1, 0);
            this.f697e = obtainStyledAttributes.getInt(R$styleable.E1, 0);
            this.f698f = obtainStyledAttributes.getBoolean(R$styleable.B1, true);
            this.f699g = obtainStyledAttributes.getBoolean(R$styleable.z1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z2;
            TintTypedArray u2 = TintTypedArray.u(SupportMenuInflater.this.f688c, attributeSet, R$styleable.F1);
            this.f701i = u2.n(R$styleable.I1, 0);
            this.f702j = (u2.k(R$styleable.L1, this.f695c) & -65536) | (u2.k(R$styleable.M1, this.f696d) & 65535);
            this.f703k = u2.p(R$styleable.N1);
            this.f704l = u2.p(R$styleable.O1);
            this.f705m = u2.n(R$styleable.G1, 0);
            this.f706n = c(u2.o(R$styleable.P1));
            this.f707o = u2.k(R$styleable.W1, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            this.f708p = c(u2.o(R$styleable.Q1));
            this.f709q = u2.k(R$styleable.a2, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            int i2 = R$styleable.R1;
            if (u2.s(i2)) {
                this.f710r = u2.a(i2, false) ? 1 : 0;
            } else {
                this.f710r = this.f697e;
            }
            this.f711s = u2.a(R$styleable.J1, false);
            this.f712t = u2.a(R$styleable.K1, this.f698f);
            this.f713u = u2.a(R$styleable.H1, this.f699g);
            this.f714v = u2.k(R$styleable.b2, -1);
            this.f718z = u2.o(R$styleable.S1);
            this.f715w = u2.n(R$styleable.T1, 0);
            this.f716x = u2.o(R$styleable.V1);
            String o2 = u2.o(R$styleable.U1);
            this.f717y = o2;
            if (o2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && this.f715w == 0 && this.f716x == null) {
                this.A = (ActionProvider) e(o2, SupportMenuInflater.f685f, SupportMenuInflater.this.f687b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u2.p(R$styleable.X1);
            this.C = u2.p(R$styleable.c2);
            int i3 = R$styleable.Z1;
            if (u2.s(i3)) {
                this.E = DrawableUtils.e(u2.k(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = R$styleable.Y1;
            if (u2.s(i4)) {
                this.D = u2.c(i4);
            } else {
                this.D = null;
            }
            u2.w();
            this.f700h = false;
        }

        public void h() {
            this.f694b = 0;
            this.f695c = 0;
            this.f696d = 0;
            this.f697e = 0;
            this.f698f = true;
            this.f699g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f684e = r0
            f685f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.<clinit>():void");
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f688c = context;
        Object[] objArr = {context};
        this.f686a = objArr;
        this.f687b = objArr;
    }

    private Object a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z3 && name2.equals(str)) {
                            str = null;
                            z3 = false;
                        } else if (name2.equals("group")) {
                            menuState.h();
                        } else if (name2.equals("item")) {
                            if (!menuState.d()) {
                                ActionProvider actionProvider = menuState.A;
                                if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                    menuState.a();
                                } else {
                                    menuState.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z2 = true;
                        }
                    }
                } else if (!z3) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        menuState.f(attributeSet);
                    } else if (name3.equals("item")) {
                        menuState.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, menuState.b());
                    } else {
                        str = name3;
                        z3 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f689d == null) {
            this.f689d = a(this.f688c);
        }
        return this.f689d;
    }

    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f688c.getResources().getLayout(i2);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}

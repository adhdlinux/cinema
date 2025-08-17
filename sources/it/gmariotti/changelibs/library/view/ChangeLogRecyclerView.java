package it.gmariotti.changelibs.library.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import it.gmariotti.changelibs.R$string;
import it.gmariotti.changelibs.R$styleable;
import it.gmariotti.changelibs.library.Constants;
import it.gmariotti.changelibs.library.Util;
import it.gmariotti.changelibs.library.internal.ChangeLog;
import it.gmariotti.changelibs.library.internal.ChangeLogRecyclerViewAdapter;
import it.gmariotti.changelibs.library.parser.XmlParser;

public class ChangeLogRecyclerView extends RecyclerView {

    /* renamed from: n  reason: collision with root package name */
    protected static String f40229n = "ChangeLogRecyclerView";

    /* renamed from: i  reason: collision with root package name */
    protected int f40230i;

    /* renamed from: j  reason: collision with root package name */
    protected int f40231j;

    /* renamed from: k  reason: collision with root package name */
    protected int f40232k;

    /* renamed from: l  reason: collision with root package name */
    protected String f40233l;

    /* renamed from: m  reason: collision with root package name */
    protected ChangeLogRecyclerViewAdapter f40234m;

    protected class ParseAsyncTask extends AsyncTask<Void, Void, ChangeLog> {

        /* renamed from: a  reason: collision with root package name */
        private ChangeLogRecyclerViewAdapter f40235a;

        /* renamed from: b  reason: collision with root package name */
        private XmlParser f40236b;

        public ParseAsyncTask(ChangeLogRecyclerViewAdapter changeLogRecyclerViewAdapter, XmlParser xmlParser) {
            this.f40235a = changeLogRecyclerViewAdapter;
            this.f40236b = xmlParser;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ChangeLog doInBackground(Void... voidArr) {
            try {
                XmlParser xmlParser = this.f40236b;
                if (xmlParser != null) {
                    return xmlParser.a();
                }
                return null;
            } catch (Exception e2) {
                Log.e(ChangeLogRecyclerView.f40229n, ChangeLogRecyclerView.this.getResources().getString(R$string.changelog_internal_error_parsing), e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(ChangeLog changeLog) {
            if (changeLog != null) {
                this.f40235a.c(changeLog.b());
            }
        }
    }

    public ChangeLogRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void b(AttributeSet attributeSet, int i2) {
        d(attributeSet, i2);
        c();
        e();
    }

    /* access modifiers changed from: protected */
    public void c() {
        XmlParser xmlParser;
        try {
            if (this.f40233l != null) {
                xmlParser = new XmlParser(getContext(), this.f40233l);
            } else {
                xmlParser = new XmlParser(getContext(), this.f40232k);
            }
            ChangeLogRecyclerViewAdapter changeLogRecyclerViewAdapter = new ChangeLogRecyclerViewAdapter(getContext(), new ChangeLog().b());
            this.f40234m = changeLogRecyclerViewAdapter;
            changeLogRecyclerViewAdapter.i(this.f40230i);
            this.f40234m.h(this.f40231j);
            String str = this.f40233l;
            if (str != null) {
                if (str == null || !Util.a(getContext())) {
                    Toast.makeText(getContext(), R$string.changelog_internal_error_internet_connection, 1).show();
                    setAdapter(this.f40234m);
                }
            }
            new ParseAsyncTask(this.f40234m, xmlParser).execute(new Void[0]);
            setAdapter(this.f40234m);
        } catch (Exception e2) {
            Log.e(f40229n, getResources().getString(R$string.changelog_internal_error_parsing), e2);
        }
    }

    /* access modifiers changed from: protected */
    public void d(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.f40177a, i2, i2);
        try {
            this.f40230i = obtainStyledAttributes.getResourceId(R$styleable.f40181e, this.f40230i);
            this.f40231j = obtainStyledAttributes.getResourceId(R$styleable.f40180d, this.f40231j);
            this.f40232k = obtainStyledAttributes.getResourceId(R$styleable.f40178b, this.f40232k);
            this.f40233l = obtainStyledAttributes.getString(R$styleable.f40179c);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
    }

    public ChangeLogRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f40230i = Constants.f40184b;
        this.f40231j = Constants.f40185c;
        this.f40232k = Constants.f40183a;
        this.f40233l = null;
        b(attributeSet, i2);
    }
}

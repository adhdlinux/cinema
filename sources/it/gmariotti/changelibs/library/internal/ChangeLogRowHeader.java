package it.gmariotti.changelibs.library.internal;

public class ChangeLogRowHeader extends ChangeLogRow {
    public ChangeLogRowHeader() {
        j(true);
        f(false);
        i((String) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("header=" + this.f40206a);
        sb.append(",");
        sb.append("versionName=" + this.f40207b);
        sb.append(",");
        sb.append("changeDate=" + this.f40209d);
        return sb.toString();
    }
}

package com.startapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.imageutils.JfifUtil;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class c5 {
    public static View a(Context context, SplashConfig splashConfig) {
        int i2;
        int i3;
        int i4;
        int i5;
        Context context2 = context;
        RelativeLayout relativeLayout = new RelativeLayout(context2);
        relativeLayout.setId(1475346437);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(context2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams);
        Point point = new Point(Math.round(TypedValue.applyDimension(1, (float) 150, context.getResources().getDisplayMetrics())), Math.round(TypedValue.applyDimension(1, (float) 28, context.getResources().getDisplayMetrics())));
        if (splashConfig.getOrientation() == SplashConfig.Orientation.PORTRAIT) {
            i5 = Math.round(TypedValue.applyDimension(1, (float) 5, context.getResources().getDisplayMetrics()));
            i4 = Math.round(TypedValue.applyDimension(1, (float) 8, context.getResources().getDisplayMetrics()));
            i3 = Math.round(TypedValue.applyDimension(1, (float) 75, context.getResources().getDisplayMetrics()));
            i2 = Math.round(TypedValue.applyDimension(1, (float) Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, context.getResources().getDisplayMetrics()));
        } else {
            i5 = Math.round(TypedValue.applyDimension(1, (float) 5, context.getResources().getDisplayMetrics()));
            i4 = Math.round(TypedValue.applyDimension(1, (float) 8, context.getResources().getDisplayMetrics()));
            i3 = Math.round(TypedValue.applyDimension(1, (float) 40, context.getResources().getDisplayMetrics()));
            i2 = Math.round(TypedValue.applyDimension(1, (float) 100, context.getResources().getDisplayMetrics()));
        }
        ImageView imageView = new ImageView(context2);
        imageView.setImageDrawable(splashConfig.getLogo());
        imageView.setId(101);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, 0, 0, i5);
        relativeLayout2.addView(imageView, layoutParams2);
        TextView textView = new TextView(context2);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(splashConfig.getAppName());
        textView.setId(100);
        textView.setTextSize(1, 26.0f);
        textView.setTextColor(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 101);
        layoutParams3.setMargins(0, 0, 0, i3);
        relativeLayout2.addView(textView, layoutParams3);
        try {
            WebView b2 = ComponentLocator.a(context).u().b();
            b2.setId(102);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(point.x, point.y);
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, 100);
            layoutParams4.setMargins(0, 0, 0, i4);
            b2.setBackgroundColor(Color.argb(0, 0, 0, 0));
            b2.setVerticalScrollBarEnabled(false);
            b2.setHorizontalScrollBarEnabled(false);
            b2.loadDataWithBaseURL((String) null, "<html>\n<style>\n#fountainG{\nposition:relative;\nwidth:141px;\nheight:17px}\n.fountainG{\nposition:absolute;\ntop:0;\nbackground-color:#000000;\nwidth:18px;\nheight:18px;\n-moz-animation-name:bounce_fountainG;\n-moz-animation-duration:2s;\n-moz-animation-iteration-count:infinite;\n-moz-animation-direction:linear;\n-moz-transform:scale(.3);\n-moz-border-radius:12px;\n-webkit-animation-name:bounce_fountainG;\n-webkit-animation-duration:2s;\n-webkit-animation-iteration-count:infinite;\n-webkit-animation-direction:linear;\n-webkit-transform:scale(.3);\n-webkit-border-radius:12px;\n-ms-animation-name:bounce_fountainG;\n-ms-animation-duration:2s;\n-ms-animation-iteration-count:infinite;\n-ms-animation-direction:linear;\n-ms-transform:scale(.3);\n-ms-border-radius:12px;\n-o-animation-name:bounce_fountainG;\n-o-animation-duration:2s;\n-o-animation-iteration-count:infinite;\n-o-animation-direction:linear;\n-o-transform:scale(.3);\n-o-border-radius:12px;\nanimation-name:bounce_fountainG;\nanimation-duration:2s;\nanimation-iteration-count:infinite;\nanimation-direction:linear;\ntransform:scale(.3);\nborder-radius:12px;\n}\n#fountainG_1{\nleft:0;\n-moz-animation-delay:0.8s;\n-webkit-animation-delay:0.8s;\n-ms-animation-delay:0.8s;\n-o-animation-delay:0.8s;\nanimation-delay:0.8s;\n}\n#fountainG_2{\nleft:18px;\n-moz-animation-delay:1s;\n-webkit-animation-delay:1s;\n-ms-animation-delay:1s;\n-o-animation-delay:1s;\nanimation-delay:1s;\n}\n#fountainG_3{\nleft:35px;\n-moz-animation-delay:1.2s;\n-webkit-animation-delay:1.2s;\n-ms-animation-delay:1.2s;\n-o-animation-delay:1.2s;\nanimation-delay:1.2s;\n}\n#fountainG_4{\nleft:53px;\n-moz-animation-delay:1.4s;\n-webkit-animation-delay:1.4s;\n-ms-animation-delay:1.4s;\n-o-animation-delay:1.4s;\nanimation-delay:1.4s;\n}\n#fountainG_5{\nleft:71px;\n-moz-animation-delay:1.6s;\n-webkit-animation-delay:1.6s;\n-ms-animation-delay:1.6s;\n-o-animation-delay:1.6s;\nanimation-delay:1.6s;\n}\n#fountainG_6{\nleft:88px;\n-moz-animation-delay:1.8s;\n-webkit-animation-delay:1.8s;\n-ms-animation-delay:1.8s;\n-o-animation-delay:1.8s;\nanimation-delay:1.8s;\n}\n#fountainG_7{\nleft:106px;\n-moz-animation-delay:2s;\n-webkit-animation-delay:2s;\n-ms-animation-delay:2s;\n-o-animation-delay:2s;\nanimation-delay:2s;\n}\n#fountainG_8{\nleft:123px;\n-moz-animation-delay:2.2s;\n-webkit-animation-delay:2.2s;\n-ms-animation-delay:2.2s;\n-o-animation-delay:2.2s;\nanimation-delay:2.2s;\n}\n@-moz-keyframes bounce_fountainG{\n0%{\n-moz-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-moz-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-webkit-keyframes bounce_fountainG{\n0%{\n-webkit-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-webkit-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-ms-keyframes bounce_fountainG{\n0%{\n-ms-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-ms-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-o-keyframes bounce_fountainG{\n0%{\n-o-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-o-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@keyframes bounce_fountainG{\n0%{\ntransform:scale(1);\nbackground-color:#000000;\n}\n100%{\ntransform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n</style>\n<body style=\"margin:0;padding:0\">\n<div id=\"fountainG\">\n<div id=\"fountainG_1\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_2\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_3\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_4\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_5\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_6\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_7\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_8\" class=\"fountainG\">\n</div>\n</div>\n</body>\n</html>", AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
            relativeLayout2.addView(b2, layoutParams4);
        } catch (Throwable th) {
            y8.a(context2, th);
        }
        TextView textView2 = new TextView(context2);
        textView2.setText("Loading...");
        textView2.setId(105);
        textView2.setTextSize(1, 18.0f);
        textView2.setTextColor(Color.rgb(208, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, 102);
        layoutParams5.setMargins(0, 0, 0, 0);
        relativeLayout2.addView(textView2, layoutParams5);
        return relativeLayout;
    }
}

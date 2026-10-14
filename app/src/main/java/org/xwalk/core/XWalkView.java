package org.xwalk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;

import java.util.Map;

/**
 * Minimal compile-time stub of Crosswalk's XWalkView.
 *
 * The real Crosswalk library is discontinued and cannot be shipped in this
 * live-only build. All code paths referencing XWalkView belong to the VOD
 * subsystem, which is unreachable at runtime (the app launches directly into
 * LivePlayActivity and exposes no VOD entry points). These stubs exist solely
 * so the project compiles; their methods are intentionally no-ops.
 */
public class XWalkView extends FrameLayout {

    public XWalkView(Context context) {
        super(context);
    }

    public XWalkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XWalkSettings getSettings() {
        return new XWalkSettings();
    }

    public void setUIClient(XWalkUIClient client) {
    }

    public void setResourceClient(XWalkResourceClient client) {
    }

    public void loadUrl(String url) {
    }

    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
    }

    public void evaluateJavascript(String script, ValueCallback<String> callback) {
    }

    public void stopLoading() {
    }

    public void clearCache(boolean includeDiskFiles) {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public String getUrl() {
        return null;
    }
}

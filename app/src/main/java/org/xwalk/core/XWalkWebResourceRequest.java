package org.xwalk.core;

import android.net.Uri;

import java.util.Map;

/**
 * Minimal compile-time stub of Crosswalk's XWalkWebResourceRequest.
 * See {@link XWalkView} for why this stub exists.
 */
public class XWalkWebResourceRequest {

    public Uri getUrl() {
        return Uri.EMPTY;
    }

    public Map<String, String> getRequestHeaders() {
        return null;
    }

    public boolean hasGesture() {
        return false;
    }

    public boolean isForMainFrame() {
        return false;
    }

    public String getMethod() {
        return "GET";
    }
}

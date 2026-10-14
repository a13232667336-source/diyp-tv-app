package org.xwalk.core;

import java.io.InputStream;

/**
 * Minimal compile-time stub of Crosswalk's XWalkWebResourceResponse.
 * See {@link XWalkView} for why this stub exists.
 */
public class XWalkWebResourceResponse {

    private final String mimeType;
    private final String encoding;
    private final InputStream data;

    public XWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {
        this.mimeType = mimeType;
        this.encoding = encoding;
        this.data = data;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getEncoding() {
        return encoding;
    }

    public InputStream getData() {
        return data;
    }
}

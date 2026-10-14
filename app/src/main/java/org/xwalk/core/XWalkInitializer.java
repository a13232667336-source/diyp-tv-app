package org.xwalk.core;

import android.content.Context;

/**
 * Minimal compile-time stub of Crosswalk's XWalkInitializer.
 * See {@link XWalkView} for why this stub exists.
 */
public class XWalkInitializer {

    public interface XWalkInitListener {
        void onXWalkInitStarted();

        void onXWalkInitCancelled();

        void onXWalkInitFailed();

        void onXWalkInitCompleted();
    }

    public XWalkInitializer(XWalkInitListener listener, Context context) {
    }

    public boolean isXWalkReady() {
        return false;
    }

    public void initAsync() {
    }

    public void cancelInit() {
    }
}

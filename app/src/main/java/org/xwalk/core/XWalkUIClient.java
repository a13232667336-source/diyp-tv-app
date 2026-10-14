package org.xwalk.core;

/**
 * Minimal compile-time stub of Crosswalk's XWalkUIClient.
 * See {@link XWalkView} for why this stub exists.
 */
public class XWalkUIClient {

    public enum ConsoleMessageType {
        DEBUG,
        ERROR,
        LOG,
        WARNING
    }

    public XWalkUIClient(XWalkView view) {
    }

    public boolean onConsoleMessage(XWalkView view, String message, int lineNumber,
            String sourceId, ConsoleMessageType messageType) {
        return false;
    }

    public boolean onJsAlert(XWalkView view, String url, String message,
            XWalkJavascriptResult result) {
        return false;
    }

    public boolean onJsConfirm(XWalkView view, String url, String message,
            XWalkJavascriptResult result) {
        return false;
    }

    public boolean onJsPrompt(XWalkView view, String url, String message,
            String defaultValue, XWalkJavascriptResult result) {
        return false;
    }

    public void onPageLoadStarted(XWalkView view, String url) {
    }

    public void onPageLoadStopped(XWalkView view, String url, LoadStatus status) {
    }

    public enum LoadStatus {
        CANCELLED,
        FAILED,
        FINISHED
    }
}

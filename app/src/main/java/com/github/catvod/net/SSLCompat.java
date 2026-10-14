package com.github.catvod.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 兼容旧版本 Android（4.4，API 19）的 TLS 工具：
 * 信任所有证书，并在握手时启用设备支持的最高 TLS 版本（解决 4.4 默认不启用 TLSv1.2 的问题）
 * 内联替代缺失的外部依赖，与源码内 com.github.catvod.crawler 包的内联方式一致
 */
public class SSLCompat extends SSLSocketFactory {

    public static final X509TrustManager TM = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    private static final String[] PREFERRED_PROTOCOLS = {"TLSv1.2", "TLSv1.1", "TLSv1"};

    private final SSLSocketFactory delegate;

    public SSLCompat() throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{TM}, new SecureRandom());
        delegate = context.getSocketFactory();
    }

    private Socket enableTLS(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;
            List<String> supported = Arrays.asList(sslSocket.getSupportedProtocols());
            List<String> enabled = new ArrayList<>();
            for (String protocol : PREFERRED_PROTOCOLS) {
                if (supported.contains(protocol)) enabled.add(protocol);
            }
            if (!enabled.isEmpty()) sslSocket.setEnabledProtocols(enabled.toArray(new String[0]));
        }
        return socket;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return delegate.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return delegate.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return enableTLS(delegate.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return enableTLS(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return enableTLS(delegate.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return enableTLS(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return enableTLS(delegate.createSocket(address, port, localAddress, localPort));
    }
}

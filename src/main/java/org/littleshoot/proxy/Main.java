package org.littleshoot.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import java.util.Arrays;
import java.util.List;

public class Main {

    static {
        System.setProperty("java.net.useSystemProxies", "true");
    }

    private static final List<String> DIRECT_HOSTS = Arrays.asList(
            ""
    );

    public static void main(String[] args) {
        HttpProxyServer server = DefaultHttpProxyServer
                        .bootstrap()
                .withFiltersSource(new HttpFiltersSourceAdapter() {

                    @Override
                    public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                        return new HttpFiltersAdapter(originalRequest, ctx) {
                            @Override
                            public HttpResponse proxyToServerRequest(HttpObject httpObject) {
                                if (httpObject instanceof HttpRequest proxyHttpRequest) {

                                }

                                return super.proxyToServerRequest(httpObject);
                            }
                        };
                    }
                })
                        .withPort(8090)
                        .start();
    }
}

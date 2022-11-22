package org.littleshoot.proxy.impl;

import java.io.IOException;

public class UnknownHostExceptionWithCause extends IOException {
    public UnknownHostExceptionWithCause(String message, Throwable cause) {
        super(message, cause);
    }
}

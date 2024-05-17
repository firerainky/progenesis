package com.zky.progenesis.config;

public class MyContextHandler {
    private static final ThreadLocal<UserContext> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(UserContext userContext) {
        THREAD_LOCAL.set(userContext);
    }

    public static String getTenantId() {
        return THREAD_LOCAL.get().getOrganizationId();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}

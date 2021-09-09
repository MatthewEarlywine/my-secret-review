package com.liftoff.mysecretreview.security;

public enum ApplicationUserPermission {
    REVIEW_READ("review:read"),
    REVIEW_WRITE("review:write"),
    REVIEW_DELETE("review:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

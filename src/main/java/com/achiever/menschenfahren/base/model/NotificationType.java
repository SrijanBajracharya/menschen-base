package com.achiever.menschenfahren.base.model;

/**
 * Enum containing the type of notification. Whether it is a request or response.
 *
 * @author Srijan Bajracharya
 *
 */
public enum NotificationType {

    REQUEST("request"), INVITE("invite");

    private String value;

    NotificationType(String notificationType) {
        this.value = notificationType;
    }

    public String getValue() {
        return value;
    }

    public static NotificationType fromString(String type) {
        for (NotificationType notificationType : NotificationType.values()) {
            if (notificationType.value.equalsIgnoreCase(type)) {
                return notificationType;
            }
        }
        return null;
    }
}

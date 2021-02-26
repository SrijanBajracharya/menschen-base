package com.achiever.menschenfahren.base.model;

/**
 * Enum class for different types of notification status.
 *
 * @author Srijan Bajracharya
 *
 */
public enum NotificationStatus {

    /** If the notification is still waiting for response **/
    PENDING("pending"),

    /** If the notification gets the approval. **/
    APPROVED("approved"),

    /** If the notification is declined **/
    DECLINED("declined");

    private String value;

    private NotificationStatus(String status) {
        this.value = status;
    }

    public String getValue() {
        return value;
    }

    public static NotificationStatus getByName(String name) {
        for (NotificationStatus status : values()) {
            if (status.getValue().equals(name)) {
                return status;
            }
        }

        throw new IllegalArgumentException(name + " is not a valid PropName");
    }
}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for NotificationLevel.
 */
public enum NotificationLevel {
    /** Enum value Critical. */
    CRITICAL("Critical"),

    /** Enum value Warning. */
    WARNING("Warning"),

    /** Enum value Information. */
    INFORMATION("Information"),

    /** Enum value NonUrgentSuggestion. */
    NON_URGENT_SUGGESTION("NonUrgentSuggestion");

    /** The actual serialized value for a NotificationLevel instance. */
    private String value;

    NotificationLevel(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a NotificationLevel instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed NotificationLevel object, or null if unable to parse.
     */
    @JsonCreator
    public static NotificationLevel fromString(String value) {
        NotificationLevel[] items = NotificationLevel.values();
        for (NotificationLevel item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

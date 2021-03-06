/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for DeploymentMode.
 */
public enum DeploymentMode {
    /** Enum value Incremental. */
    INCREMENTAL("Incremental"),

    /** Enum value Complete. */
    COMPLETE("Complete");

    /** The actual serialized value for a DeploymentMode instance. */
    private String value;

    DeploymentMode(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a DeploymentMode instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed DeploymentMode object, or null if unable to parse.
     */
    @JsonCreator
    public static DeploymentMode fromString(String value) {
        DeploymentMode[] items = DeploymentMode.values();
        for (DeploymentMode item : items) {
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

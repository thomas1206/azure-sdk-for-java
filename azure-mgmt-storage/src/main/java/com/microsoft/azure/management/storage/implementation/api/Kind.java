/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Kind.
 */
public enum Kind {
    /** Enum value Storage. */
    STORAGE("Storage"),

    /** Enum value BlobStorage. */
    BLOB_STORAGE("BlobStorage");

    /** The actual serialized value for a Kind instance. */
    private String value;

    Kind(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a Kind instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed Kind object, or null if unable to parse.
     */
    @JsonCreator
    public static Kind fromString(String value) {
        Kind[] items = Kind.values();
        for (Kind item : items) {
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

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ComputeNodeDeallocationOption.
 */
public enum ComputeNodeDeallocationOption {
    /** Enum value requeue. */
    REQUEUE("requeue"),

    /** Enum value terminate. */
    TERMINATE("terminate"),

    /** Enum value taskcompletion. */
    TASKCOMPLETION("taskcompletion"),

    /** Enum value retaineddata. */
    RETAINEDDATA("retaineddata");

    /** The actual serialized value for a ComputeNodeDeallocationOption instance. */
    private String value;

    ComputeNodeDeallocationOption(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ComputeNodeDeallocationOption instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ComputeNodeDeallocationOption object, or null if unable to parse.
     */
    @JsonCreator
    public static ComputeNodeDeallocationOption fromString(String value) {
        ComputeNodeDeallocationOption[] items = ComputeNodeDeallocationOption.values();
        for (ComputeNodeDeallocationOption item : items) {
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

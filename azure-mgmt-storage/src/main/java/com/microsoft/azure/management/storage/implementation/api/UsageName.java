/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Usage Names.
 */
public class UsageName {
    /**
     * Gets a string describing the resource name.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String value;

    /**
     * Gets a localized string describing the resource name.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String localizedValue;

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public String value() {
        return this.value;
    }

    /**
     * Get the localizedValue value.
     *
     * @return the localizedValue value
     */
    public String localizedValue() {
        return this.localizedValue;
    }

}

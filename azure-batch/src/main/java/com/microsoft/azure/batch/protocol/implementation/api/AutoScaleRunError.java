/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.implementation.api;

import java.util.List;

/**
 * An error that occurred when executing or evaluating a pool autoscale
 * formula.
 */
public class AutoScaleRunError {
    /**
     * Gets or sets an identifier for the autoscale error.  Codes are
     * invariant and are intended to be consumed programmatically.
     */
    private String code;

    /**
     * Gets or sets a message describing the autoscale error, intended to be
     * suitable for display in a user interface.
     */
    private String message;

    /**
     * Gets or sets a list of additional error details related to the
     * autoscale error.
     */
    private List<NameValuePair> values;

    /**
     * Get the code value.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code value.
     *
     * @param code the code value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message value.
     *
     * @param message the message value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the values value.
     *
     * @return the values value
     */
    public List<NameValuePair> values() {
        return this.values;
    }

    /**
     * Set the values value.
     *
     * @param values the values value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError setValues(List<NameValuePair> values) {
        this.values = values;
        return this;
    }

}
/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.analytics.models;


/**
 * A Data Lake Analytics catalog U-SQL directed column item.
 */
public class USqlDirectedColumn {
    /**
     * Gets or sets the name of the index in the table.
     */
    private String name;

    /**
     * Gets or sets the switch indicating if the index is descending or not.
     */
    private Boolean descending;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the descending value.
     *
     * @return the descending value
     */
    public Boolean getDescending() {
        return this.descending;
    }

    /**
     * Set the descending value.
     *
     * @param descending the descending value to set
     */
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }

}
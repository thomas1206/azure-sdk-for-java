/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.implementation.api;


/**
 * The DeploymentExportResultInner model.
 */
public class DeploymentExportResultInner {
    /**
     * Gets or sets the template content.
     */
    private Object template;

    /**
     * Get the template value.
     *
     * @return the template value
     */
    public Object template() {
        return this.template;
    }

    /**
     * Set the template value.
     *
     * @param template the template value to set
     * @return the DeploymentExportResultInner object itself.
     */
    public DeploymentExportResultInner withTemplate(Object template) {
        this.template = template;
        return this;
    }

}

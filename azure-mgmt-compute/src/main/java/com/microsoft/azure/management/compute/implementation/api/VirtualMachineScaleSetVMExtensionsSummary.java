/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute.implementation.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Extensions summary for virtual machines of a virtual machine scale set.
 */
public class VirtualMachineScaleSetVMExtensionsSummary {
    /**
     * Gets the extension name.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * Gets the extensions information.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<VirtualMachineStatusCodeCount> statusesSummary;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the statusesSummary value.
     *
     * @return the statusesSummary value
     */
    public List<VirtualMachineStatusCodeCount> statusesSummary() {
        return this.statusesSummary;
    }

}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.compute.implementation;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.compute.Publisher;
import com.microsoft.azure.management.compute.Publishers;
import com.microsoft.azure.management.compute.implementation.api.VirtualMachineImageResourceInner;
import com.microsoft.azure.management.compute.implementation.api.VirtualMachineImagesInner;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.ReadableWrappersImpl;

import java.io.IOException;

/**
 * The implementation for {@link Publishers}.
 */
class PublishersImpl
        extends ReadableWrappersImpl<Publisher, PublisherImpl, VirtualMachineImageResourceInner>
        implements Publishers {

    private final VirtualMachineImagesInner innerCollection;

    PublishersImpl(VirtualMachineImagesInner innerCollection) {
        this.innerCollection = innerCollection;
    }

    @Override
    public PagedList<Publisher> listByRegion(Region region) throws CloudException, IOException {
        return listByRegion(region.toString());
    }

    @Override
    protected PublisherImpl wrapModel(VirtualMachineImageResourceInner inner) {
        return new PublisherImpl(Region.fromName(inner.location()), inner.name(), this.innerCollection);
    }

    @Override
    public PagedList<Publisher> listByRegion(String regionName) throws CloudException, IOException {
        return wrapList(innerCollection.listPublishers(regionName).getBody());
    }
}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.implementation;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.resources.GenericResources;
import com.microsoft.azure.management.resources.ResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.GroupableResourcesImpl;
import com.microsoft.azure.management.resources.implementation.api.ResourceGroupsInner;
import com.microsoft.azure.management.resources.implementation.api.ResourceManagementClientImpl;
import com.microsoft.azure.management.resources.implementation.api.ResourcesInner;
import com.microsoft.azure.management.resources.GenericResource;
import com.microsoft.azure.management.resources.implementation.api.GenericResourceInner;
import com.microsoft.azure.management.resources.implementation.api.ResourcesMoveInfoInner;

import java.io.IOException;
import java.util.List;

/**
 * Implementation of the {@link GenericResources}.
 */
final class GenericResourcesImpl
    extends GroupableResourcesImpl<GenericResource, GenericResourceImpl, GenericResourceInner, ResourcesInner>
    implements GenericResources {

    private final ResourceManagementClientImpl serviceClient;
    private final ResourceGroupsInner resourceGroupsInner;

    GenericResourcesImpl(ResourceManagementClientImpl serviceClient, ResourceManager resourceManager) {
        super(resourceManager, serviceClient.resources());
        this.serviceClient = serviceClient;
        this.resourceGroupsInner = serviceClient.resourceGroups();
    }

    @Override
    public PagedList<GenericResource> listByGroup(String groupName) throws CloudException, IOException {
        return wrapList(resourceGroupsInner.listResources(groupName).getBody());
    }

    @Override
    public GenericResource.DefinitionBlank define(String name) {
        return new GenericResourceImpl(
                name,
                new GenericResourceInner(),
                this.innerCollection,
                serviceClient,
                this.resourceManager);
    }

    @Override
    public boolean checkExistence(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws IOException, CloudException {
        return this.innerCollection.checkExistence(
                resourceGroupName,
                resourceProviderNamespace,
                parentResourcePath,
                resourceType,
                resourceName,
                apiVersion).getBody();
    }

    @Override
    public GenericResource get(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws CloudException, IOException {
        GenericResourceInner inner = this.innerCollection.get(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, apiVersion).getBody();
        GenericResourceImpl resource = new GenericResourceImpl(
                resourceName,
                inner,
                this.innerCollection,
                serviceClient,
                this.resourceManager);

        return resource.withExistingGroup(resourceGroupName)
                .withProviderNamespace(resourceProviderNamespace)
                .withParentResource(parentResourcePath)
                .withResourceType(resourceType)
                .withApiVersion(apiVersion);
    }

    @Override
    public void moveResources(String sourceResourceGroupName, ResourceGroup targetResourceGroup, List<String> resources) throws CloudException, IOException, InterruptedException {
        ResourcesMoveInfoInner moveInfo = new ResourcesMoveInfoInner();
        moveInfo.withTargetResourceGroup(targetResourceGroup.id());
        moveInfo.withResources(resources);
        this.innerCollection.moveResources(sourceResourceGroupName, moveInfo);
    }

    @Override
    public void delete(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws CloudException, IOException {
        this.innerCollection.delete(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, apiVersion);
    }

    @Override
    public GenericResource getByGroup(String groupName, String name) throws CloudException, IOException {
        PagedList<GenericResource> genericResources = this.listByGroup(groupName);
        for (GenericResource resource : genericResources) {
            if (resource.name().equalsIgnoreCase(name)) {
                return resource;
            }
        }
        throw new CloudException("Generic resource not found.");
    }

    @Override
    protected GenericResourceImpl wrapModel(String id) {
        return new GenericResourceImpl(
                id,
                new GenericResourceInner(),
                this.innerCollection,
                this.serviceClient,
                this.resourceManager)
                .withExistingGroup(ResourceUtils.groupFromResourceId(id))
                .withProviderNamespace(ResourceUtils.resourceProviderFromResourceId(id))
                .withResourceType(ResourceUtils.resourceTypeFromResourceId(id))
                .withParentResource(ResourceUtils.parentResourcePathFromResourceId(id));
    }

    @Override
    protected GenericResourceImpl wrapModel(GenericResourceInner inner) {
        return new GenericResourceImpl(
                inner.id(),
                inner,
                this.innerCollection,
                this.serviceClient,
                this.resourceManager)
                .withExistingGroup(ResourceUtils.groupFromResourceId(inner.id()))
                .withProviderNamespace(ResourceUtils.resourceProviderFromResourceId(inner.id()))
                .withResourceType(ResourceUtils.resourceTypeFromResourceId(inner.id()))
                .withParentResource(ResourceUtils.parentResourcePathFromResourceId(inner.id()));
    }
}

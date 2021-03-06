/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.network.implementation;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.azure.management.network.NetworkSecurityGroups;
import com.microsoft.azure.management.network.implementation.api.NetworkSecurityGroupInner;
import com.microsoft.azure.management.network.implementation.api.NetworkSecurityGroupsInner;
import com.microsoft.azure.management.network.implementation.api.SecurityRuleInner;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.GroupableResourcesImpl;
import com.microsoft.azure.management.resources.implementation.ResourceManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  Implementation for {@link NetworkSecurityGroups}.
 */
class NetworkSecurityGroupsImpl
        extends GroupableResourcesImpl<NetworkSecurityGroup, NetworkSecurityGroupImpl, NetworkSecurityGroupInner, NetworkSecurityGroupsInner>
        implements NetworkSecurityGroups {

    NetworkSecurityGroupsImpl(final NetworkSecurityGroupsInner client, final ResourceManager resourceManager) {
        super(resourceManager, client);
    }

    @Override
    public PagedList<NetworkSecurityGroup> list() throws CloudException, IOException {
        return wrapList(this.innerCollection.listAll().getBody());
    }

    @Override
    public PagedList<NetworkSecurityGroup> listByGroup(String groupName) throws CloudException, IOException {
        return wrapList(this.innerCollection.list(groupName).getBody());
    }

    @Override
    public NetworkSecurityGroupImpl getByGroup(String groupName, String name) throws CloudException, IOException {
        return wrapModel(this.innerCollection.get(groupName, name).getBody());
    }

    @Override
    public void delete(String id) throws Exception {
        delete(ResourceUtils.groupFromResourceId(id), ResourceUtils.nameFromResourceId(id));
    }

    @Override
    public void delete(String groupName, String name) throws Exception {
        this.innerCollection.delete(groupName, name);
    }

    @Override
    public NetworkSecurityGroupImpl define(String name) {
        return wrapModel(name);
    }

    // Fluent model create helpers

    @Override
    protected NetworkSecurityGroupImpl wrapModel(String name) {
        NetworkSecurityGroupInner inner = new NetworkSecurityGroupInner();

        // Initialize rules
        if (inner.securityRules() == null) {
            inner.withSecurityRules(new ArrayList<SecurityRuleInner>());
        }

        if (inner.defaultSecurityRules() == null) {
            inner.withDefaultSecurityRules(new ArrayList<SecurityRuleInner>());
        }

        return new NetworkSecurityGroupImpl(name, inner, this.innerCollection, this.resourceManager);
    }

    @Override
    protected NetworkSecurityGroupImpl wrapModel(NetworkSecurityGroupInner inner) {
        return new NetworkSecurityGroupImpl(inner.name(), inner, this.innerCollection, this.resourceManager);
    }
}

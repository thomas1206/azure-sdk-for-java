/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;

/**
 * An instance of this class provides access to all the operations defined
 * in GlobalResourceGroups.
 */
public final class GlobalResourceGroupsInner {
    /** The Retrofit service to perform REST calls. */
    private GlobalResourceGroupsService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of GlobalResourceGroupsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public GlobalResourceGroupsInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(GlobalResourceGroupsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for GlobalResourceGroups to be
     * used by Retrofit to perform actually REST calls.
     */
    interface GlobalResourceGroupsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/moveResources")
        Call<ResponseBody> moveResources(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Body CsmMoveResourceEnvelopeInner moveResourceEnvelope, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     *
     * @param resourceGroupName the String value
     * @param moveResourceEnvelope the CsmMoveResourceEnvelopeInner value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> moveResources(String resourceGroupName, CsmMoveResourceEnvelopeInner moveResourceEnvelope) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (moveResourceEnvelope == null) {
            throw new IllegalArgumentException("Parameter moveResourceEnvelope is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(moveResourceEnvelope);
        Call<ResponseBody> call = service.moveResources(resourceGroupName, this.client.subscriptionId(), moveResourceEnvelope, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return moveResourcesDelegate(call.execute());
    }

    /**
     *
     * @param resourceGroupName the String value
     * @param moveResourceEnvelope the CsmMoveResourceEnvelopeInner value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall moveResourcesAsync(String resourceGroupName, CsmMoveResourceEnvelopeInner moveResourceEnvelope, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (moveResourceEnvelope == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter moveResourceEnvelope is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(moveResourceEnvelope, serviceCallback);
        Call<ResponseBody> call = service.moveResources(resourceGroupName, this.client.subscriptionId(), moveResourceEnvelope, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(moveResourcesDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> moveResourcesDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.mapperAdapter())
                .register(204, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

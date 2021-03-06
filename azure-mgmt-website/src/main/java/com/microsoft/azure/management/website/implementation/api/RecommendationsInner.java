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
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;

/**
 * An instance of this class provides access to all the operations defined
 * in Recommendations.
 */
public final class RecommendationsInner {
    /** The Retrofit service to perform REST calls. */
    private RecommendationsService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of RecommendationsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public RecommendationsInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(RecommendationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Recommendations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface RecommendationsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Web/recommendations")
        Call<ResponseBody> getRecommendationBySubscription(@Path("subscriptionId") String subscriptionId, @Query("featured") Boolean featured, @Query("$filter") String filter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Web/sites/{siteName}/recommendations/{name}")
        Call<ResponseBody> getRuleDetailsBySiteName(@Path("resourceGroupName") String resourceGroupName, @Path("siteName") String siteName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Web/sites/{siteName}/recommendations")
        Call<ResponseBody> getRecommendedRulesForSite(@Path("resourceGroupName") String resourceGroupName, @Path("siteName") String siteName, @Path("subscriptionId") String subscriptionId, @Query("featured") Boolean featured, @Query("siteSku") String siteSku, @Query("numSlots") Integer numSlots, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Web/sites/{siteName}/recommendationHistory")
        Call<ResponseBody> getRecommendationHistoryForSite(@Path("resourceGroupName") String resourceGroupName, @Path("siteName") String siteName, @Path("subscriptionId") String subscriptionId, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets a list of recommendations associated with the specified subscription.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendationBySubscription() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final Boolean featured = null;
        final String filter = null;
        Call<ResponseBody> call = service.getRecommendationBySubscription(this.client.subscriptionId(), featured, filter, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendationBySubscriptionDelegate(call.execute());
    }

    /**
     * Gets a list of recommendations associated with the specified subscription.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendationBySubscriptionAsync(final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        final Boolean featured = null;
        final String filter = null;
        Call<ResponseBody> call = service.getRecommendationBySubscription(this.client.subscriptionId(), featured, filter, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendationBySubscriptionDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets a list of recommendations associated with the specified subscription.
     *
     * @param featured If set, this API returns only the most critical recommendation among the others. Otherwise this API returns all recommendations available
     * @param filter Return only channels specified in the filter. Filter is specified by using OData syntax. Example: $filter=channels eq 'Api' or channel eq 'Notification'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendationBySubscription(Boolean featured, String filter) throws CloudException, IOException, IllegalArgumentException {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getRecommendationBySubscription(this.client.subscriptionId(), featured, filter, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendationBySubscriptionDelegate(call.execute());
    }

    /**
     * Gets a list of recommendations associated with the specified subscription.
     *
     * @param featured If set, this API returns only the most critical recommendation among the others. Otherwise this API returns all recommendations available
     * @param filter Return only channels specified in the filter. Filter is specified by using OData syntax. Example: $filter=channels eq 'Api' or channel eq 'Notification'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendationBySubscriptionAsync(Boolean featured, String filter, final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getRecommendationBySubscription(this.client.subscriptionId(), featured, filter, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendationBySubscriptionDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<RecommendationInner>> getRecommendationBySubscriptionDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<List<RecommendationInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<List<RecommendationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the detailed properties of the recommendation object for the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param name Recommendation rule name
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the RecommendationRuleInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<RecommendationRuleInner> getRuleDetailsBySiteName(String resourceGroupName, String siteName, String name) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (siteName == null) {
            throw new IllegalArgumentException("Parameter siteName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getRuleDetailsBySiteName(resourceGroupName, siteName, name, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRuleDetailsBySiteNameDelegate(call.execute());
    }

    /**
     * Gets the detailed properties of the recommendation object for the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param name Recommendation rule name
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRuleDetailsBySiteNameAsync(String resourceGroupName, String siteName, String name, final ServiceCallback<RecommendationRuleInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (siteName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter siteName is required and cannot be null."));
            return null;
        }
        if (name == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter name is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getRuleDetailsBySiteName(resourceGroupName, siteName, name, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<RecommendationRuleInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRuleDetailsBySiteNameDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<RecommendationRuleInner> getRuleDetailsBySiteNameDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<RecommendationRuleInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<RecommendationRuleInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets a list of recommendations associated with the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendedRulesForSite(String resourceGroupName, String siteName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (siteName == null) {
            throw new IllegalArgumentException("Parameter siteName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final Boolean featured = null;
        final String siteSku = null;
        final Integer numSlots = null;
        Call<ResponseBody> call = service.getRecommendedRulesForSite(resourceGroupName, siteName, this.client.subscriptionId(), featured, siteSku, numSlots, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendedRulesForSiteDelegate(call.execute());
    }

    /**
     * Gets a list of recommendations associated with the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendedRulesForSiteAsync(String resourceGroupName, String siteName, final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (siteName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter siteName is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        final Boolean featured = null;
        final String siteSku = null;
        final Integer numSlots = null;
        Call<ResponseBody> call = service.getRecommendedRulesForSite(resourceGroupName, siteName, this.client.subscriptionId(), featured, siteSku, numSlots, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendedRulesForSiteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets a list of recommendations associated with the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param featured If set, this API returns only the most critical recommendation among the others. Otherwise this API returns all recommendations available
     * @param siteSku The name of site SKU.
     * @param numSlots The number of site slots associated to the site
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendedRulesForSite(String resourceGroupName, String siteName, Boolean featured, String siteSku, Integer numSlots) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (siteName == null) {
            throw new IllegalArgumentException("Parameter siteName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getRecommendedRulesForSite(resourceGroupName, siteName, this.client.subscriptionId(), featured, siteSku, numSlots, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendedRulesForSiteDelegate(call.execute());
    }

    /**
     * Gets a list of recommendations associated with the specified web site.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param featured If set, this API returns only the most critical recommendation among the others. Otherwise this API returns all recommendations available
     * @param siteSku The name of site SKU.
     * @param numSlots The number of site slots associated to the site
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendedRulesForSiteAsync(String resourceGroupName, String siteName, Boolean featured, String siteSku, Integer numSlots, final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (siteName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter siteName is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getRecommendedRulesForSite(resourceGroupName, siteName, this.client.subscriptionId(), featured, siteSku, numSlots, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendedRulesForSiteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<RecommendationInner>> getRecommendedRulesForSiteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<List<RecommendationInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<List<RecommendationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the list of past recommendations optionally specified by the time range.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendationHistoryForSite(String resourceGroupName, String siteName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (siteName == null) {
            throw new IllegalArgumentException("Parameter siteName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final String startTime = null;
        final String endTime = null;
        Call<ResponseBody> call = service.getRecommendationHistoryForSite(resourceGroupName, siteName, this.client.subscriptionId(), startTime, endTime, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendationHistoryForSiteDelegate(call.execute());
    }

    /**
     * Gets the list of past recommendations optionally specified by the time range.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendationHistoryForSiteAsync(String resourceGroupName, String siteName, final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (siteName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter siteName is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        final String startTime = null;
        final String endTime = null;
        Call<ResponseBody> call = service.getRecommendationHistoryForSite(resourceGroupName, siteName, this.client.subscriptionId(), startTime, endTime, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendationHistoryForSiteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets the list of past recommendations optionally specified by the time range.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param startTime The start time of a time range to query, e.g. $filter=startTime eq '2015-01-01T00:00:00Z' and endTime eq '2015-01-02T00:00:00Z'
     * @param endTime The end time of a time range to query, e.g. $filter=startTime eq '2015-01-01T00:00:00Z' and endTime eq '2015-01-02T00:00:00Z'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;RecommendationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<RecommendationInner>> getRecommendationHistoryForSite(String resourceGroupName, String siteName, String startTime, String endTime) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (siteName == null) {
            throw new IllegalArgumentException("Parameter siteName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getRecommendationHistoryForSite(resourceGroupName, siteName, this.client.subscriptionId(), startTime, endTime, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getRecommendationHistoryForSiteDelegate(call.execute());
    }

    /**
     * Gets the list of past recommendations optionally specified by the time range.
     *
     * @param resourceGroupName Resource group name
     * @param siteName Site name
     * @param startTime The start time of a time range to query, e.g. $filter=startTime eq '2015-01-01T00:00:00Z' and endTime eq '2015-01-02T00:00:00Z'
     * @param endTime The end time of a time range to query, e.g. $filter=startTime eq '2015-01-01T00:00:00Z' and endTime eq '2015-01-02T00:00:00Z'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRecommendationHistoryForSiteAsync(String resourceGroupName, String siteName, String startTime, String endTime, final ServiceCallback<List<RecommendationInner>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (siteName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter siteName is required and cannot be null."));
            return null;
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getRecommendationHistoryForSite(resourceGroupName, siteName, this.client.subscriptionId(), startTime, endTime, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<RecommendationInner>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRecommendationHistoryForSiteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<RecommendationInner>> getRecommendationHistoryForSiteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<List<RecommendationInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<List<RecommendationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}

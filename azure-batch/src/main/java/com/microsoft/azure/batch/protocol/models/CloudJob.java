/**
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import org.joda.time.DateTime;
import java.util.List;

/**
 * An Azure Batch job.
 */
public class CloudJob {
    /**
     * Gets or sets a string that uniquely identifies the job within the
     * account. The id can contain any combination of alphanumeric characters
     * including hyphens and underscores, and cannot contain more than 64
     * characters. It is common to use a GUID for the id.
     */
    private String id;

    /**
     * Gets or sets the display name for the job.
     */
    private String displayName;

    /**
     * Gets or sets the flag that determines if this job will use tasks with
     * dependencies.
     */
    private Boolean usesTaskDependencies;

    /**
     * Gets or sets the URL of the job.
     */
    private String url;

    /**
     * Gets or sets the ETag of the job.
     */
    private String eTag;

    /**
     * Gets or sets the last modified time of the job.
     */
    private DateTime lastModified;

    /**
     * Gets or sets the creation time of the job.
     */
    private DateTime creationTime;

    /**
     * Gets or sets the current state of the job. Possible values include:
     * 'active', 'disabling', 'disabled', 'enabling', 'terminating',
     * 'completed', 'deleting'.
     */
    private JobState state;

    /**
     * Gets or sets the time at which the job entered its current state.
     */
    private DateTime stateTransitionTime;

    /**
     * Gets or sets the previous state of the job. This property is not set if
     * the job is in its initial Active state. Possible values include:
     * 'active', 'disabling', 'disabled', 'enabling', 'terminating',
     * 'completed', 'deleting'.
     */
    private JobState previousState;

    /**
     * Gets or sets the time at which the job entered its previous state. This
     * property is not set if the job is in its initial Active state.
     */
    private DateTime previousStateTransitionTime;

    /**
     * Gets or sets the priority of the job. Priority values can range from
     * -1000 to 1000, with -1000 being the lowest priority and 1000 being the
     * highest priority. The default value is 0.
     */
    private Integer priority;

    /**
     * Gets or sets the execution constraints for the job.
     */
    private JobConstraints constraints;

    /**
     * Gets or sets details of a Job Manager task to be launched when the job
     * is started.
     */
    private JobManagerTask jobManagerTask;

    /**
     * Gets or sets the Job Preparation task.
     */
    private JobPreparationTask jobPreparationTask;

    /**
     * Gets or sets the Job Release task.
     */
    private JobReleaseTask jobReleaseTask;

    /**
     * Gets or sets the list of common environment variable settings.  These
     * environment variables are set for all tasks in the job (including the
     * Job Manager, Job Preparation and Job Release tasks).
     */
    private List<EnvironmentSetting> commonEnvironmentSettings;

    /**
     * Gets or sets the pool on which the Batch service runs the jobâ€™s tasks.
     */
    private PoolInformation poolInfo;

    /**
     * Gets or sets a list of name-value pairs associated with the job as
     * metadata.
     */
    private List<MetadataItem> metadata;

    /**
     * Gets or sets the execution information for the job.
     */
    private JobExecutionInformation executionInfo;

    /**
     * Gets or sets resource usage statistics for the entire lifetime of the
     * job.
     */
    private JobStatistics stats;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the usesTaskDependencies value.
     *
     * @return the usesTaskDependencies value
     */
    public Boolean getUsesTaskDependencies() {
        return this.usesTaskDependencies;
    }

    /**
     * Set the usesTaskDependencies value.
     *
     * @param usesTaskDependencies the usesTaskDependencies value to set
     */
    public void setUsesTaskDependencies(Boolean usesTaskDependencies) {
        this.usesTaskDependencies = usesTaskDependencies;
    }

    /**
     * Get the url value.
     *
     * @return the url value
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url value.
     *
     * @param url the url value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the eTag value.
     *
     * @return the eTag value
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag value.
     *
     * @param eTag the eTag value to set
     */
    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    /**
     * Get the lastModified value.
     *
     * @return the lastModified value
     */
    public DateTime getLastModified() {
        return this.lastModified;
    }

    /**
     * Set the lastModified value.
     *
     * @param lastModified the lastModified value to set
     */
    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Get the creationTime value.
     *
     * @return the creationTime value
     */
    public DateTime getCreationTime() {
        return this.creationTime;
    }

    /**
     * Set the creationTime value.
     *
     * @param creationTime the creationTime value to set
     */
    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public JobState getState() {
        return this.state;
    }

    /**
     * Set the state value.
     *
     * @param state the state value to set
     */
    public void setState(JobState state) {
        this.state = state;
    }

    /**
     * Get the stateTransitionTime value.
     *
     * @return the stateTransitionTime value
     */
    public DateTime getStateTransitionTime() {
        return this.stateTransitionTime;
    }

    /**
     * Set the stateTransitionTime value.
     *
     * @param stateTransitionTime the stateTransitionTime value to set
     */
    public void setStateTransitionTime(DateTime stateTransitionTime) {
        this.stateTransitionTime = stateTransitionTime;
    }

    /**
     * Get the previousState value.
     *
     * @return the previousState value
     */
    public JobState getPreviousState() {
        return this.previousState;
    }

    /**
     * Set the previousState value.
     *
     * @param previousState the previousState value to set
     */
    public void setPreviousState(JobState previousState) {
        this.previousState = previousState;
    }

    /**
     * Get the previousStateTransitionTime value.
     *
     * @return the previousStateTransitionTime value
     */
    public DateTime getPreviousStateTransitionTime() {
        return this.previousStateTransitionTime;
    }

    /**
     * Set the previousStateTransitionTime value.
     *
     * @param previousStateTransitionTime the previousStateTransitionTime value to set
     */
    public void setPreviousStateTransitionTime(DateTime previousStateTransitionTime) {
        this.previousStateTransitionTime = previousStateTransitionTime;
    }

    /**
     * Get the priority value.
     *
     * @return the priority value
     */
    public Integer getPriority() {
        return this.priority;
    }

    /**
     * Set the priority value.
     *
     * @param priority the priority value to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Get the constraints value.
     *
     * @return the constraints value
     */
    public JobConstraints getConstraints() {
        return this.constraints;
    }

    /**
     * Set the constraints value.
     *
     * @param constraints the constraints value to set
     */
    public void setConstraints(JobConstraints constraints) {
        this.constraints = constraints;
    }

    /**
     * Get the jobManagerTask value.
     *
     * @return the jobManagerTask value
     */
    public JobManagerTask getJobManagerTask() {
        return this.jobManagerTask;
    }

    /**
     * Set the jobManagerTask value.
     *
     * @param jobManagerTask the jobManagerTask value to set
     */
    public void setJobManagerTask(JobManagerTask jobManagerTask) {
        this.jobManagerTask = jobManagerTask;
    }

    /**
     * Get the jobPreparationTask value.
     *
     * @return the jobPreparationTask value
     */
    public JobPreparationTask getJobPreparationTask() {
        return this.jobPreparationTask;
    }

    /**
     * Set the jobPreparationTask value.
     *
     * @param jobPreparationTask the jobPreparationTask value to set
     */
    public void setJobPreparationTask(JobPreparationTask jobPreparationTask) {
        this.jobPreparationTask = jobPreparationTask;
    }

    /**
     * Get the jobReleaseTask value.
     *
     * @return the jobReleaseTask value
     */
    public JobReleaseTask getJobReleaseTask() {
        return this.jobReleaseTask;
    }

    /**
     * Set the jobReleaseTask value.
     *
     * @param jobReleaseTask the jobReleaseTask value to set
     */
    public void setJobReleaseTask(JobReleaseTask jobReleaseTask) {
        this.jobReleaseTask = jobReleaseTask;
    }

    /**
     * Get the commonEnvironmentSettings value.
     *
     * @return the commonEnvironmentSettings value
     */
    public List<EnvironmentSetting> getCommonEnvironmentSettings() {
        return this.commonEnvironmentSettings;
    }

    /**
     * Set the commonEnvironmentSettings value.
     *
     * @param commonEnvironmentSettings the commonEnvironmentSettings value to set
     */
    public void setCommonEnvironmentSettings(List<EnvironmentSetting> commonEnvironmentSettings) {
        this.commonEnvironmentSettings = commonEnvironmentSettings;
    }

    /**
     * Get the poolInfo value.
     *
     * @return the poolInfo value
     */
    public PoolInformation getPoolInfo() {
        return this.poolInfo;
    }

    /**
     * Set the poolInfo value.
     *
     * @param poolInfo the poolInfo value to set
     */
    public void setPoolInfo(PoolInformation poolInfo) {
        this.poolInfo = poolInfo;
    }

    /**
     * Get the metadata value.
     *
     * @return the metadata value
     */
    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    /**
     * Set the metadata value.
     *
     * @param metadata the metadata value to set
     */
    public void setMetadata(List<MetadataItem> metadata) {
        this.metadata = metadata;
    }

    /**
     * Get the executionInfo value.
     *
     * @return the executionInfo value
     */
    public JobExecutionInformation getExecutionInfo() {
        return this.executionInfo;
    }

    /**
     * Set the executionInfo value.
     *
     * @param executionInfo the executionInfo value to set
     */
    public void setExecutionInfo(JobExecutionInformation executionInfo) {
        this.executionInfo = executionInfo;
    }

    /**
     * Get the stats value.
     *
     * @return the stats value
     */
    public JobStatistics getStats() {
        return this.stats;
    }

    /**
     * Set the stats value.
     *
     * @param stats the stats value to set
     */
    public void setStats(JobStatistics stats) {
        this.stats = stats;
    }

}
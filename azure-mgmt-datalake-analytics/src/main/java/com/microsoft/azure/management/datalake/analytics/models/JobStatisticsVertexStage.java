/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Data Lake Analytics job statistics vertex stage information.
 */
public class JobStatisticsVertexStage {
    /**
     * the amount of data read, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long dataRead;

    /**
     * the amount of data read across multiple pods, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long dataReadCrossPod;

    /**
     * the amount of data read in one pod, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long dataReadIntraPod;

    /**
     * the amount of data remaining to be read, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long dataToRead;

    /**
     * the amount of data written, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long dataWritten;

    /**
     * the number of duplicates that were discarded.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer duplicateDiscardCount;

    /**
     * the number of failures that occured in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer failedCount;

    /**
     * the maximum amount of data read in a single vertex, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long maxVertexDataRead;

    /**
     * the minimum amount of data read in a single vertex, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long minVertexDataRead;

    /**
     * the number of read failures in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer readFailureCount;

    /**
     * the number of vertices that were revoked during this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer revocationCount;

    /**
     * the number of currently running vertices in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer runningCount;

    /**
     * the number of currently scheduled vertices in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer scheduledCount;

    /**
     * the name of this stage in job execution.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String stageName;

    /**
     * the number of vertices that succeeded in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer succeededCount;

    /**
     * the amount of temporary data written, in bytes.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long tempDataWritten;

    /**
     * the total vertex count for this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer totalCount;

    /**
     * the amount of time that failed vertices took up in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Period totalFailedTime;

    /**
     * the current progress of this stage, as a percentage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer totalProgress;

    /**
     * the amount of time all successful vertices took in this stage.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Period totalSucceededTime;

    /**
     * Get the dataRead value.
     *
     * @return the dataRead value
     */
    public Long dataRead() {
        return this.dataRead;
    }

    /**
     * Get the dataReadCrossPod value.
     *
     * @return the dataReadCrossPod value
     */
    public Long dataReadCrossPod() {
        return this.dataReadCrossPod;
    }

    /**
     * Get the dataReadIntraPod value.
     *
     * @return the dataReadIntraPod value
     */
    public Long dataReadIntraPod() {
        return this.dataReadIntraPod;
    }

    /**
     * Get the dataToRead value.
     *
     * @return the dataToRead value
     */
    public Long dataToRead() {
        return this.dataToRead;
    }

    /**
     * Get the dataWritten value.
     *
     * @return the dataWritten value
     */
    public Long dataWritten() {
        return this.dataWritten;
    }

    /**
     * Get the duplicateDiscardCount value.
     *
     * @return the duplicateDiscardCount value
     */
    public Integer duplicateDiscardCount() {
        return this.duplicateDiscardCount;
    }

    /**
     * Get the failedCount value.
     *
     * @return the failedCount value
     */
    public Integer failedCount() {
        return this.failedCount;
    }

    /**
     * Get the maxVertexDataRead value.
     *
     * @return the maxVertexDataRead value
     */
    public Long maxVertexDataRead() {
        return this.maxVertexDataRead;
    }

    /**
     * Get the minVertexDataRead value.
     *
     * @return the minVertexDataRead value
     */
    public Long minVertexDataRead() {
        return this.minVertexDataRead;
    }

    /**
     * Get the readFailureCount value.
     *
     * @return the readFailureCount value
     */
    public Integer readFailureCount() {
        return this.readFailureCount;
    }

    /**
     * Get the revocationCount value.
     *
     * @return the revocationCount value
     */
    public Integer revocationCount() {
        return this.revocationCount;
    }

    /**
     * Get the runningCount value.
     *
     * @return the runningCount value
     */
    public Integer runningCount() {
        return this.runningCount;
    }

    /**
     * Get the scheduledCount value.
     *
     * @return the scheduledCount value
     */
    public Integer scheduledCount() {
        return this.scheduledCount;
    }

    /**
     * Get the stageName value.
     *
     * @return the stageName value
     */
    public String stageName() {
        return this.stageName;
    }

    /**
     * Get the succeededCount value.
     *
     * @return the succeededCount value
     */
    public Integer succeededCount() {
        return this.succeededCount;
    }

    /**
     * Get the tempDataWritten value.
     *
     * @return the tempDataWritten value
     */
    public Long tempDataWritten() {
        return this.tempDataWritten;
    }

    /**
     * Get the totalCount value.
     *
     * @return the totalCount value
     */
    public Integer totalCount() {
        return this.totalCount;
    }

    /**
     * Get the totalFailedTime value.
     *
     * @return the totalFailedTime value
     */
    public Period totalFailedTime() {
        return this.totalFailedTime;
    }

    /**
     * Get the totalProgress value.
     *
     * @return the totalProgress value
     */
    public Integer totalProgress() {
        return this.totalProgress;
    }

    /**
     * Get the totalSucceededTime value.
     *
     * @return the totalSucceededTime value
     */
    public Period totalSucceededTime() {
        return this.totalSucceededTime;
    }

}

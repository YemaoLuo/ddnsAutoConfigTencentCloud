/*
 * Copyright (c) 2017-2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cpb.TencentCloudApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencentcloudapi.common.AbstractModel;

import java.util.HashMap;

public class DescribeDomainLogListResponse extends AbstractModel {

    /**
     * 域名信息
     * 注意：此字段可能返回 null，表示取不到有效值。
     */
    @SerializedName("LogList")
    @Expose
    private String[] LogList;

    /**
     * 分页大小
     */
    @SerializedName("PageSize")
    @Expose
    private Long PageSize;

    /**
     * 日志总条数
     */
    @SerializedName("TotalCount")
    @Expose
    private Long TotalCount;

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    @SerializedName("RequestId")
    @Expose
    private String RequestId;

    /**
     * Get 域名信息
     * 注意：此字段可能返回 null，表示取不到有效值。
     *
     * @return LogList 域名信息
     * 注意：此字段可能返回 null，表示取不到有效值。
     */
    public String[] getLogList() {
        return this.LogList;
    }

    /**
     * Set 域名信息
     * 注意：此字段可能返回 null，表示取不到有效值。
     *
     * @param LogList 域名信息
     *                注意：此字段可能返回 null，表示取不到有效值。
     */
    public void setLogList(String[] LogList) {
        this.LogList = LogList;
    }

    /**
     * Get 分页大小
     *
     * @return PageSize 分页大小
     */
    public Long getPageSize() {
        return this.PageSize;
    }

    /**
     * Set 分页大小
     *
     * @param PageSize 分页大小
     */
    public void setPageSize(Long PageSize) {
        this.PageSize = PageSize;
    }

    /**
     * Get 日志总条数
     *
     * @return TotalCount 日志总条数
     */
    public Long getTotalCount() {
        return this.TotalCount;
    }

    /**
     * Set 日志总条数
     *
     * @param TotalCount 日志总条数
     */
    public void setTotalCount(Long TotalCount) {
        this.TotalCount = TotalCount;
    }

    /**
     * Get 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     *
     * @return RequestId 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    public String getRequestId() {
        return this.RequestId;
    }

    /**
     * Set 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     *
     * @param RequestId 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    public void setRequestId(String RequestId) {
        this.RequestId = RequestId;
    }

    public DescribeDomainLogListResponse() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     * and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public DescribeDomainLogListResponse(DescribeDomainLogListResponse source) {
        if (source.LogList != null) {
            this.LogList = new String[source.LogList.length];
            for (int i = 0; i < source.LogList.length; i++) {
                this.LogList[i] = new String(source.LogList[i]);
            }
        }
        if (source.PageSize != null) {
            this.PageSize = new Long(source.PageSize);
        }
        if (source.TotalCount != null) {
            this.TotalCount = new Long(source.TotalCount);
        }
        if (source.RequestId != null) {
            this.RequestId = new String(source.RequestId);
        }
    }


    /**
     * Internal implementation, normal users should not use it.
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamArraySimple(map, prefix + "LogList.", this.LogList);
        this.setParamSimple(map, prefix + "PageSize", this.PageSize);
        this.setParamSimple(map, prefix + "TotalCount", this.TotalCount);
        this.setParamSimple(map, prefix + "RequestId", this.RequestId);

    }
}


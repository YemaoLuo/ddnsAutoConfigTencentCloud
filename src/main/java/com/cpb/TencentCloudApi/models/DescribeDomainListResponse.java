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
import com.tencentcloudapi.dnspod.v20210323.models.DomainCountInfo;
import com.tencentcloudapi.dnspod.v20210323.models.DomainListItem;

import java.util.HashMap;

public class DescribeDomainListResponse extends AbstractModel {

    /**
     * 列表页统计信息
     */
    @SerializedName("DomainCountInfo")
    @Expose
    private com.tencentcloudapi.dnspod.v20210323.models.DomainCountInfo DomainCountInfo;

    /**
     * 域名列表
     */
    @SerializedName("DomainList")
    @Expose
    private com.tencentcloudapi.dnspod.v20210323.models.DomainListItem[] DomainList;

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    @SerializedName("RequestId")
    @Expose
    private String RequestId;

    /**
     * Get 列表页统计信息
     *
     * @return DomainCountInfo 列表页统计信息
     */
    public com.tencentcloudapi.dnspod.v20210323.models.DomainCountInfo getDomainCountInfo() {
        return this.DomainCountInfo;
    }

    /**
     * Set 列表页统计信息
     *
     * @param DomainCountInfo 列表页统计信息
     */
    public void setDomainCountInfo(com.tencentcloudapi.dnspod.v20210323.models.DomainCountInfo DomainCountInfo) {
        this.DomainCountInfo = DomainCountInfo;
    }

    /**
     * Get 域名列表
     *
     * @return DomainList 域名列表
     */
    public com.tencentcloudapi.dnspod.v20210323.models.DomainListItem[] getDomainList() {
        return this.DomainList;
    }

    /**
     * Set 域名列表
     *
     * @param DomainList 域名列表
     */
    public void setDomainList(com.tencentcloudapi.dnspod.v20210323.models.DomainListItem[] DomainList) {
        this.DomainList = DomainList;
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

    public DescribeDomainListResponse() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     * and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public DescribeDomainListResponse(DescribeDomainListResponse source) {
        if (source.DomainCountInfo != null) {
            this.DomainCountInfo = new DomainCountInfo(source.DomainCountInfo);
        }
        if (source.DomainList != null) {
            this.DomainList = new com.tencentcloudapi.dnspod.v20210323.models.DomainListItem[source.DomainList.length];
            for (int i = 0; i < source.DomainList.length; i++) {
                this.DomainList[i] = new DomainListItem(source.DomainList[i]);
            }
        }
        if (source.RequestId != null) {
            this.RequestId = new String(source.RequestId);
        }
    }


    /**
     * Internal implementation, normal users should not use it.
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamObj(map, prefix + "DomainCountInfo.", this.DomainCountInfo);
        this.setParamArrayObj(map, prefix + "DomainList.", this.DomainList);
        this.setParamSimple(map, prefix + "RequestId", this.RequestId);

    }
}


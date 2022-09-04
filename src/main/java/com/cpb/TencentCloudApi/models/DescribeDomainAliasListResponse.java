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
import com.tencentcloudapi.dnspod.v20210323.models.DomainAliasInfo;

import java.util.HashMap;

public class DescribeDomainAliasListResponse extends AbstractModel {

    /**
     * 域名别名列表
     */
    @SerializedName("DomainAliasList")
    @Expose
    private com.tencentcloudapi.dnspod.v20210323.models.DomainAliasInfo[] DomainAliasList;

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    @SerializedName("RequestId")
    @Expose
    private String RequestId;

    /**
     * Get 域名别名列表
     *
     * @return DomainAliasList 域名别名列表
     */
    public com.tencentcloudapi.dnspod.v20210323.models.DomainAliasInfo[] getDomainAliasList() {
        return this.DomainAliasList;
    }

    /**
     * Set 域名别名列表
     *
     * @param DomainAliasList 域名别名列表
     */
    public void setDomainAliasList(com.tencentcloudapi.dnspod.v20210323.models.DomainAliasInfo[] DomainAliasList) {
        this.DomainAliasList = DomainAliasList;
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

    public DescribeDomainAliasListResponse() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     * and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public DescribeDomainAliasListResponse(DescribeDomainAliasListResponse source) {
        if (source.DomainAliasList != null) {
            this.DomainAliasList = new com.tencentcloudapi.dnspod.v20210323.models.DomainAliasInfo[source.DomainAliasList.length];
            for (int i = 0; i < source.DomainAliasList.length; i++) {
                this.DomainAliasList[i] = new DomainAliasInfo(source.DomainAliasList[i]);
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
        this.setParamArrayObj(map, prefix + "DomainAliasList.", this.DomainAliasList);
        this.setParamSimple(map, prefix + "RequestId", this.RequestId);

    }
}


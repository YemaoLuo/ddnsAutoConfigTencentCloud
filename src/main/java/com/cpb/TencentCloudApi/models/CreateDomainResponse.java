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
import com.tencentcloudapi.dnspod.v20210323.models.DomainCreateInfo;

import java.util.HashMap;

public class CreateDomainResponse extends AbstractModel {

    /**
     * 域名信息
     */
    @SerializedName("DomainInfo")
    @Expose
    private com.tencentcloudapi.dnspod.v20210323.models.DomainCreateInfo DomainInfo;

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    @SerializedName("RequestId")
    @Expose
    private String RequestId;

    /**
     * Get 域名信息
     *
     * @return DomainInfo 域名信息
     */
    public com.tencentcloudapi.dnspod.v20210323.models.DomainCreateInfo getDomainInfo() {
        return this.DomainInfo;
    }

    /**
     * Set 域名信息
     *
     * @param DomainInfo 域名信息
     */
    public void setDomainInfo(com.tencentcloudapi.dnspod.v20210323.models.DomainCreateInfo DomainInfo) {
        this.DomainInfo = DomainInfo;
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

    public CreateDomainResponse() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     * and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public CreateDomainResponse(CreateDomainResponse source) {
        if (source.DomainInfo != null) {
            this.DomainInfo = new DomainCreateInfo(source.DomainInfo);
        }
        if (source.RequestId != null) {
            this.RequestId = new String(source.RequestId);
        }
    }


    /**
     * Internal implementation, normal users should not use it.
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamObj(map, prefix + "DomainInfo.", this.DomainInfo);
        this.setParamSimple(map, prefix + "RequestId", this.RequestId);

    }
}

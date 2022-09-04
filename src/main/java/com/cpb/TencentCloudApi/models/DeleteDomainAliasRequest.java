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

public class DeleteDomainAliasRequest extends AbstractModel {

    /**
     * 域名别名ID
     */
    @SerializedName("DomainAliasId")
    @Expose
    private Long DomainAliasId;

    /**
     * 域名
     */
    @SerializedName("Domain")
    @Expose
    private String Domain;

    /**
     * 域名ID，参数 DomainId 优先级比参数 Domain 高，如果传递参数 DomainId 将忽略参数 Domain
     */
    @SerializedName("DomainId")
    @Expose
    private Long DomainId;

    /**
     * Get 域名别名ID
     *
     * @return DomainAliasId 域名别名ID
     */
    public Long getDomainAliasId() {
        return this.DomainAliasId;
    }

    /**
     * Set 域名别名ID
     *
     * @param DomainAliasId 域名别名ID
     */
    public void setDomainAliasId(Long DomainAliasId) {
        this.DomainAliasId = DomainAliasId;
    }

    /**
     * Get 域名
     *
     * @return Domain 域名
     */
    public String getDomain() {
        return this.Domain;
    }

    /**
     * Set 域名
     *
     * @param Domain 域名
     */
    public void setDomain(String Domain) {
        this.Domain = Domain;
    }

    /**
     * Get 域名ID，参数 DomainId 优先级比参数 Domain 高，如果传递参数 DomainId 将忽略参数 Domain
     *
     * @return DomainId 域名ID，参数 DomainId 优先级比参数 Domain 高，如果传递参数 DomainId 将忽略参数 Domain
     */
    public Long getDomainId() {
        return this.DomainId;
    }

    /**
     * Set 域名ID，参数 DomainId 优先级比参数 Domain 高，如果传递参数 DomainId 将忽略参数 Domain
     *
     * @param DomainId 域名ID，参数 DomainId 优先级比参数 Domain 高，如果传递参数 DomainId 将忽略参数 Domain
     */
    public void setDomainId(Long DomainId) {
        this.DomainId = DomainId;
    }

    public DeleteDomainAliasRequest() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     * and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public DeleteDomainAliasRequest(DeleteDomainAliasRequest source) {
        if (source.DomainAliasId != null) {
            this.DomainAliasId = new Long(source.DomainAliasId);
        }
        if (source.Domain != null) {
            this.Domain = new String(source.Domain);
        }
        if (source.DomainId != null) {
            this.DomainId = new Long(source.DomainId);
        }
    }


    /**
     * Internal implementation, normal users should not use it.
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamSimple(map, prefix + "DomainAliasId", this.DomainAliasId);
        this.setParamSimple(map, prefix + "Domain", this.Domain);
        this.setParamSimple(map, prefix + "DomainId", this.DomainId);

    }
}

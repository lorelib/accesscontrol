package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.stereotype.ValueObject;

import javax.validation.constraints.Min;

/**
 * 公司信息
 * Created by listening on 2017/3/22.
 */
public final class CompanyInfo implements ValueObject {
    /**
     * 所属产品code
     */
    @Min(value = 1, message = "产品code为空")
    protected int productCode;

    /**
     * 所属组织机构ID
     */
    @Min(value = 1, message = "公司ID为空")
    protected int companyId;

    public CompanyInfo(int productCode, int companyId) {
        this.productCode = productCode;
        this.companyId = companyId;
    }
}

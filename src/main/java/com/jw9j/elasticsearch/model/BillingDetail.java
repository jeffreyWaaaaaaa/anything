package com.jw9j.elasticsearch.model;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.search.DocValueFormat;
import org.joda.time.DateTime;

@Getter
@Setter
public class BillingDetail
{
    /// <summary>
    /// Gets or sets 账单明细Id.
    /// </summary>
    public String  DetailId;

    /// <summary>
    /// Gets or sets 供应商来源.
    /// </summary>
    public String  ProviderId;

    /// <summary>
    /// Gets or sets 供应商名称.
    /// </summary>
    public String  ProviderName;

    /// <summary>
    /// Gets or sets CloudAccount.
    /// </summary>
    public String  CloudAccount;

    /// <summary>
    /// Gets or sets SubAccount.
    /// </summary>
    public String  SubAccount;

    /// <summary>
    /// Gets or sets ResourceName.
    /// </summary>
    public String  ResourceGroupName;

    /// <summary>
    /// Gets or sets 项目Id.
    /// </summary>
    public String  ProjectId;

    /// <summary>
    /// Gets or sets 项目名称.
    /// </summary>
    public String  ProjectName;

    /// <summary>
    /// Gets or sets 账单Id.
    /// </summary>
    public String  BillingId;

    /// <summary>
    /// Gets or sets 账单明细时间.
    /// </summary>
    public String BillingDate;

    /// <summary>
    /// Gets or sets 账单明细产品.
    /// </summary>
    public String  BillingProduct;

    /// <summary>
    /// Gets or sets 账单明细产品类别.
    /// </summary>
    public String  BillingProductCategory;

    /// <summary>
    /// Gets or sets billingProductCode.
    /// </summary>
    public String  BillingProductCode;

    /// <summary>
    /// Gets or sets billingSeller.
    /// </summary>
    public String  BillingSeller;

    /// <summary>
    /// Gets or sets consumedService.
    /// </summary>
    public String  ConsumedService;

    /// <summary>
    /// Gets or sets 账单明细费用.
    /// </summary>
    public float BillingCost;

    /// <summary>
    /// Gets or sets ResourceGroupId when ProviderSource in (azure , ali) or LinkAccountId when ProviderSource is aws.
    /// </summary>
    public String  ResourceGroupId;

    public String  TenantId;


}

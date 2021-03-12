package com.github.songxzj.wxpay.v3.bean.request.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 主体类型
 */
@Getter
@AllArgsConstructor
public enum OrganizationTypeEnum {

    /**
     * 小微商户，指无营业执照的个人商家。
     */
    SMALL_AND_MICRO_MERCHANTS("2401"),

    /**
     * 个人卖家，指无营业执照，已持续从事电子商务经营活动满6个月，且期间经营收入累计超过20万元的个人商家。（若选择该主体，请在“补充说明”填写相关描述）
     */
    INDIVIDUAL_SELLER("2500"),

    /**
     * 个体工商户，营业执照上的主体类型一般为个体户、个体工商户、个体经营。
     */
    INDIVIDUAL_INDUSTRIAL_AND_COMMERCIAL_HOUSEHOLDS("4"),

    /**
     * 企业，营业执照上的主体类型一般为有限公司、有限责任公司。
     */
    ENTERPRISE("2"),
    /**
     * 党政、机关及事业单位，包括国内各级、各类政府机构、事业单位等（如：公安、党 团、司法、交通、旅游、工商税务、市政、医疗、教育、学校等机构）。
     */
    PARTY_AND_GOVERNMENT("3"),

    /**
     * 其他组织，不属于企业、政府/事业单位的组织机构（如社会团体、民办非企业、基 金会），要求机构已办理组织机构代码证。
     */
    OTHER_ORGANIZATIONS("1708"),

    ;

    private final String typeCode;
}

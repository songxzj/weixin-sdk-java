package com.github.songxzj.wxpay.v3.bean.request.applyment;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.applyment.enums.IDDocTypeEnum;
import com.github.songxzj.wxpay.v3.bean.request.applyment.enums.SalesScenesTypeEnum;
import com.github.songxzj.wxpay.v3.bean.request.applyment.enums.SubjectTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.applyment.WxApplymentSubResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * 提交申请单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/applyment4sub/chapter3_1.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentSubRequest extends BaseWxPayV3Request<WxApplymentSubResult> {
    private static final long serialVersionUID = -1025236917297379236L;

    /**
     * 业务申请编号
     * business_code
     * string(124)
     * 是
     */
    @Required
    @SerializedName("business_code")
    private String businessCode;

    /**
     * 超级管理员信息
     * contact_info
     * object
     * 是
     */
    @Required
    @SerializedName("contact_info")
    private ContactInfo contactInfo;

    /**
     * 主体资料
     * subject_info	object
     * 是
     */
    @Required
    @SerializedName("subject_info")
    private SubjectInfo subjectInfo;

    /**
     * 经营资料
     * business_info
     * object
     * 是
     */
    @Required
    @SerializedName("business_info")
    private BusinessInfo businessInfo;

    /**
     * 结算规则
     * settlement_info
     * object
     * 是
     */
    @Required
    @SerializedName("settlement_info")
    private SettlementInfo settlementInfo;

    /**
     * 结算银行账户
     * bank_account_info
     * object
     */
    @SerializedName("bank_account_info")
    private BankAccountInfo bankAccountInfo;

    /**
     * 补充材料
     * addition_info
     * object
     * 否
     */
    @SerializedName("addition_info")
    private AdditionInfo additionInfo;


    @Override
    public String routing() {
        return "/v3/applyment4sub/applyment/";
    }

    @Override
    public Class<WxApplymentSubResult> getResultClass() {
        return WxApplymentSubResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.contactInfo != null) {
            this.contactInfo.checkConstraints();
        }
        if (this.subjectInfo != null) {
            this.subjectInfo.checkConstraints();
        }
        if (this.businessInfo != null) {
            this.businessInfo.checkConstraints();
        }
        if (this.settlementInfo != null) {
            this.settlementInfo.checkConstraints();
        }
        if (this.bankAccountInfo != null) {
            this.bankAccountInfo.checkConstraints();
        }
        if (this.additionInfo != null) {
            this.additionInfo.checkConstraints();
        }
    }

    /**
     * 超级管理员信息
     * 超级管理员需在开户后进行签约，并接收日常重要管理信息和进行资金操作，请确定其为商户法定代表人或负责人。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactInfo extends BaseV3Inner {
        private static final long serialVersionUID = -8538158677810051141L;

        /**
         * 超级管理员姓名
         * contact_name
         * string(2048)
         * 是
         */
        @Required
        @SerializedName("contact_name")
        private String contactName;

        /**
         * 超级管理员身份证件号码
         * contact_id_number
         * string(2048)
         */
        @SerializedName("contact_id_number")
        private String contactIdNumber;

        /**
         * 超级管理员微信openid
         * openid
         * string(128)
         */
        @SerializedName("openid")
        private String openid;

        /**
         * 联系手机
         * mobile_phone
         * string(2048)
         * 是
         */
        @Required
        @SerializedName("mobile_phone")
        private String mobilePhone;


        /**
         * 联系邮箱
         * contact_email
         * string(2048)
         * 是
         */
        @Required
        @SerializedName("contact_email")
        private String contactEmail;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.contactIdNumber) == StringUtils.isBlank(this.openid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "超级管理员身份证号码 与 超级管理员微信openid，二选一必填");
            }

        }
    }


    /**
     * 结算规则
     * 请填写商家的结算费率规则、特殊资质等信息。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SettlementInfo extends BaseV3Inner {
        private static final long serialVersionUID = -2042715669948059183L;
        public static final String DEFAULT_ACTIVITIES_ID = "20191030111cff5b5e";


        /**
         * 入驻结算规则ID
         * settlement_id
         * string
         * 是
         */
        @Required
        @SerializedName("settlement_id")
        private String settlementId;

        /**
         * 所属行业
         * qualification_type
         * string
         * 是
         */
        @Required
        @SerializedName("qualification_type")
        private String qualificationType;

        /**
         * 特殊资质图片
         * qualifications
         * string(1280)
         */
        @SerializedName("qualifications")
        private List<String> qualifications;

        /**
         * 优惠费率活动ID
         * activities_id
         * string
         * 否
         */
        @SerializedName("activities_id")
        private String activitiesId;

        /**
         * 优惠费率活动值
         * activities_rate
         * string(50)
         * 否
         */
        @SerializedName("activities_rate")
        private String activitiesRate;

        /**
         * 优惠费率活动补充材料
         * activities_additions
         * string(1024)
         * 否
         */
        @SerializedName("activities_additions")
        private List<String> activitiesAdditions;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 补充材料
     * 根据实际审核情况，额外要求商家提供指定的补充资料。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdditionInfo extends BaseV3Inner {
        private static final long serialVersionUID = 218786077047813952L;

        /**
         * 法人开户承诺函
         * legal_person_commitment
         * string
         * 否
         */
        @SerializedName("legal_person_commitment")
        private String legalPersonCommitment;

        /**
         * 法人开户意愿视频
         * legal_person_video
         * string
         * 否
         */
        @SerializedName("legal_person_video")
        private String legalPersonVideo;

        /**
         * 补充材料
         * business_addition_pics
         * string(1280)
         * 否
         */
        @SerializedName("business_addition_pics")
        private List<String> businessAdditionPics;

        /**
         * 补充说明
         * business_addition_msg
         * string(512)
         * 否
         */
        @SerializedName("business_addition_msg")
        private String businessAdditionMsg;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 结算银行账户
     * 1、请填写商家提现收款的银行账户信息。
     * 2、若结算规则id为“719、721、716、717、730、739、727、738、726”，可选填结算账户。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BankAccountInfo extends BaseV3Inner {
        private static final long serialVersionUID = -1561772828453300867L;


        /**
         * 账户类型
         * bank_account_type
         * enum
         * 是
         */
        @Required
        @SerializedName("bank_account_type")
        private String bankAccountType;

        /**
         * 开户名称
         * account_name
         * string(2048)
         * 是
         */
        @Required
        @SerializedName("account_name")
        private String accountName;

        /**
         * 开户银行
         * account_bank
         * string(128)
         * 是
         */
        @Required
        @SerializedName("account_bank")
        private String accountBank;

        /**
         * 开户银行省市编码
         * bank_address_code
         * string(128)
         * 是
         */
        @Required
        @SerializedName("bank_address_code")
        private String bankAddressCode;


        /**
         * 开户银行联行号
         * bank_branch_id
         * string(128)
         */
        @SerializedName("bank_branch_id")
        private String bankBranchId;

        /**
         * 开户银行全称（含支行)
         * bank_name
         * string(128)
         */
        @SerializedName("bank_name")
        private String bankName;

        /**
         * 银行账号
         * account_number
         * string(2048)
         * 是
         */
        @Required
        @SerializedName("account_number")
        private String accountNumber;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 经营资料
     * query请填写商家的经营业务信息、售卖商品/提供服务场景信息。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessInfo extends BaseV3Inner {
        private static final long serialVersionUID = -6823350069817058692L;


        /**
         * 商户简称
         * merchant_shortname
         * string(64)
         * 是
         */
        @Required
        @SerializedName("merchant_shortname")
        private String merchantShortname;

        /**
         * 客服电话
         * service_phone
         * string(32)
         * 是
         */
        @Required
        @SerializedName("service_phone")
        private String servicePhone;

        /**
         * 经营场景
         * sales_info
         * object
         * 是
         */
        @Required
        @SerializedName("sales_info")
        private SalesInfo salesInfo;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.salesInfo != null) {
                this.salesInfo.checkConstraints();
            }
        }
    }

    /**
     * 经营场景
     * 请根据实际经营情况，填写经营场景
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SalesInfo extends BaseV3Inner {
        private static final long serialVersionUID = -3109479622358133073L;


        /**
         * 经营场景类型
         * sales_scenes_type
         * enum
         * 是
         */
        @Required
        @SerializedName("sales_scenes_type")
        private List<String> salesScenesTypes;

        /**
         * 线下门店场景
         * biz_store_info
         * object
         */
        @SerializedName("biz_store_info")
        private BizStoreInfo bizStoreInfo;

        /**
         * 公众号场景
         * mp_info
         * object
         */
        @SerializedName("mp_info")
        private MpInfo mpInfo;

        /**
         * 小程序场景
         * mini_program_info
         * object
         */
        @SerializedName("mini_program_info")
        private MiniProgramInfo miniProgramInfo;

        /**
         * APP场景
         * app_info
         * object
         */
        @SerializedName("app_info")
        private AppInfo appInfo;

        /**
         * 互联网网站场景
         * web_info
         * object
         */
        @SerializedName("web_info")
        private WebInfo webInfo;

        /**
         * 企业微信场景
         * wework_info
         * object
         */
        @SerializedName("wework_info")
        private WeworkInfo weworkInfo;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_STORE.name()) && this.bizStoreInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择“SALES_SCENES_STORE“，线下门店场景必填");
            }
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_MP.name()) && this.mpInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择”SALES_SCENES_MP“，公众号场景必填");
            }
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_MINI_PROGRAM.name()) && this.miniProgramInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择”SALES_SCENES_MINI_PROGRAM“，小程序场景必填");
            }
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_APP.name()) && this.appInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择”SALES_SCENES_APP“，APP场景必填");
            }
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_WEB.name()) && this.webInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择”SALES_SCENES_WEB“，互联网网站场景必填");
            }
            if (this.salesScenesTypes.contains(SalesScenesTypeEnum.SALES_SCENES_WEWORK.name()) && this.weworkInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当“经营场景类型“选择”SALES_SCENES_WEWORK“，企业微信场景必填");
            }
            if (this.bizStoreInfo != null) {
                this.bizStoreInfo.checkConstraints();
            }
            if (this.mpInfo != null) {
                this.mpInfo.checkConstraints();
            }
            if (this.miniProgramInfo != null) {
                this.miniProgramInfo.checkConstraints();
            }

            if (this.appInfo != null) {
                this.appInfo.checkConstraints();
            }

            if (this.webInfo != null) {
                this.webInfo.checkConstraints();
            }
            if (this.weworkInfo != null) {
                this.weworkInfo.checkConstraints();
            }
        }
    }


    /**
     * 主体资料
     * 请填写商家的营业执照/登记证书、经营者/法人的证件等信息。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubjectInfo extends BaseV3Inner {
        private static final long serialVersionUID = 4142293335799954435L;

        /**
         * 主体类型
         * subject_type
         * string(32)
         * 是
         */
        @Required
        @SerializedName("subject_type")
        private String subjectType;

        /**
         * 营业执照
         * business_license_info
         * object
         */
        @SerializedName("business_license_info")
        private BusinessLicenseInfo businessLicenseInfo;

        /**
         * 登记证书
         * certificate_info
         * object
         */
        @SerializedName("certificate_info")
        private CertificateInfo certificateInfo;

        /**
         * 组织机构代码证
         * organization_info
         * object
         */
        @SerializedName("organization_info")
        private OrganizationInfo organizationInfo;

        /**
         * 单位证明函照片
         * certificate_letter_copy
         * string(255)
         */
        @SerializedName("certificate_letter_copy")
        private String certificateLetterCopy;


        /**
         * 经营者/法人身份证件
         * identity_info
         * object
         */
        @Required
        @SerializedName("identity_info")
        private IdentityInfo identityInfo;


        /**
         * 最终受益人信息(UBO)
         * ubo_info
         * object
         */
        @SerializedName("ubo_info")
        private UboInfo uboInfo;


        @Override
        public void checkConstraints() throws WxErrorException {
            if ((SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL.name().equals(this.subjectType) || SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE.name().equals(this.subjectType)) && this.businessLicenseInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体为个体户/企业，营业执照必填");
            }
            if ((SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS.name().equals(this.subjectType) || SubjectTypeEnum.SUBJECT_TYPE_OTHERS.name().equals(this.subjectType)) && this.certificateInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体为党政、机关及事业单位/其他组织，登记证书必填");
            }
            if (SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS.name().equals(this.subjectType) && StringUtils.isBlank(this.certificateLetterCopy)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为党政、机关及事业单位，单位证明函照片必填");
            }
            if (!this.identityInfo.getOwner() && this.uboInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "若经营者/法人不是最终受益所有人，则需提填写受益所有人信息");
            }
            if (this.businessLicenseInfo != null) {
                this.businessLicenseInfo.checkConstraints();
            }
            if (this.certificateInfo != null) {
                this.certificateInfo.checkConstraints();
            }
            if (this.organizationInfo != null) {
                this.organizationInfo.checkConstraints();
            }
            if (this.identityInfo != null) {
                this.identityInfo.checkConstraints();
            }
            if (this.uboInfo != null) {
                this.uboInfo.checkConstraints();
            }
        }

    }

    /**
     * 营业执照
     * 条件选填	1、主体为个体户/企业，必填。
     * 2、请上传“营业执照”，需年检章齐全，当年注册除外。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessLicenseInfo extends BaseV3Inner {
        private static final long serialVersionUID = -3499012665128533704L;

        /**
         * 营业执照照片
         * license_copy	string(255)
         * 是
         */
        @Required
        @SerializedName("license_copy")
        private String licenseCopy;

        /**
         * 注册号/统一社会信用代码
         * license_number
         * string(32)
         * 是
         */
        @Required
        @SerializedName("license_number")
        private String licenseNumber;

        /**
         * 商户名称
         * merchant_name
         * string(128)
         * 是
         */
        @Required
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 个体户经营者/法人姓名
         * legal_person
         * string(64)
         * 是
         */
        @Required
        @SerializedName("legal_person")
        private String legalPerson;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 登记证书
     * 条件选填 主体为党政、机关及事业单位/其他组织，必填。
     * 1、党政、机关及事业单位：请上传相关部门颁发的证书，如：事业单位法人证书、统一社会信用代码证书。
     * 2、其他组织：请上传相关部门颁发的证书，如：社会团体法人登记证书、民办非企业单位登记证书、基金会法人登记证书。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CertificateInfo extends BaseV3Inner {
        private static final long serialVersionUID = 8767879736448835703L;

        /**
         * 登记证书照片
         * cert_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("cert_copy")
        private String certCopy;

        /**
         * 登记证书类型
         * cert_type
         * enum
         * 是
         */
        @Required
        @SerializedName("cert_type")
        private String certType;

        /**
         * 证书号
         * cert_number
         * string(32)
         * 是
         */
        @Required
        @SerializedName("cert_number")
        private String certNumber;

        /**
         * 商户名称
         * merchant_name
         * string(128)
         * 是
         */
        @Required
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 注册地址
         * company_address
         * string(128)
         * 是
         */
        @Required
        @SerializedName("company_address")
        private String companyAddress;

        /**
         * 法人姓名
         * legal_person
         * string(64)
         */
        @Required
        @SerializedName("legal_person")
        private String legalPerson;

        /**
         * 有效期限开始日期
         * period_begin
         * string(128)
         * 是
         */
        @Required
        @SerializedName("period_begin")
        private String periodBegin;

        /**
         * 有效期限结束日期
         * period_end
         * string(128)
         * 是
         */
        @Required
        @SerializedName("period_end")
        private String periodEnd;


        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }


    /**
     * 经营者/法人身份证件
     * 1、个体户：请上传经营者的身份证件。
     * 2、企业/党政、机关及事业单位/其他组织：请上传法人的身份证件。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdentityInfo extends BaseV3Inner {
        private static final long serialVersionUID = -985545099597198929L;


        /**
         * 证件类型
         * id_doc_type
         * enum
         * 是
         */
        @Required
        @SerializedName("id_doc_type")
        private String idDocType;

        /**
         * 身份证信息
         * id_card_info
         * object
         * 否
         */
        @SerializedName("id_card_info")
        private IDCardInfo idCardInfo;

        /**
         * 其他类型证件信息
         * id_doc_info
         * object
         */
        @SerializedName("id_doc_info")
        private IDDocInfo idDocInfo;

        /**
         * 经营者/法人是否为受益人
         * owner
         * bool
         * 是
         */
        @Required
        @SerializedName("owner")
        private Boolean owner;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (IDDocTypeEnum.IDENTIFICATION_TYPE_IDCARD.name().equals(this.idDocType) && this.idCardInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "证件类型为“身份证”时 身份证信息必填");
            }
            if (!IDDocTypeEnum.IDENTIFICATION_TYPE_IDCARD.name().equals(this.idDocType) && this.idDocInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "证件类型为“来往内地通行证、来往大陆通行证、护照”时 其他类型证件信息必填");
            }
            if (this.idCardInfo != null) {
                this.idCardInfo.checkConstraints();
            }
            if (this.idDocInfo != null) {
                this.idDocInfo.checkConstraints();
            }

        }
    }


    /**
     * 组织机构代码证
     * 条件选填	主体为企业/党政、机关及事业单位/其他组织，且证件号码不是18位时必填。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrganizationInfo extends BaseV3Inner {
        private static final long serialVersionUID = 2865604284651620832L;


        /**
         * 组织机构代码证照片
         * organization_copy
         * string(256)
         * 是
         */
        @Required
        @SerializedName("organization_copy")
        private String organizationCopy;

        /**
         * 组织机构代码
         * organization_code
         * string(32)
         * 是
         */
        @Required
        @SerializedName("organization_code")
        private String organizationCode;

        /**
         * 组织机构代码证有效期开始日期
         * org_period_begin
         * string(128)
         * 是
         */
        @Required
        @SerializedName("org_period_begin")
        private String orgPeriodBegin;

        /**
         * 组织机构代码证有效期结束日期
         * org_period_end
         * string(128)
         * 是
         */
        @Required
        @SerializedName("org_period_end")
        private String orgPeriodEnd;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 最终受益人信息(UBO)
     * 经营者/法人不是最终受益所有人，则需提填写受益所有人信息。
     * 根据国家相关法律法规，需要提供公司受益所有人信息，受益所有人需符合至少以下条件之一：
     * 1、直接或者间接拥有超过25%公司股权或者表决权的自然人。
     * 2、通过人事、财务等其他方式对公司进行控制的自然人。
     * 3、公司的高级管理人员，包括公司的经理、副经理、财务负责人、上市公司董事会秘书和公司章程规定的其他人员。
     */

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UboInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5110805206262783255L;


        /**
         * 证件类型
         * id_type
         * enum
         * 是
         */
        @Required
        @SerializedName("id_type")
        private String idType;

        /**
         * 身份证人像面照片
         * id_card_copy
         * string(256)
         */
        @SerializedName("id_card_copy")
        private String idCardCopy;


        /**
         * 身份证国徽面照片
         * id_card_national
         * string(256)
         */
        @SerializedName("id_card_national")
        private String idCardNational;


        /**
         * 证件照片
         * id_doc_copy
         * string(256)
         */
        @SerializedName("id_doc_copy")
        private String idDocCopy;

        /**
         * 受益人姓名
         * name
         * string
         * 是
         */
        @Required
        @SerializedName("name")
        private String name;


        /**
         * 证件号码
         * id_number
         * string(128)
         * 是
         */
        @Required
        @SerializedName("id_number")
        private String idNumber;


        /**
         * 证件有效期开始时间
         * id_period_begin
         * string(128)
         * 是
         */
        @Required
        @SerializedName("id_period_begin")
        private String idPeriodBegin;

        /**
         * 证件有效期结束时间
         * id_period_end
         * string(128)
         * 是
         */
        @Required
        @SerializedName("id_period_end")
        private String idPeriodEnd;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (IDDocTypeEnum.IDENTIFICATION_TYPE_IDCARD.name().equals(this.idType) && StringUtils.isBlank(this.idCardCopy)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "受益人的证件类型为“身份证”时，上传身份证人像面照片");
            }
            if (IDDocTypeEnum.IDENTIFICATION_TYPE_IDCARD.name().equals(this.idType) && StringUtils.isBlank(this.idCardNational)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "受益人的证件类型为“身份证”时，上传身份证国徽面照片");
            }
            if (!IDDocTypeEnum.IDENTIFICATION_TYPE_IDCARD.name().equals(this.idType) && StringUtils.isBlank(this.idDocCopy)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "受益人的证件类型为“来往内地通行证、来往大陆通行证、护照”时，上传证件照片");
            }

        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BizStoreInfo extends BaseV3Inner {
        private static final long serialVersionUID = -1208786067401233225L;

        /**
         * 门店名称
         * biz_store_name
         * string(128)
         * 是
         */
        @Required
        @SerializedName("biz_store_name")
        private String bizStoreName;

        /**
         * 门店省市编码
         * biz_address_code
         * string(128)
         * 是
         */
        @Required
        @SerializedName("biz_address_code")
        private String bizAddressCode;

        /**
         * 门店地址
         * biz_store_address
         * string(128)
         * 是
         */
        @Required
        @SerializedName("biz_store_address")
        private String bizStoreAddress;

        /**
         * 门店门头照片
         * store_entrance_pic
         * string(1024)
         * 是
         */
        @Required
        @SerializedName("store_entrance_pic")
        private List<String> storeEntrancePics;

        /**
         * 店内环境照片
         * indoor_pic
         * string(1024)
         * 是
         */
        @Required
        @SerializedName("indoor_pic")
        private List<String> indoorPics;

        /**
         * 线下场所对应的商家APPID
         * biz_sub_appid
         * string(256)
         * 否
         */
        @SerializedName("biz_sub_appid")
        private String bizSubAppid;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MpInfo extends BaseV3Inner {
        private static final long serialVersionUID = 8610586534860805485L;

        /**
         * 服务商公众号APPID
         * mp_appid
         * string(256)
         */
        @SerializedName("mp_appid")
        private String mpAppid;

        /**
         * 商家公众号APPID
         * mp_sub_appid
         * string(256)
         */
        @SerializedName("mp_sub_appid")
        private String mpSubAppid;

        /**
         * 公众号页面截图
         * mp_pics
         * string(1024)
         */
        @SerializedName("mp_pics")
        private List<String> mpPics;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.mpAppid) == StringUtils.isBlank(this.mpSubAppid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "服务商公众号APPID与商家公众号APPID，二选一必填");
            }
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MiniProgramInfo extends BaseV3Inner {
        private static final long serialVersionUID = 8793927050501798100L;

        /**
         * 服务商小程序APPID
         * mini_program_appid
         * string(256)
         */
        @SerializedName("mini_program_appid")
        private String miniProgramAppid;

        /**
         * 商家小程序APPID
         * mini_program_sub_appid
         * string(256)
         */
        @SerializedName("mini_program_sub_appid")
        private String miniProgramSubAppid;

        /**
         * 小程序截图
         * mini_program_pics
         * string(1024)
         */
        @SerializedName("mini_program_pics")
        private List<String> miniProgramPics;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.miniProgramAppid) == StringUtils.isBlank(this.miniProgramSubAppid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "服务商小程序APPID与商家小程序APPID，二选一必填");
            }
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AppInfo extends BaseV3Inner {
        private static final long serialVersionUID = 9055687654190634738L;

        /**
         * 服务商应用APPID
         * app_appid
         * string(256)
         */
        @SerializedName("app_appid")
        private String appAppid;

        /**
         * 商家应用APPID
         * app_sub_appid
         * string(256)
         */
        @SerializedName("app_sub_appid")
        private String appSubAppid;

        /**
         * APP截图
         * app_pics
         * string(1024)
         * 是
         */
        @Required
        @SerializedName("app_pics")
        private List<String> appPics;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.appAppid) == StringUtils.isBlank(this.appSubAppid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "服务商应用APPID与商家应用APPID，二选一必填");
            }
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WebInfo extends BaseV3Inner {
        private static final long serialVersionUID = 8662657918354298798L;

        /**
         * 互联网网站域名
         * domain
         * string(1024)
         * 是
         */
        @Required
        @SerializedName("domain")
        private String domain;

        /**
         * 网站授权函
         * web_authorisation
         * string(1024)
         * 否
         */
        @SerializedName("web_authorisation")
        private String webAuthorisation;

        /**
         * 互联网网站对应的商家APPID
         * web_appid
         * string(256)
         * 否
         */
        @SerializedName("web_appid")
        private String webAppid;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeworkInfo extends BaseV3Inner {
        private static final long serialVersionUID = 2354161307972018089L;

        /**
         * 商家企业微信CorpID
         * sub_corp_id
         * string(256)	是
         */
        @Required
        @SerializedName("sub_corp_id")
        private String subCorpId;

        /**
         * 企业微信页面截图
         * wework_pics
         * string(1024)
         * 是
         */
        @Required
        @SerializedName("wework_pics")
        private List<String> weworkPics;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IDCardInfo extends BaseV3Inner {
        private static final long serialVersionUID = -4309990580461697098L;

        /**
         * 身份证人像面照片
         * id_card_copy
         * string(256)
         * 是
         */
        @Required
        @SerializedName("id_card_copy")
        private String idCardCopy;

        /**
         * 身份证国徽面照片
         * id_card_national
         * string(256)
         * 是
         */
        @Required
        @SerializedName("id_card_national")
        private String idCardNational;

        /**
         * 身份证姓名
         * id_card_name
         * string(256)
         * 是
         */
        @Required
        @SerializedName("id_card_name")
        private String idCardName;


        /**
         * 身份证号码
         * id_card_number
         * string(256)
         * 是
         */
        @Required
        @SerializedName("id_card_number")
        private String idCardNumber;

        /**
         * 身份证有效期开始时间
         * card_period_begin
         * string(128)
         * 是
         */
        @Required
        @SerializedName("card_period_begin")
        private String cardPeriodBegin;

        /**
         * 结束时间
         * card_period_end
         * string(128)
         * 是
         */
        @Required
        @SerializedName("card_period_end")
        private String cardPeriodEnd;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }


    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IDDocInfo extends BaseV3Inner {
        private static final long serialVersionUID = 6214364176836312673L;

        /**
         * 证件照片
         * id_doc_copy
         * string(256)
         * 是
         */
        @Required
        @SerializedName("id_doc_copy")
        private String idDocCopy;

        /**
         * 证件姓名
         * id_doc_name
         * string(128)
         * 是
         */
        @Required
        @SerializedName("id_doc_name")
        private String idDocName;

        /**
         * 证件号码
         * id_doc_number
         * string(128)
         * 是
         */
        @Required
        @SerializedName("id_doc_number")
        private String idDocNumber;


        /**
         * 证件有效期开始时间
         * doc_period_begin
         * string(128)
         * 是
         */
        @Required
        @SerializedName("doc_period_begin")
        private String docPeriodBegin;

        /**
         * 证件有效期结束时间
         * doc_period_end
         * string(128)
         * 是
         */
        @Required
        @SerializedName("doc_period_end")
        private String docPeriodEnd;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }


}

package com.github.songxzj.wxpay.v3.bean.request.ecommerce;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.ecommerce.enums.IDDocTypeEnum;
import com.github.songxzj.wxpay.v3.bean.request.ecommerce.enums.OrganizationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.ecommerce.WxEcommerceApplymentResult;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.05.25
 * 二级商户进件API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_1_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxEcommerceApplymentRequest extends BaseWxPayV3Request<WxEcommerceApplymentResult> {
    private static final long serialVersionUID = 3744512003068895441L;

    /**
     * 业务申请编号
     * out_request_no
     * string[1,124]
     * 是
     */
    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

    /**
     * 主体类型
     * organization_type
     * string[1,4]
     * 是
     */
    @Required
    @SerializedName("organization_type")
    private String organizationType;

    /**
     * 营业执照/登记证书信息
     * business_license_info
     * object
     * 条件选填
     */
    @SerializedName("business_license_info")
    private BusinessLicenseInfo businessLicenseInfo;

    /**
     * 组织机构代码证信息
     * organization_cert_info
     * object
     * 条件选填
     */
    @SerializedName("organization_cert_info")
    private OrganizationCertInfo organizationCertInfo;

    /**
     * 经营者/法人证件类型
     * id_doc_type
     * string[1,64]
     * 否
     */
    @SerializedName("id_doc_type")
    private String idDocType;

    /**
     * 经营者/法人身份证信息
     * id_card_info
     * object
     * 条件选填
     */
    @SensitiveEncrypt
    @SerializedName("id_card_info")
    private IdCardInfo idCardInfo;

    /**
     * 经营者/法人其他类型证件信息
     * id_doc_info
     * object
     * 条件选填
     */
    @SensitiveEncrypt
    @SerializedName("id_doc_info")
    private IdDocInfo idDocInfo;

    /**
     * 是否填写结算银行账户
     * need_account_info
     * bool
     * 是
     */
    @Required
    @SerializedName("need_account_info")
    private Boolean needAccountInfo;

    /**
     * 结算银行账户
     * account_info
     * object
     * 条件选填
     */
    @SerializedName("account_info")
    private AccountInfo accountInfo;

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
     * 店铺信息
     * sales_scene_info
     * object
     * 是
     */
    @Required
    @SerializedName("sales_scene_info")
    private SalesSceneInfo salesSceneInfo;

    /**
     * 商户简称
     * merchant_shortname
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("merchant_shortname")
    private String merchantShortname;

    /**
     * 特殊资质
     * qualifications
     * string[1,1024]
     * 否
     */
    @SerializedName("qualifications")
    private String qualifications;

    /**
     * 补充材料
     * business_addition_pics
     * string[1,1024]
     * 否
     */
    @SerializedName("business_addition_pics")
    private String businessAdditionPics;

    /**
     * 补充说明
     * business_addition_desc
     * string[1,256]
     * 否
     */
    @SerializedName("business_addition_desc")
    private String businessAdditionDesc;

    @Override
    public String routing() {
        return "/v3/ecommerce/applyments/";
    }

    @Override
    public Class<WxEcommerceApplymentResult> getResultClass() {
        return WxEcommerceApplymentResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.businessLicenseInfo != null) {
            this.businessLicenseInfo.checkConstraints();
        }
        if (this.organizationCertInfo != null) {
            this.organizationCertInfo.checkConstraints();
        }
        if (this.idCardInfo != null) {
            this.idCardInfo.checkConstraints();
        }
        if (this.idDocInfo != null) {
            this.idDocInfo.checkConstraints();
        }
        if (this.accountInfo != null) {
            this.accountInfo.checkConstraints();
        }
        if (this.contactInfo != null) {
            this.contactInfo.checkConstraints();
        }
        if (this.salesSceneInfo != null) {
            this.salesSceneInfo.checkConstraints();
        }
        List<String> typeCodeList = Lists.newArrayList(OrganizationTypeEnum.INDIVIDUAL_INDUSTRIAL_AND_COMMERCIAL_HOUSEHOLDS.getTypeCode(),
                OrganizationTypeEnum.ENTERPRISE.getTypeCode(),
                OrganizationTypeEnum.PARTY_AND_GOVERNMENT.getTypeCode(),
                OrganizationTypeEnum.OTHER_ORGANIZATIONS.getTypeCode());
        if (typeCodeList.contains(this.organizationType) && this.businessLicenseInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体为“个体工商户/企业”时，请上传营业执照。主体为“党政、机关及事业单位/其他组织”时，请上传登记证书。");
        }
        boolean isIdCard = (this.idDocType == null || IDDocTypeEnum.IDENTIFICATION_TYPE_MAINLAND_IDCARD.name().equals(this.idDocType));
        if (isIdCard && this.idCardInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "证件类型为“身份证”时请填写经营者/法人的身份证信息");
        }
        if (!isIdCard && this.idDocInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "证件类型为“来往内地通行证、来往大陆通行证、护照”时请填写经营者/法人其他类型证件信息");
        }
        if (this.needAccountInfo && this.accountInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "请填写结算银行账户");
        }
    }


    /**
     * 营业执照/登记证书信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessLicenseInfo extends BaseV3Inner {
        private static final long serialVersionUID = 9209642456326070395L;

        /**
         * 证件扫描件
         * business_license_copy
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("business_license_copy")
        private String businessLicenseCopy;

        /**
         * 证件注册号
         * business_license_number
         * string[15,18]
         * 是
         */
        @Required
        @SerializedName("business_license_number")
        private String businessLicenseNumber;

        /**
         * 商户名称
         * merchant_name
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 经营者/法定代表人姓名
         * legal_person
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("legal_person")
        private String legalPerson;

        /**
         * 注册地址
         * company_address
         * string[1,128]
         * 条件选填
         */
        @SerializedName("company_address")
        private String companyAddress;

        /**
         * 营业期限
         * business_time
         * string[1,256]
         * 条件选填
         */
        @SerializedName("business_time")
        private String businessTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 组织机构代码证信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrganizationCertInfo extends BaseV3Inner {
        private static final long serialVersionUID = -5601890055825094354L;

        /**
         * 组织机构代码证照片
         * organization_copy
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("organization_copy")
        private String organizationCopy;

        /**
         * 组织机构代码
         * organization_number
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("organization_number")
        private String organizationNumber;

        /**
         * 组织机构代码有效期限
         * organization_time
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName(value = "organization_time")
        private String organizationTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 经营者/法人身份证信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdCardInfo extends BaseV3Inner {
        private static final long serialVersionUID = -2888905796079627132L;

        /**
         * 身份证人像面照片
         * id_card_copy
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("id_card_copy")
        private String idCardCopy;

        /**
         * 身份证国徽面照片
         * id_card_national
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("id_card_national")
        private String idCardNational;

        /**
         * 身份证姓名
         * id_card_name
         * string[1,256]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "id_card_name")
        private String idCardName;

        /**
         * 身份证号码
         * id_card_number
         * string[15,18]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("id_card_number")
        private String idCardNumber;

        /**
         * 身份证有效期限
         * id_card_valid_time
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("id_card_valid_time")
        private String idCardValidTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 经营者/法人其他类型证件信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdDocInfo extends BaseV3Inner {
        private static final long serialVersionUID = -7450729270631781303L;

        /**
         * 证件姓名
         * id_doc_name
         * string[1,128]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("id_doc_name")
        private String idDocName;

        /**
         * 证件号码
         * id_doc_number
         * string[1,128]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("id_doc_number")
        private String idDocNumber;

        /**
         * 证件照片
         * id_doc_copy
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("id_doc_copy")
        private String idDocCopy;

        /**
         * 证件结束日期
         * doc_period_end
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName(value = "doc_period_end")
        private String docPeriodEnd;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 结算银行账户
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccountInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5069568381253963456L;

        /**
         * 账户类型
         * bank_account_type
         * string[1,2]
         * 是
         */
        @Required
        @SerializedName(value = "bank_account_type")
        private String bankAccountType;

        /**
         * 开户银行
         * account_bank
         * string[1,10]
         * 是
         */
        @Required
        @SerializedName(value = "account_bank")
        private String accountBank;

        /**
         * 开户名称
         * account_name
         * string[1,128]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "account_name")
        private String accountName;

        /**
         * 开户银行省市编码
         * bank_address_code
         * string[1,12]
         * 是
         */
        @Required
        @SerializedName(value = "bank_address_code")
        private String bankAddressCode;

        /**
         * 开户银行联行号
         * bank_branch_id
         * string[1,64]
         * 条件选填
         */
        @SerializedName(value = "bank_branch_id")
        private String bankBranchId;

        /**
         * 开户银行全称
         * （含支行）
         * bank_name
         * string[1,128]
         * 条件选填
         */
        @SerializedName(value = "bank_name")
        private String bankName;

        /**
         * 银行帐号
         * account_number
         * string[1,128]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "account_number")
        private String accountNumber;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 超级管理员信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactInfo extends BaseV3Inner {
        private static final long serialVersionUID = -8836399084401009853L;

        /**
         * 超级管理员类型
         * contact_type
         * string[1,2]
         * 是
         */
        @Required
        @SerializedName(value = "contact_type")
        private String contactType;

        /**
         * 超级管理员姓名
         * contact_name
         * string[1,256]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "contact_name")
        private String contactName;

        /**
         * 超级管理员身份证件号码
         * contact_id_card_number
         * string[1,256]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "contact_id_card_number")
        private String contactIdCardNumber;

        /**
         * 超级管理员手机
         * mobile_phone
         * string[1,256]
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName(value = "mobile_phone")
        private String mobilePhone;

        /**
         * 超级管理员邮箱
         * contact_email
         * string[1,256]
         * 条件选填
         */
        @SensitiveEncrypt
        @SerializedName(value = "contact_email")
        private String contactEmail;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SalesSceneInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5173205671328958282L;

        /**
         * 店铺名称
         * store_name
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName(value = "store_name")
        private String storeName;

        /**
         * 店铺链接
         * store_url
         * string[1,1024]
         */
        @SerializedName(value = "store_url")
        private String storeUrl;

        /**
         * 店铺二维码
         * store_qr_code
         * string[1,256]
         */
        @SerializedName(value = "store_qr_code")
        private String storeQrCode;


        /**
         * 小程序AppID
         * mini_program_sub_appid
         * string[1,256]
         * 否
         */
        @SerializedName(value = "mini_program_sub_appid")
        private String miniProgramSubAppid;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.storeUrl) == StringUtils.isBlank(this.storeQrCode)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "店铺二维码or店铺链接二选一必填");
            }
        }
    }

    @Override
    public boolean isSensitiveEncrypt() {
        return true;
    }

}


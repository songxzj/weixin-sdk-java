package com.github.songxzj.wxpay.v3.bean.request.applyment;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.applyment.enums.AuthorizeSubjectTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.applyment.WxApplymentAuthorizeSubResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * 商户开户意愿提交申请单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/applysubject/chapter5_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentAuthorizeSubRequest extends BaseWxPayV3Request<WxApplymentAuthorizeSubResult> {
    private static final long serialVersionUID = -1102379109688853899L;


    /**
     * 渠道商户号
     * channel_id
     * string(9)
     * 否
     */
    @SerializedName("channel_id")
    private String channelId;

    /**
     * 业务申请编号
     * business_code
     * string(128)
     * 是
     */
    @Required
    @SerializedName("business_code")
    private String businessCode;

    /**
     * 联系人信息
     * contact_info
     * object
     * 是
     */
    @Required
    @SensitiveEncrypt
    @SerializedName("contact_info")
    private ContactInfo contactInfo;

    /**
     * 主体信息
     * subject_info
     * object
     * 是
     */
    @Required
    @SerializedName("subject_info")
    private SubjectInfo subjectInfo;

    /**
     * 法人身份信息
     * identification_info
     * object
     * 是
     */
    @Required
    @SensitiveEncrypt
    @SerializedName("identification_info")
    private IdentificationInfo identificationInfo;


    @Override
    public String routing() {
        return "/v3/apply4subject/applyment";
    }

    @Override
    public Class<WxApplymentAuthorizeSubResult> getResultClass() {
        return WxApplymentAuthorizeSubResult.class;
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
        if (this.identificationInfo != null) {
            this.identificationInfo.checkConstraints();
        }
    }

    /**
     * 主体信息
     */

    @Setter
@Getter
@ToString
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
         * 营业执照信息
         * business_licence_info
         * object
         */
        @SerializedName("business_licence_info")
        private BusinessLicenceInfo businessLicenceInfo;

        /**
         * 登记证书
         * certificate_info
         * object
         */
        @SerializedName("certificate_info")
        private CertificateInfo certificateInfo;

        /**
         * 单位证明函照片
         * company_prove_copy
         * string(255)
         * 否
         */
        @SerializedName("company_prove_copy")
        private String companyProveCopy;

        /**
         * 辅助证明材料信息
         * assist_prove_info
         * object
         * 否
         */
        @SerializedName("assist_prove_info")
        private AssistProveInfo assistProveInfo;

        /**
         * 经营许可证信息
         * special_operation_info
         * array
         * 否
         */
        @SerializedName("special_operation_info")
        private List<SpecialOperationInfo> specialOperationInfos;


        @Override
        public void checkConstraints() throws WxErrorException {
            if ((AuthorizeSubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL.name().equals(this.subjectType) || AuthorizeSubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE.name().equals(this.subjectType)) && this.businessLicenceInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业或个体户时，营业执照信息必填");
            }
            if ((AuthorizeSubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED.name().equals(this.subjectType) || AuthorizeSubjectTypeEnum.SUBJECT_TYPE_OTHERS.name().equals(this.subjectType)) && this.certificateInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为事业单位或其他组织时，登记证书信息必填");
            }
            if (AuthorizeSubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED.name().equals(this.subjectType) && StringUtils.isBlank(this.companyProveCopy)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为事业单位时，单位证明函照片必填");
            }
            if (AuthorizeSubjectTypeEnum.SUBJECT_TYPE_MICRO.name().equals(this.subjectType) && this.assistProveInfo == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为小微商户时，辅助证明材料信息必填");
            }
            if (this.businessLicenceInfo != null) {
                this.businessLicenceInfo.checkConstraints();
            }
            if (this.certificateInfo != null) {
                this.certificateInfo.checkConstraints();
            }
            if (this.assistProveInfo != null) {
                this.assistProveInfo.checkConstraints();
            }
            if (this.specialOperationInfos != null) {
                for (SpecialOperationInfo specialOperationInfo : this.specialOperationInfos) {
                    specialOperationInfo.checkConstraints();
                }
            }
        }
    }

    /**
     * 经营许可证信息
     * 特殊行业的经营许可证信息
     */

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpecialOperationInfo extends BaseV3Inner {
        private static final long serialVersionUID = 2352980450354506314L;


        /**
         * 行业id
         * category_id
         * uint32
         * 是
         */
        @Required
        @SerializedName("category_id")
        private String categoryId;

        /**
         * 店内环境照片
         * store_indoor_copy
         * array
         * 否
         */
        @SerializedName("store_indoor_copy")
        private List<String> storeIndoorCopys;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 辅助证明材料信息
     * 主体类型为小微商户时，辅助证明材料信息必填。
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AssistProveInfo extends BaseV3Inner {
        private static final long serialVersionUID = 3012866869744162059L;

        /**
         * 小微经营类型
         * micro_biz_type
         * enum
         * 是
         */
        @Required
        @SerializedName("micro_biz_type")
        private String microBizType;

        /**
         * 门店名称
         * store_name
         * string(128)
         * 是
         */
        @Required
        @SerializedName("store_name")
        private String storeName;

        /**
         * 门店省市编码
         * store_address_code
         * string(16)
         * 是
         */
        @Required
        @SerializedName("store_address_code")
        private String storeAddressCode;

        /**
         * 门店地址
         * store_address
         * string(128)
         * 是
         */
        @Required
        @SerializedName("store_address")
        private String storeAddress;

        /**
         * 门店门头照片
         * store_header_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("store_header_copy")
        private String storeHeaderCopy;

        /**
         * 店内环境照片
         * store_indoor_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("store_indoor_copy")
        private String storeIndoorCopy;


        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 营业执照信息
     * 主体类型为企业或个体户时，营业执照信息必填
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessLicenceInfo extends BaseV3Inner {
        private static final long serialVersionUID = -5567222258379517260L;


        /**
         * 营业执照注册号
         * licence_number
         * string(32)
         * 是
         */
        @Required
        @SerializedName("licence_number")
        private String licenceNumber;

        /**
         * 营业执照照片
         * licence_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("licence_copy")
        private String licenceCopy;

        /**
         * 商户名称
         * merchant_name
         * string(50)
         * 是
         */
        @Required
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 法人姓名
         * legal_person
         * string(64)
         * 是
         */
        @Required
        @SerializedName("legal_person")
        private String legalPerson;

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
         * 营业执照有效日期
         * licence_valid_date
         * string(64)
         * 是
         */
        @Required
        @SerializedName("licence_valid_date")
        private String licenceValidDate;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 登记证书信息
     * 主体类型为事业单位或其他组织时，登记证书信息必填。
     */

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CertificateInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5640747094415392402L;


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
         * 登记证书照片
         * cert_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("cert_copy")
        private String certCopy;

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
         * 法人姓名
         * legal_person
         * string(64)
         */
        @Required
        @SerializedName("legal_person")
        private String legalPerson;

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
         * 证书有效日期
         * cert_valid_date
         * string(128)
         * 是
         */
        @Required
        @SerializedName("cert_valid_date")
        private String certValidDate;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 联系人信息
     * 联系人是商户的超级管理员，将接收开户信息及日常重要管理信息，请确定超级管理员为商户法定代表人或负责人再进行操作。如超级管理员非商户法定代表人或负责人，请联系法定代表人或负责人提交申请。
     */

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactInfo extends BaseV3Inner {
        private static final long serialVersionUID = -1964123953977231935L;


        /**
         * 联系人姓名
         * name
         * string(1024)
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("name")
        private String name;

        /**
         * 联系人手机号
         * mobile
         * string(1024)
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("mobile")
        private String mobile;

        /**
         * 联系人身份证号码
         * id_card_number
         * string(1024)
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("id_card_number")
        private String idCardNumber;


        @Override
        public void checkConstraints() throws WxErrorException {
        }

    }

    /**
     * 法人身份信息
     */

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdentificationInfo extends BaseV3Inner {
        private static final long serialVersionUID = -4775534942928369954L;


        /**
         * 法人证件类型
         * identification_type
         * enum
         * 是
         */
        @Required
        @SerializedName("identification_type")
        private String identificationType;

        /**
         * 证件姓名
         * identification_name
         * string(1024)
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("identification_name")
        private String identificationName;

        /**
         * 证件号码
         * identification_number
         * string(1024)
         * 是
         */
        @Required
        @SensitiveEncrypt
        @SerializedName("identification_number")
        private String identificationNumber;

        /**
         * 证件有效日期
         * identification_valid_date
         * string(64)
         * 是
         */
        @Required
        @SerializedName("identification_valid_date")
        private String identificationValidDate;

        /**
         * 证件正面照片
         * identification_front_copy
         * string(255)
         * 是
         */
        @Required
        @SerializedName("identification_front_copy")
        private String identificationFrontCopy;

        /**
         * 证件反面照片
         * identification_back_copy
         * string(255)
         * 否
         */
        @SerializedName("identification_back_copy")
        private String identificationBackCopy;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Override
    public boolean isSensitiveEncrypt() {
        return true;
    }
}

//todo 只完成一半
/*
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
import org.springframework.http.HttpMethod;

import java.io.Serializable;
import java.util.List;

*/
/**
 * version:2020.05.25
 * 二级商户进件API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_1_1.shtml">
 *//*

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

    */
/**
     * 业务申请编号
     * out_request_no
     * string[1,124]
     * 是
     *//*

    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

    */
/**
     * 主体类型
     * organization_type
     * string[1,4]
     * 是
     *//*

    @Required
    @SerializedName("organization_type")
    private String organizationType;

    */
/**
     * 营业执照/登记证书信息
     * business_license_info
     * object
     * 条件选填
     *//*

    @SerializedName("business_license_info")
    private BusinessLicenseInfo businessLicenseInfo;

    */
/**
     * 组织机构代码证信息
     * organization_cert_info
     * object
     * 条件选填
     *//*

    @SerializedName("organization_cert_info")
    private OrganizationCertInfo organizationCertInfo;

    */
/**
     * 经营者/法人证件类型
     * id_doc_type
     * string[1,64]
     * 否
     *//*

    @SerializedName("id_doc_type")
    private String idDocType;

    */
/**
     * 经营者/法人身份证信息
     * id_card_info
     * object
     * 条件选填
     *//*

    @SensitiveEncrypt
    @SerializedName("id_card_info")
    private IdCardInfo idCardInfo;

    */
/**
     * 经营者/法人其他类型证件信息
     * id_doc_info
     * object
     * 条件选填
     *//*

    @SensitiveEncrypt
    @SerializedName("id_doc_info")
    private IdDocInfo idDocInfo;

    */
/**
     * 是否填写结算银行账户
     * need_account_info
     * bool
     * 是
     *//*

    @Required
    @SerializedName("need_account_info")
    private Boolean needAccountInfo;

    */
/**
     * 结算银行账户
     * account_info
     * object
     * 条件选填
     *//*

    @SerializedName("account_info")
    private AccountInfo accountInfo;

    */
/**
     * 超级管理员信息
     * contact_info
     * object
     * 是
     *//*

    @Required
    @SerializedName("contact_info")
    private ContactInfo contactInfo;

    */
/**
     * 店铺信息
     * sales_scene_info
     * object
     * 是
     *//*

    @Required
    @SerializedName("sales_scene_info")
    private SalesSceneInfo salesSceneInfo;

    */
/**
     * 商户简称
     * merchant_shortname
     * string[1,64]
     * 是
     *//*

    @Required
    @SerializedName("merchant_shortname")
    private String merchantShortname;

    */
/**
     * 特殊资质
     * qualifications
     * string[1,1024]
     * 否
     *//*

    @SerializedName("qualifications")
    private String qualifications;

    */
/**
     * 补充材料
     * business_addition_pics
     * string[1,1024]
     * 否
     *//*

    @SerializedName("business_addition_pics")
    private String businessAdditionPics;

    */
/**
     * 补充说明
     * business_addition_desc
     * string[1,256]
     * 否
     *//*

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

    */
/**
     * 营业执照/登记证书信息
     *//*

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessLicenseInfo extends BaseV3Inner {
        private static final long serialVersionUID = 9209642456326070395L;

        */
/**
         * 证件扫描件
         * business_license_copy
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName("business_license_copy")
        private String businessLicenseCopy;

        */
/**
         * 证件注册号
         * business_license_number
         * string[15,18]
         * 是
         *//*

        @Required
        @SerializedName("business_license_number")
        private String businessLicenseNumber;

        */
/**
         * 商户名称
         * merchant_name
         * string[1,128]
         * 是
         *//*

        @Required
        @SerializedName("merchant_name")
        private String merchantName;

        */
/**
         * 经营者/法定代表人姓名
         * legal_person
         * string[1,128]
         * 是
         *//*

        @Required
        @SerializedName("legal_person")
        private String legalPerson;

        */
/**
         * 注册地址
         * company_address
         * string[1,128]
         * 条件选填
         *//*

        @SerializedName("company_address")
        private String companyAddress;

        */
/**
         * 营业期限
         * business_time
         * string[1,256]
         * 条件选填
         *//*

        @SerializedName("business_time")
        private String businessTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    */
/**
     * 组织机构代码证信息
     *//*

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrganizationCertInfo extends BaseV3Inner {
        private static final long serialVersionUID = -5601890055825094354L;
        */
/**
         * 组织机构代码证照片
         * organization_copy
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName("organization_copy")
        private String organizationCopy;

        */
/**
         * 组织机构代码
         * organization_number
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName("organization_number")
        private String organizationNumber;

        */
/**
         * 组织机构代码有效期限
         * organization_time
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName(value = "organization_time")
        private String organizationTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    */
/**
     * 经营者/法人身份证信息
     *//*

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdCardInfo extends BaseV3Inner {
        private static final long serialVersionUID = -2888905796079627132L;

        */
/**
         * 身份证人像面照片
         * id_card_copy
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName("id_card_copy")
        private String idCardCopy;

        */
/**
         * 身份证国徽面照片
         * id_card_national
         * string[1,256]
         * 是
         *//*

        @Required
        @SerializedName("id_card_national")
        private String idCardNational;

        */
/**
         * 身份证姓名
         * id_card_name
         * string[1,256]
         * 是
         *//*

        @Required
        @SensitiveEncrypt
        @SerializedName(value = "id_card_name")
        private String idCardName;

        */
/**
         * 身份证号码
         * id_card_number
         * string[15,18]
         * 是
         *//*

        @Required
        @SensitiveEncrypt
        @SerializedName("id_card_number")
        private String idCardNumber;

        */
/**
         * 身份证有效期限
         * id_card_valid_time
         * string[1,128]
         * 是
         *//*

        @Required
        @SerializedName("id_card_valid_time")
        private String idCardValidTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    */
/**
     * 经营者/法人其他类型证件信息
     *//*

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdDocInfo extends BaseV3Inner {
        private static final long serialVersionUID = -7450729270631781303L;
        */
/**
         * 证件姓名
         * id_doc_name
         * string[1,128]
         * 是
         *//*

        @Required
        @SensitiveEncrypt
        @SerializedName("id_doc_name")
        private String idDocName;

        */
/**
         * 证件号码
         * id_doc_number
         * string[1,128]
         * 是
         *//*

        @Required
        @SensitiveEncrypt
        @SerializedName("id_doc_number")
        private String idDocNumber;

        */
/**
         * 证件照片
         * id_doc_copy
         * string[1,256]
         * 是
         *//*

        @SerializedName("id_doc_copy")
        private String idDocCopy;

        */
/**
         * <pre>
         * 字段名：证件结束日期
         * 变量名：doc_period_end
         * 是否必填：是
         * 类型：string(128)
         * 描述：
         *  1、请按照示例值填写。
         *  2、若证件有效期为长期，请填写：长期。
         *  3、证件有效期需大于60天 。
         *  示例值：2020-01-02
         * </pre>
         *//*

        @SerializedName(value = "doc_period_end")
        private String docPeriodEnd;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AccountInfo implements Serializable {
        */
/**
         * <pre>
         * 字段名：账户类型
         * 变量名：bank_account_type
         * 是否必填：是
         * 类型：string(2)
         * 描述：
         *  1、若主体为企业/党政、机关及事业单位/其他组织，可填写：74-对公账户。
         *  2、若主体为小微，可填写：75-对私账户。
         *  3、若主体为个体工商户，可填写：74-对公账户或75-对私账户。
         *  示例值：75
         * </pre>
         *//*

        @SerializedName(value = "bank_account_type")
        private String bankAccountType;

        */
/**
         * <pre>
         * 字段名：开户银行
         * 变量名：account_bank
         * 是否必填：是
         * 类型：string(10)
         * 描述：
         *  详细参见开户银行对照表。
         *  示例值：工商银行
         * </pre>
         *//*

        @SerializedName(value = "account_bank")
        private String accountBank;

        */
/**
         * <pre>
         * 字段名：开户名称
         * 变量名：account_name
         * 是否必填：是
         * 类型：string(128)
         * 描述：
         *  1、选择经营者个人银行卡时，开户名称必须与身份证姓名一致。
         *  2、选择对公账户时，开户名称必须与营业执照上的“商户名称”一致。
         *  3、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  示例值：AOZdYGISxo4yw96uY1Pk7Rq79Jtt7+I8juwEc4P4TG5xzchG/5IL9DBd+Z0zZXkw==
         * </pre>
         *//*

        @SerializedName(value = "account_name")
        @SpecEncrypt
        private String accountName;

        */
/**
         * <pre>
         * 字段名：开户银行省市编码
         * 变量名：bank_address_code
         * 是否必填：是
         * 类型：string(12)
         * 描述：
         *  至少精确到市，详细参见省市区编号对照表。
         *  示例值：110000
         * </pre>
         *//*

        @SerializedName(value = "bank_address_code")
        private String bankAddressCode;

        */
/**
         * <pre>
         * 字段名：开户银行联行号
         * 变量名：bank_branch_id
         * 是否必填：条件选填
         * 类型：string(64)
         * 描述：
         *  1、17家直连银行无需填写，如为其他银行，开户银行全称（含支行）和开户银行联行号二选一。
         *  2、详细参见开户银行全称（含支行）对照表。
         *  示例值：402713354941
         * </pre>
         *//*

        @SerializedName(value = "bank_branch_id")
        private String bankBranchId;

        */
/**
         * <pre>
         * 字段名：开户银行全称 （含支行)
         * 变量名：bank_name
         * 是否必填：条件选填
         * 类型：string(128)
         * 描述：
         *  1、17家直连银行无需填写，如为其他银行，开户银行全称（含支行）和开户银行联行号二选一。
         *  2、需填写银行全称，如"深圳农村商业银行XXX支行" 。
         *  3、详细参见开户银行全称（含支行）对照表。
         *  示例值：施秉县农村信用合作联社城关信用社
         * </pre>
         *//*

        @SerializedName(value = "bank_name")
        private String bankName;

        */
/**
         * <pre>
         * 字段名：银行帐号
         * 变量名：account_number
         * 是否必填：是
         * 类型：string(128)
         * 描述：
         *  1、数字，长度遵循系统支持的对公/对私卡号长度要求表。
         *  2、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  示例值： d+xT+MQCvrLHUVDWv/8MR/dB7TkXLVfSrUxMPZy6jWWYzpRrEEaYQE8ZRGYoeorwC+w==
         * </pre>
         *//*

        @SerializedName(value = "account_number")
        @SpecEncrypt
        private String accountNumber;

    }

    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class ContactInfo implements Serializable {
        */
/**
         * <pre>
         * 字段名：超级管理员类型
         * 变量名：contact_type
         * 是否必填：是
         * 类型：string(2)
         * 描述：
         *  1、小微商户，选择：65-法人/经营者。
         *  2、个体工商户/企业/党政、机关及事业单位/其他组织，可选择：65-法人/经营者、66- 负责人。 （负责人：经商户授权办理微信支付业务的人员，授权范围包括但不限于签约，入驻过程需完成账户验证）。
         *  示例值：65
         * </pre>
         *//*

        @SerializedName(value = "contact_type")
        private String contactType;

        */
/**
         * <pre>
         * 字段名：超级管理员姓名
         * 变量名：contact_name
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  1、若管理员类型为“法人”，则该姓名需与法人身份证姓名一致。
         *  2、若管理员类型为“经办人”，则可填写实际经办人的姓名。
         *  3、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  （后续该管理员需使用实名微信号完成签约）
         *  示例值： pVd1HJ6zyvPedzGaV+X3IdGdbDnuC4Eelw/wDa4SzfeespQO/0kjiwfqdfg==
         * </pre>
         *//*

        @SerializedName(value = "contact_name")
        @SpecEncrypt
        private String contactName;

        */
/**
         * <pre>
         * 字段名：超级管理员身份证件号码
         * 变量名：contact_id_card_number
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  1、若管理员类型为法人，则该身份证号码需与法人身份证号码一致。若管理员类型为经办人，则可填写实际经办人的身份证号码。
         *  2、可传身份证、来往内地通行证、来往大陆通行证、护照等证件号码。
         *  3、超级管理员签约时，校验微信号绑定的银行卡实名信息，是否与该证件号码一致。
         *  4、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  示例值：pVd1HJ6zmty7/mYNxLMpRSvMRtelw/wDa4SzfeespQO/0kjiwfqdfg==
         * </pre>
         *//*

        @SerializedName(value = "contact_id_card_number")
        @SpecEncrypt
        private String contactIdCardNumber;

        */
/**
         * <pre>
         * 字段名：超级管理员手机
         * 变量名：mobile_phone
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  1、请填写管理员的手机号，11位数字， 用于接收微信支付的重要管理信息及日常操作验证码 。
         *  2、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  示例值：pVd1HJ6zyvPedzGaV+X3qtmrq9bb9tPROvwia4ibL+F6mfjbzQIzfb3HHLEjZ4YiNWWNeespQO/0kjiwfqdfg==
         * </pre>
         *//*

        @SerializedName(value = "mobile_phone")
        @SpecEncrypt
        private String mobilePhone;

        */
/**
         * <pre>
         * 字段名：超级管理员邮箱
         * 变量名：contact_email
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  1、用于接收微信支付的开户邮件及日常业务通知。
         *  2、需要带@，遵循邮箱格式校验 。
         *  3、该字段需进行加密处理，加密方法详见敏感信息加密说明。
         *  示例值：pVd1HJ6zyvPedzGaV+X3qtmrq9bb9tPROvwia4ibL+FWWNUlw/wDa4SzfeespQO/0kjiwfqdfg==
         * </pre>
         *//*

        @SerializedName(value = "contact_email")
        @SpecEncrypt
        private String contactEmail;

    }

    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class SalesSceneInfo implements Serializable {
        */
/**
         * <pre>
         * 字段名：店铺名称
         * 变量名：store_name
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  请填写店铺全称。
         *  示例值：爱烧烤
         * </pre>
         *//*

        @SerializedName(value = "store_name")
        private String storeName;

        */
/**
         * <pre>
         * 字段名：店铺链接
         * 变量名：store_url
         * 是否必填：二选一
         * 类型：string(1024)
         * 描述：
         *  1、店铺二维码or店铺链接二选一必填。
         *  2、请填写店铺主页链接，需符合网站规范。
         *  示例值：http://www.qq.com
         * </pre>
         *//*

        @SerializedName(value = "store_url")
        private String storeUrl;

        */
/**
         * <pre>
         * 字段名：店铺二维码
         * 变量名：store_qr_code
         * 是否必填：1、店铺二维码 or 店铺链接二选一必填。 2、若为电商小程序，可上传店铺页面的小程序二维码。 3、请填写通过图片上传接口预先上传图片生成好的MediaID，仅能上传1张图片 。 示例值：jTpGmxUX3FBWVQ5NJTZvlKX_gdU4cRz7z5NxpnFuAxhBTEO1D8daLC-ehEuo0BJqRTvDujqhThn4ReFxikqJ5YW6zFQ
         * 类型：string(256)
         * 描述：
         * </pre>
         *//*

        @SerializedName(value = "store_qr_code")
        private String storeQrCode;

        */
/**
         * <pre>
         * 字段名：小程序AppID
         * 变量名：mini_program_sub_appid
         * 是否必填：否
         * 类型：string(256)
         * 描述：
         * </pre>
         *//*

        @SerializedName(value = "mini_program_sub_appid")
        private String miniProgramSubAppid;

    }


}
*/

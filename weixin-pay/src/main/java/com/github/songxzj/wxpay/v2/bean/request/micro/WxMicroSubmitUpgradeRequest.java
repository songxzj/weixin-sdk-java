/*
package com.github.songxzj.wxpay.v2.bean.request.micro;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.micro.WxMicroSubmitUpgradeResult;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.constant.LicenceType;
import com.github.songxzj.wxpay.v2.constant.MerchantType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


*/
/**
 * 小微商户提交升级申请单
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=28_2&index=2">
 *//*


@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxMicroSubmitUpgradeRequest extends BaseWxPayRequest<WxMicroSubmitUpgradeResult> {
    private static final long serialVersionUID = -4410811658965266262L;
    */
/**
     * 接口版本号
     * version
     * 是
     * String(32)
     * 1.0
     * 默认值1.0
     *//*

    @Builder.Default
    @Required
    @XStreamAlias("version")
    private String version = "1.0";

    */
/**
     * 平台证书序列号
     * cert_sn
     * 是
     * String(64)
     * 5663476TEREGD45FH63GDFHFG657FCHBFG
     * 用于对敏感信息进行加密的平台证书序列号，获取方法详见平台证书及序列号获取接口（接口返回参数"serial_no"即为平台证书序列号）
     *//*

    @Required
    @XStreamAlias("cert_sn")
    private String certSn;

    */
/**
     * 主体类型
     * business_code
     * 是
     * String(32)
     * 2
     * 2-企业
     * 4-个体工商户
     * 1708-其他组织
     *//*

    @Required
    @XStreamAlias("organization_type")
    private String organizationType;

    */
/**
     * 营业执照扫描件
     * business_license_copy
     * 是
     * String(256)
     * 请填写通过图片上传接口预先上传图片生成好的MediaID,仅能上传1张图片
     *//*

    @Required
    @XStreamAlias("business_license_copy")
    private String businessLicenseCopy;

    */
/**
     * 营业执照注册号
     * business_license_number
     * 是
     * String(32)
     * 123456789012345
     * 请填写营业执照上的营业执照注册号
     * 若主体类型为个体工商户或企业，注册号格式须为15位数字或 18位数字|大写字母
     *//*

    @Required
    @XStreamAlias("business_license_number")
    private String businessLicenseNumber;

    */
/**
     * 商户名称
     * merchant_name
     * 是
     * String(110)
     * 深圳腾讯科技有限公司
     * 请填写营业执照上的商户名称
     * 2~110个字符，支持括号
     * 个体工商户不能以“公司”结尾
     *//*

    @Required
    @XStreamAlias("merchant_name")
    private String merchantName;


    */
/**
     * 注册地址
     * company_address
     * 是
     * String(256)
     * 深圳市腾讯大厦
     * 256个字以内
     *//*

    @Required
    @XStreamAlias("company_address")
    private String companyAddress;

    */
/**
     * 经营者姓名/法定代表人
     * legal_person
     * 是
     * String(256)
     * 请填写营业执照上的经营者/法人姓名
     * 必须与小微商户联系人相同
     * 该字段需进行加密处理，加密方法详见敏感信息加密说明。
     *//*

    @Required
    @XStreamAlias("legal_person")
    private String legalPerson;


    */
/**
     * 营业期限
     * business_time
     * 是
     * String(50)
     * ["1970-01-01","长期"]
     * 请填写营业执照上的营业期限
     * 注意参照示例中的格式
     * 结束时间需大于开始时间
     * 有效期必须大于60天
     *//*

    @Required
    @XStreamAlias("business_time")
    private String businessTime;


    */
/**
     * 营业执照类型
     * business_licence_type
     * 是
     * String(32)
     * 1762
     * 1762-已三证合一    1763-未三证合一
     * 若营业执照上的营业执照注册号为18位统一社会信用代码，请选择“已三证合一”，否则请选择“未三证合一”
     * 注意：参数为business_licence_type，这里为licence，非license
     *//*

    @Required
    @XStreamAlias("business_licence_type")
    private String businessLicenceType;

    */
/**
     * 组织机构代码证照片
     * organization_copy
     * 否
     * String(256)
     * 请填写通过图片上传接口预先上传图片生成好的MediaID
     * 仅能上传1张图片
     * 主体类型为企业其他组织 且 营业执照为未三证合一，必填
     *//*

    @XStreamAlias("organization_copy")
    private String organizationCopy;

    */
/**
     * 组织机构代码
     * organization_number
     * 否
     * String(32)
     * 1234567-1
     * 请填写组织机构代码证上的组织机构代码
     * 9或10位 数字|字母|连字符
     * 主体类型为企业其他组织 且 营业执照为未三证合一，必填
     *//*

    @XStreamAlias("organization_number")
    private String organizationNumber;

    */
/**
     * 组织机构代码有效期限
     * organization_time
     * 否
     * String(128)
     * ["1970-01-01","长期"]
     * 数字，长度遵循系统支持的对私卡号长度要求,该字段需进行加密处理，加密方法详见敏感信息加密说明。小微商户开户目前不支持以下前缀的银行卡
     * 请填写组织机构代码证上的组织机构代码有效期
     * 注意参照示例中的格式
     * 结束时间需大于开始时间
     * 有效期必须大于60天
     * 主体类型为企业其他组织 且 营业执照为未三证合一，必填
     *//*

    @XStreamAlias("organization_time")
    private String organizationTime;


    */
/**
     * 开户名称
     * account_name
     * 否
     * String(50)
     * 请填写对公账户，开户名称必须与营业执照上的“商户名称”一致
     * 主体类型为企业其他组织时，必填
     * 该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @XStreamAlias("account_name")
    private String accountName;

    */
/**
     * 开户银行
     * account_bank
     * 否
     * String(50)
     * 工商银行
     * 详细参见开户银行对照表
     * 主体类型为企业其他组织时，必填
     *//*

    @XStreamAlias("account_bank")
    private String accountBank;

    */
/**
     * 开户银行省市编码
     * bank_address_code
     * 否
     * String(6)
     * 11000
     * 至少精确到市,详细参见省市区编号对照表
     * 主体类型为企业其他组织时，必填
     *//*

    @XStreamAlias("bank_address_code")
    private String bankAddressCode;


    */
/**
     * 开户银行全称（含支行）
     * bank_name
     * 否
     * String(256)
     * 深圳农村商业银行xxx支行
     * 17家直连银行无需填写，其他银行请务必填写
     * 需填写银行全称，如"深圳农村商业银行XXX支行"
     * 详细参见开户银行全称（含支行）对照表
     * 主体类型为企业其他组织 且 开户银行为非直连银行时，必填
     *//*

    @XStreamAlias("bank_name")
    private String bankName;

    */
/**
     * 银行卡号
     * account_number
     * 否
     * String(50)
     * 数字，长度遵循系统支持的对公卡号长度要求
     * 主体类型为企业其他组织时，必填
     * 该字段需进行加密处理，加密方法详见敏感信息加密说明。
     *//*

    @XStreamAlias("account_number")
    private String accountNumber;

    */
/**
     * 商户简称
     * merchant_shortname
     * 是
     * String(50)
     * 2~30个中文字符、英文字符、符号。将在支付完成页向买家展示，需与微信经营范围相关
     *//*

    @Required
    @XStreamAlias("merchant_shortname")
    private String merchantShortname;

    */
/**
     * 费率结算规则ID
     * business
     * 是
     * String(10)
     * 详细参见费率结算规则对照表
     *//*

    @Required
    @XStreamAlias("business")
    private String business;

    */
/**
     * 特殊资质
     * qualifications
     * 否
     * String(1280)
     * ["xxx","xxx"]
     * 1）视行业而定，详细参见费率结算规则对照表
     * 2）注意示例中的格式
     * 3）最多可上传5张照片，请填写通过图片上传接口预先上传图片生成好的MediaID
     *//*

    @XStreamAlias("qualifications")
    private String qualifications;

    */
/**
     * 经营场景
     * business_scene
     * 是
     * String(50)
     * [1721]
     * 1721-线下
     *//*

    @Builder.Default
    @Required
    @XStreamAlias("business_scene")
    private String businessScene = "[1721]";

    */
/**
     * 补充说明
     * business_addition_desc
     * 否
     * String(512)
     *//*

    @XStreamAlias("business_addition_desc")
    private String businessAdditionDesc;

    */
/**
     * 补充材料
     * business_addition_pics
     * 否
     * String(1280)
     * ["123","456"]
     * 最多可上传5张照片，请填写通过图片上传接口预先上传图片生成好的MediaID
     * 请使用JSON格式的数组
     *//*

    @XStreamAlias("business_addition_pics")
    private String businessAdditionPics;

    */
/**
     * 联系邮箱
     * contact_email
     * 否
     * String(50)
     * 联系邮箱
     * 需要带@，遵循邮箱格式校验 ，若小微商户入驻时没有提交邮箱，该字段必填，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @XStreamAlias("contact_email")
    private String contactEmail;

    @Override
    public String routing() {
        return "/applyment/micro/submitupgrade";
    }

    @Override
    public Class<WxMicroSubmitUpgradeResult> getResultClass() {
        return WxMicroSubmitUpgradeResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }


    @Override
    protected void checkConstraints() throws WxErrorException {
        //主体类型为企业其他组织 且 营业执照为未三证合一
        boolean condition = (MerchantType.ENTERPRISE.toString().equals(this.organizationType) || MerchantType.OTHER.toString().equals(this.organizationType))
                && LicenceType.HAS_NOT_THREE_CERTIFICATES_IN_ONE.equals(this.businessLicenceType);

        if (condition && StringUtils.isBlank(this.organizationCopy)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织 且 营业执照为未三证合一，组织机构代码证照片必填");
        }
        if (condition && StringUtils.isBlank(this.organizationNumber)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织 且 营业执照为未三证合一，组织机构代码必填");
        }
        if (condition && StringUtils.isBlank(this.organizationTime)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织 且 营业执照为未三证合一，组织机构代码有效期限必填");
        }
        if ((MerchantType.ENTERPRISE.toString().equals(this.organizationType) || MerchantType.OTHER.toString().equals(this.organizationType))
                && StringUtils.isBlank(this.accountName)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织时，开户名称必填");
        }
        if ((MerchantType.ENTERPRISE.toString().equals(this.organizationType) || MerchantType.OTHER.toString().equals(this.organizationType))
                && StringUtils.isBlank(this.accountBank)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织时，开户银行必填");
        }
        if ((MerchantType.ENTERPRISE.toString().equals(this.organizationType) || MerchantType.OTHER.toString().equals(this.organizationType))
                && StringUtils.isBlank(this.bankAddressCode)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织时，开户银行省市编码必填");
        }
        if ((MerchantType.ENTERPRISE.toString().equals(this.organizationType) || MerchantType.OTHER.toString().equals(this.organizationType))
                && StringUtils.isBlank(this.accountNumber)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "主体类型为企业其他组织时，银行卡号必填");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("version", this.version);
        map.put("cert_sn", this.certSn);
        map.put("organization_type", this.organizationType);
        map.put("business_license_copy", this.businessLicenseCopy);
        map.put("business_license_number", this.businessLicenseNumber);
        map.put("merchant_name", this.merchantName);
        map.put("company_address", this.companyAddress);
        map.put("legal_person", this.legalPerson);
        map.put("business_time", this.businessTime);
        map.put("business_licence_type", this.businessLicenceType);
        map.put("organization_copy", this.organizationCopy);
        map.put("organization_number", this.organizationNumber);
        map.put("organization_time", this.organizationTime);
        map.put("account_name", this.accountName);
        map.put("account_bank", this.accountBank);
        map.put("bank_address_code", this.bankAddressCode);
        map.put("bank_name", this.bankName);
        map.put("account_number", this.accountNumber);
        map.put("merchant_shortname", this.merchantShortname);
        map.put("business", this.business);
        map.put("qualifications", this.qualifications);
        map.put("business_scene", this.businessScene);
        map.put("business_addition_desc", this.businessAdditionDesc);
        map.put("business_addition_pics", this.businessAdditionPics);
        map.put("contact_email", this.contactEmail);
    }

    @Override
    public boolean isIgnoreAppid() {
        return true;
    }

    @Override
    public boolean isIgnoreSubAppId() {
        return true;
    }
}
*/

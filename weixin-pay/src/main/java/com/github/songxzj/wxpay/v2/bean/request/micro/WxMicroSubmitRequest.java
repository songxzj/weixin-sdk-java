/*
package com.github.songxzj.wxpay.v2.bean.request.micro;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.micro.WxMicroSubmitResult;
import com.github.songxzj.common.exception.WxErrorException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;


*/
/**
 * 小微商户申请入驻
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_2">
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
public class WxMicroSubmitRequest extends BaseWxPayRequest<WxMicroSubmitResult> {
    private static final long serialVersionUID = 7832198181803981341L;
    */
/**
     * 接口版本号
     * version
     * 是
     * String(32)
     * 3.0
     * 固定版本号为3.0
     *//*

    @Builder.Default
    @Required
    @XStreamAlias("version")
    private String version = "3.0";

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
     * 业务申请编号
     * business_code
     * 是
     * String(32)
     * 123456
     * 服务商自定义的商户唯一编号。每个编号对应一个申请单，每个申请单审核通过后会生成一个微信支付商户号
     *//*

    @Required
    @XStreamAlias("business_code")
    private String businessCode;

    */
/**
     * 身份证人像面照片
     * id_card_copy
     * 是
     * String(256)
     * 请填写由图片上传接口预先上传图片生成好的media_id
     *//*

    @Required
    @XStreamAlias("id_card_copy")
    private String idCardCopy;

    */
/**
     * 身份证国徽面照片
     * id_card_national
     * 是
     * String(256)
     * 请填写由图片上传接口预先上传图片生成好的media_id
     *//*

    @Required
    @XStreamAlias("id_card_national")
    private String idCardNational;

    */
/**
     * 身份证姓名
     * id_card_name
     * 是
     * String(64)
     * 佑佑
     * 请填写小微商户本人身份证上的姓名，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @Required
    @XStreamAlias("id_card_name")
    private String idCardName;


    */
/**
     * 身份证号码
     * id_card_number
     * 是
     * String(18)
     * 15位数字 或  17位数字+1位数字|X ，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @Required
    @XStreamAlias("id_card_number")
    private String idCardNumber;

    */
/**
     * 身份证有效期限
     * id_card_valid_time
     * 是
     * String(50)
     * ["1970-01-01","长期"]
     * 1.注意参照示例中的格式 2.结束时间需大于开始时间 3.要与上传的身份证照片内容一致
     *//*

    @Required
    @XStreamAlias("id_card_valid_time")
    private String idCardValidTime;


    */
/**
     * 开户名称
     * account_name
     * 是
     * String(50)
     * 必须与身份证姓名一致，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @Required
    @XStreamAlias("account_name")
    private String accountName;


    */
/**
     * 开户银行
     * account_bank
     * 是
     * String(50)
     * 工商银行
     * 详细参见开户银行对照表
     *//*

    @Required
    @XStreamAlias("account_bank")
    private String accountBank;

    */
/**
     * 开户银行省市编码
     * bank_address_code
     * 是
     * String(6)
     * 110000
     * 至少精确到市,详细参见微信支付提供省市对照表
     *//*

    @Required
    @XStreamAlias("bank_address_code")
    private String bankAddressCode;

    */
/**
     * 开户银行全称（含支行）
     * bank_name
     * 否
     * String(256)
     * 深圳农村商业银行xxx支行
     * 1）17家直连银行无需填写，其他银行请务必填写
     * 2）需填写银行全称，如"深圳农村商业银行XXX支行"
     * 详细参见开户银行全称（含支行）对照表
     *//*

    @XStreamAlias("bank_name")
    private String bankName;

    */
/**
     * 银行账号
     * account_number
     * 是
     * String(50)
     * 数字，长度遵循系统支持的对私卡号长度要求,该字段需进行加密处理，加密方法详见敏感信息加密说明。小微商户开户目前不支持以下前缀的银行卡
     * "623501;621468;620522;625191;622384;623078;940034;622150;622151;622181;622188;955100;621095;620062;621285;621798;621799;621797;622199;621096;62215049;62215050;62215051;62218849;62218850;62218851;621622;623219;621674;623218;621599;623698;623699;623686;621098;620529;622180;622182;622187;622189;621582;623676;623677;622812;622810;622811;628310;625919;625368;625367;518905;622835;625603;625605;518905"
     *//*

    @Required
    @XStreamAlias("account_number")
    private String accountNumber;


    */
/**
     * 门店名称
     * store_name
     * 是
     * String(128)
     * 最长50个中文字符
     * 门店场所：填写门店名称
     * 流动经营/便民服务：填写经营/服务名称
     * 线上商品/服务交易：填写线上店铺名称
     *//*

    @Required
    @XStreamAlias("store_name")
    private String storeName;

    */
/**
     * 门店省市编码
     * store_address_code
     * 是
     * String(6)
     * 110000
     * 最长50个中文字符
     * 详细参见微信支付提供省市对照表
     * 门店场所：填写门店省市编码
     * 流动经营/便民服务：填写经营/服务所在地省市编码
     * 线上商品/服务交易：填写卖家所在地省市编码
     *//*

    @Required
    @XStreamAlias("store_address_code")
    private String storeAddressCode;

    */
/**
     * 门店街道名称
     * store_street
     * 是
     * String(500)
     * 最长500个中文字符（无需填写省市信息）
     * 门店场所：填写店铺详细地址，具体区/县及街道门牌号或大厦楼层
     * 流动经营/便民服务：填写“无"
     * 线上商品/服务交易：填写电商平台名称
     *//*

    @Required
    @XStreamAlias("store_street")
    private String storeStreet;


    */
/**
     * 门店经度
     * store_longitude
     * 否
     * String(20)
     * 113.941355
     * 数字或小数
     *//*

    @XStreamAlias("store_longitude")
    private String storeLongitude;

    */
/**
     * 门店纬度
     * store_latitude
     * 否
     * String(20)
     * 22.546245
     * 数字或小数
     *//*

    @XStreamAlias("store_latitude")
    private String storeLatitude;

    */
/**
     * 门店门口照片
     * store_entrance_pic
     * 是
     * String(256)
     * 请填写已预先上传图片生成好的MediaID
     * 门店场所：提交门店门口照片，要求招牌清晰可见
     * 流动经营/便民服务：提交经营/服务现场照片
     * 线上商品/服务交易：提交店铺首页截图
     *//*

    @Required
    @XStreamAlias("store_entrance_pic")
    private String storeEntrancePic;

    */
/**
     * 店内环境照片
     * indoor_pic
     * 是
     * String(256)
     * 请填写已预先上传图片生成好的MediaID
     * 门店场所：提交店内环境照片
     * 流动经营/便民服务：可提交另一张经营/服务现场照片
     * 线上商品/服务交易：提交店铺管理后台截图
     *//*

    @Required
    @XStreamAlias("indoor_pic")
    private String indoorPic;

    */
/**
     * 经营场地证明
     * address_certification
     * 否
     * String(256)
     * 请填写已预先上传图片生成好的MediaID，门面租赁合同扫描件或经营场地证明（需与身份证同名）
     *//*

    @XStreamAlias("address_certification")
    private String addressCertification;

    */
/**
     * 商户简称
     * merchant_shortname
     * 是
     * String(50)
     * UTF-8格式，中文占3个字节，即最多16个汉字长度。将在支付完成页向买家展示，需与商家的实际经营场景相符
     *//*

    @Required
    @XStreamAlias("merchant_shortname")
    private String merchantShortname;


    */
/**
     * 客服电话
     * service_phone
     * 是
     * String(50)
     * UTF-8格式，中文占3个字节，即最多16个汉字长度。在交易记录中向买家展示，请确保电话畅通以便平台回拨确认
     *//*

    @Required
    @XStreamAlias("service_phone")
    private String servicePhone;

    */
/**
     * 售卖商品/提供服务描述
     * product_desc
     * 是
     * String(50)
     * 请填写以下描述之一：
     * 餐饮
     * 线下零售
     * 居民生活服务
     * 休闲娱乐
     * 交通出行
     * 其他
     *//*

    @Required
    @XStreamAlias("product_desc")
    private String productDesc;
    */
/**
     * 费率
     * rate
     * 是
     * String(50)
     * 0.6%
     * 由服务商指定，微信支付提供字典值
     *//*

    @Required
    @XStreamAlias("rate")
    private String rate;

    */
/**
     * 补充说明
     * business_addition_desc
     * 否
     * String(50)
     * 可填写需要额外说明的文字
     *//*

    @XStreamAlias("business_addition_desc")
    private String businessAdditionDesc;

    */
/**
     * 补充材料
     * business_addition_pics
     * 否
     * String(50)
     * ["123","456"]
     * 最多可上传5张照片，请填写已预先上传图片生成好的MediaID
     *//*

    @XStreamAlias("business_addition_pics")
    private String businessAdditionPics;

    */
/**
     * 超级管理员姓名
     * contact
     * 是
     * String(50)
     * 和身份证姓名一致 ，该字段需进行加密处理，加密方法详见敏感信息加密说明，超级管理员需在开户后进行签约，并可接收日常重要管理信息和进行资金操作，请确定其为商户法定代表人或负责人
     *//*

    @Required
    @XStreamAlias("contact")
    private String contact;
    */
/**
     * 手机号码
     * contact_phone
     * 是
     * String(11)
     * 11位数字，手机号码 ，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @Required
    @XStreamAlias("contact_phone")
    private String contactPhone;
    */
/**
     * 联系邮箱
     * contact_email
     * 否
     * String(50)
     * 需要带@，遵循邮箱格式校验 ，该字段需进行加密处理，加密方法详见敏感信息加密说明
     *//*

    @XStreamAlias("contact_email")
    private String contactEmail;

    @Override
    public String routing() {
        return "/applyment/micro/submit";
    }

    @Override
    public Class<WxMicroSubmitResult> getResultClass() {
        return WxMicroSubmitResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }


    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("version", this.version);
        map.put("cert_sn", this.certSn);
        map.put("business_code", this.businessCode);
        map.put("id_card_copy", this.idCardCopy);
        map.put("id_card_national", this.idCardNational);
        map.put("id_card_name", this.idCardName);
        map.put("id_card_number", this.idCardNumber);
        map.put("id_card_valid_time", this.idCardValidTime);
        map.put("account_name", this.accountName);
        map.put("account_bank", this.accountBank);
        map.put("bank_address_code", this.bankAddressCode);
        map.put("bank_name", this.bankName);
        map.put("account_number", this.accountNumber);
        map.put("store_name", this.storeName);
        map.put("store_address_code", this.storeAddressCode);
        map.put("store_street", this.storeStreet);
        map.put("store_longitude", this.storeLongitude);
        map.put("store_latitude", this.storeLatitude);
        map.put("store_entrance_pic", this.storeEntrancePic);
        map.put("indoor_pic", this.indoorPic);
        map.put("address_certification", this.addressCertification);
        map.put("merchant_shortname", this.merchantShortname);
        map.put("service_phone", this.servicePhone);
        map.put("product_desc", this.productDesc);
        map.put("rate", this.rate);
        map.put("business_addition_desc", this.businessAdditionDesc);
        map.put("business_addition_pics", this.businessAdditionPics);
        map.put("contact", this.contact);
        map.put("contact_phone", this.contactPhone);
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

    @Override
    public boolean isIgnoreSubMchId() {
        return true;
    }
}
*/

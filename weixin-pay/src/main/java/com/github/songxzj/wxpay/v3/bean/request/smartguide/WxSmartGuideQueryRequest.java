package com.github.songxzj.wxpay.v3.bean.request.smartguide;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.smartguide.WxSmartGuideQueryResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.15
 * 服务人员查询API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/smartguide/chapter3_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxSmartGuideQueryRequest extends BaseWxPayV3Request<WxSmartGuideQueryResult> {
    private static final long serialVersionUID = 4366032925243316064L;

    /**
     * 子商户号
     * sub_mchid
     * string[1,64]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 门店ID
     * store_id
     * int
     * 是
     */
    @Required
    @SerializedName("store_id")
    private Integer storeId;

    /**
     * 企业微信的员工ID
     * userid
     * string[1,64]
     * 否
     */
    @SerializedName("userid")
    private String userid;

    /**
     * 服务人员手机号码
     * mobile
     * string[1,512]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("mobile")
    private String mobile;

    /**
     * 工号
     * work_id
     * string[1,20]
     * 否
     */
    @SerializedName("work_id")
    private String workId;

    /**
     * 最大资源条数
     * limit
     * int
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 请求资源起始位置
     * offset
     * int
     * 否
     */
    @SerializedName("offset")
    private Integer offset;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/smartguide/guides?store_id=").append(this.storeId);
        if (!StringUtils.isBlank(this.subMchid)) {
            routing.append("&sub_mchid=").append(this.subMchid);
        }
        if (!StringUtils.isBlank(this.userid)) {
            routing.append("&userid=").append(this.userid);
        }
        if (!StringUtils.isBlank(this.mobile)) {
            routing.append("&mobile=").append(this.mobile);
        }
        if (!StringUtils.isBlank(this.workId)) {
            routing.append("&work_id=").append(this.workId);
        }
        if (this.limit != null) {
            routing.append("&limit=").append(this.limit);
        }
        if (this.offset != null) {
            routing.append("&offset=").append(this.offset);
        }

        return routing.toString();
    }

    @Override
    public Class<WxSmartGuideQueryResult> getResultClass() {
        return WxSmartGuideQueryResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}

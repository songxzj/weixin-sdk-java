package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorStockStateBatchResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.27
 * 条件查询批次列表API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_4.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorStockStateBatchRequest extends BaseWxPayV3Request<WxFavorStockStateBatchResult> {
    private static final long serialVersionUID = 2103959566649329L;


    /**
     * 分页页码
     * offset
     * uint32
     * 是
     */
    @Required
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint32
     * 是
     */
    @Required
    @SerializedName("limit")
    private Integer limit;

    /**
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;

    /**
     * 起始时间
     * create_start_time
     * string[1,64]
     * 否
     */
    @SerializedName("create_start_time")
    private String createStartTime;

    /**
     * 终止时间
     * create_end_time
     * string[1,64]
     * 否
     */
    @SerializedName("create_end_time")
    private String createEndTime;

    /**
     * 批次状态
     * status
     * string[1,12]
     * 否
     */
    @SerializedName("status")
    private String status;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/favor/stocks?offset=").append(this.offset)
                .append("&limit=").append(this.limit)
                .append("&stock_creator_mchid=").append(this.stockCreatorMchid);
        if (!StringUtils.isBlank(this.createStartTime)) {
            routing.append("&create_start_time=").append(this.createStartTime);
        }
        if (!StringUtils.isBlank(this.createEndTime)) {
            routing.append("&create_end_time=").append(this.createEndTime);
        }
        if (!StringUtils.isBlank(this.status)) {
            routing.append("&status=").append(this.status);
        }
        return routing.toString();
    }

    @Override
    public Class<WxFavorStockStateBatchResult> getResultClass() {
        return WxFavorStockStateBatchResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}

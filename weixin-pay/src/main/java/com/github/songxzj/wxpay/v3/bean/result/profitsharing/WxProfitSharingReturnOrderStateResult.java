package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingReturnOrderStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 301747607176610523L;

    /**
     * 微信分账单号
     * order_id
     * string[1, 64]
     * 是
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 商户分账单号
     * out_order_no
     * string[1, 64]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * out_return_no
     * string[1, 64]
     * 是
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 微信回退单号
     * return_id
     * string[1, 64]
     * 是
     */
    @SerializedName("return_id")
    private String returnId;

    /**
     * 回退商户号
     * return_mchid
     * string[1, 32]
     * 是
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 回退金额
     * amount
     * int
     * 是
     */
    @SerializedName("amount")
    private Integer amount;


    /**
     * 回退描述
     * description
     * string[1, 80]
     * 是
     */
    @SerializedName("description")
    private String description;

    /**
     * 回退结果
     * result
     * string[1, 32]
     * 是
     */
    @SerializedName("result")
    private String result;

    /**
     * 失败原因
     * fail_reason
     * string[1, 64]
     * 是
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 创建时间
     * create_time
     * string[1, 64]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 完成时间
     * finish_time
     * string[1, 64]
     * 是
     */
    @SerializedName("finish_time")
    private String finishTime;

}

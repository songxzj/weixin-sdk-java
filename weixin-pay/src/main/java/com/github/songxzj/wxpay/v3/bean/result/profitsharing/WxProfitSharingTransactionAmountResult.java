package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingTransactionAmountResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2518163889005833897L;

    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;


    /**
     * 订单剩余待分金额
     * unsplit_amount
     * int
     * 是
     */
    @SerializedName("unsplit_amount")
    private Integer unsplitAmount;

}

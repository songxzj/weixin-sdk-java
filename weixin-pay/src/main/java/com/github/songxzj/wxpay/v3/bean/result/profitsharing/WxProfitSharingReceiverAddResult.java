package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingReceiverAddResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 726704030904965522L;

    /**
     * 分账接收方类型
     * type
     * string[1, 32]
     * 是
     */
    @SerializedName("type")
    private String type;


    /**
     * 分账接收方账号
     * account
     * string[1, 64]
     * 是
     */
    @SerializedName("account")
    private String account;


    /**
     * 分账个人接收方姓名
     * name
     * string[1, 1024]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("name")
    private String name;

    /**
     * 与分账方的关系类型
     * relation_type
     * string[1, 32]
     * 是
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 自定义的分账关系
     * custom_relation
     * string[1, 10]
     * 否
     */
    @SerializedName("custom_relation")
    private String customRelation;

}

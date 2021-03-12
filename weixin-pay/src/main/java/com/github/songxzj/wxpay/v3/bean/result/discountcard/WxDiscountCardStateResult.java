package com.github.songxzj.wxpay.v3.bean.result.discountcard;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 通用如下：
 * 用户领卡通知（https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_4.shtml）
 * 守约状态变化通知（https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_5.shtml）
 * 扣费状态变化通知（https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_6.shtml）
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxDiscountCardStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -5533976706000104711L;


    /**
     * 先享卡ID
     * card_id
     * string[1,64]
     * 是
     */
    @SerializedName("card_id")
    private String cardId;

    /**
     * 先享卡模板ID
     * card_template_id
     * string[1,64]
     * 是
     */
    @SerializedName("card_template_id")
    private String cardTemplateId;

    /**
     * 用户标识
     * openid
     * string
     * [1,128]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 商户领卡号
     * out_card_code
     * string[1,32]
     * 是
     */
    @SerializedName("out_card_code")
    private String outCardCode;

    /**
     * 公众账号ID
     * appid
     * string[10,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 约定时间期限
     * time_range
     * object
     * 是
     */
    @SerializedName("time_range")
    private TimeRange timeRange;

    /**
     * 状态
     * state
     * string[1,16]
     * 是
     */
    @SerializedName("state")
    private String state;

    /**
     * 未完成约定原因
     * unfinished_reason
     * string[1,16]
     * 否
     */
    @SerializedName("unfinished_reason")
    private String unfinishedReason;

    /**
     * 享受优惠总金额
     * total_amount
     * int64
     * 否
     */
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * 用户退回优惠的付款信息
     * pay_information
     * object
     * 否
     */
    @SerializedName("pay_information")
    private PayInformation payInformation;

    /**
     * 创卡时间
     * create_time
     * string[1,32]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 目标列表
     * objectives
     * array
     * 是
     */
    @SerializedName("objectives")
    private List<ObjectiveCompletionRecord> objectives;

    /**
     * 优惠列表
     * rewards
     * array
     * 是
     */
    @SerializedName("rewards")
    private List<Reward> rewards;

    /**
     * 邀请者用户标识
     * sharer_openid
     * string[1,128]
     * 否
     */
    @SerializedName("sharer_openid")
    private String sharerOpenid;

    /**
     * 约定时间期限
     */
    @Data
    @NoArgsConstructor
    public static class TimeRange implements Serializable {
        private static final long serialVersionUID = -5197766032343314836L;

        /**
         * 约定开始时间
         * begin_time
         * string[1,32]
         * 是
         */
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 约定结束时间
         * end_time
         * string[1,32]
         * 是
         */
        @SerializedName("end_time")
        private String endTime;
    }

    /**
     * 用户退回优惠的付款信息
     */
    @Data
    @NoArgsConstructor
    public static class PayInformation implements Serializable {
        private static final long serialVersionUID = -8515255469937605299L;

        /**
         * 付款金额
         * pay_amount
         * int64
         * 是
         */
        @SerializedName("pay_amount")
        private Integer payAmount;

        /**
         * 付款状态
         * pay_state
         * string[1,8）
         * 是
         */
        @SerializedName("pay_state")
        private String payState;

        /**
         * 微信支付订单号
         * transaction_id
         * string[1,64）
         * 否
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 支付时间
         * pay_time
         * string[1,32）
         * 否
         */
        @SerializedName("pay_time")
        private String payTime;
    }

    /**
     * 目标
     */
    @Data
    @NoArgsConstructor
    public static class Objective implements Serializable {
        private static final long serialVersionUID = 655402768381093786L;

        /**
         * 目标ID
         * objective_id
         * string[1,32]
         * 是
         */
        @SerializedName("objective_id")
        private String objectiveId;

        /**
         * 目标名称
         * name
         * string[1,20]
         * 是
         */
        @SerializedName("name")
        private String name;

        /**
         * 目标数量
         * count
         * int
         * 是
         */
        @SerializedName("count")
        private Integer count;

        /**
         * 目标单位
         * unit
         * string[1,5]
         * 是
         */
        @SerializedName("unit")
        private String unit;

        /**
         * 目标描述
         * description
         * string[1,50]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 目标完成记录
         * objective_completion_records
         * array
         * 否
         */
        @SerializedName("objective_completion_records")
        private List<ObjectiveCompletionRecord> objectiveCompletionRecords;
    }

    /**
     * 目标完成记录
     */
    @Data
    @NoArgsConstructor
    public static class ObjectiveCompletionRecord implements Serializable {
        private static final long serialVersionUID = 3414681795236156844L;

        /**
         * 目标完成流水号
         * objective_completion_serial_no
         * string[1,32]
         * 是
         */
        @SerializedName("objective_completion_serial_no")
        private String objectiveCompletionSerialNo;

        /**
         * 目标ID
         * objective_id
         * string[1,32]
         * 是
         */
        @SerializedName("objective_id")
        private String objectiveId;

        /**
         * 目标完成时间
         * completion_time
         * string[1,32]
         * 是
         */
        @SerializedName("completion_time")
        private String completionTime;

        /**
         * 目标完成类型
         * completion_type
         * string[1,8]
         * 是
         */
        @SerializedName("completion_type")
        private String completionType;

        /**
         * 目标完成描述
         * description
         * string[1,20]
         * 是
         */
        @SerializedName("description")
        private String description;

        /**
         * 目标完成数量
         * completion_count
         * int
         * 是
         */
        @SerializedName("completion_count")
        private Integer completionCount;

        /**
         * 备注说明
         * remark
         * string[1,50]
         * 否
         */
        @SerializedName("remark")
        private String remark;
    }

    /**
     * 优惠列表
     */
    @Data
    @NoArgsConstructor
    public static class Reward implements Serializable {
        private static final long serialVersionUID = -7280505139236895590L;

        /**
         * 优惠ID
         * reward_id
         * string[1,32]
         * 是
         */
        @SerializedName("reward_id")
        private String rewardId;

        /**
         * 优惠名称
         * name
         * string[1,20]
         * 是
         */
        @SerializedName("name")
        private String name;

        /**
         * 优惠数量类型
         * count_type
         * string[1,18]
         * 是
         */
        @SerializedName("count_type")
        private String countType;

        /**
         * 优惠数量
         * count
         * int
         * 是
         */
        @SerializedName("count")
        private Integer count;

        /**
         * 优惠单位
         * unit
         * string[1,5]
         * 是
         */
        @SerializedName("unit")
        private String unit;

        /**
         * 金额
         * amount
         * int64
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 优惠描述
         * description
         * string[1,50]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 优惠使用记录
         * reward_usage_records
         * array
         * 否
         */
        @SerializedName("reward_usage_records")
        private List<RewardUsageRecord> rewardUsageRecords;
    }

    /**
     * 优惠使用记录
     */
    @Data
    @NoArgsConstructor
    public static class RewardUsageRecord implements Serializable {
        private static final long serialVersionUID = 7451102094175731206L;

        /**
         * 优惠使用记录流水号
         * reward_usage_serial_no
         * string[1,32]
         * 是
         */
        @SerializedName("reward_usage_serial_no")
        private String rewardUsageSerialNo;

        /**
         * 优惠ID
         * reward_id
         * string[1,32]
         * 是
         */
        @SerializedName("reward_id")
        private String rewardId;

        /**
         * 优惠使用时间
         * usage_time
         * string[1,32）
         * 是
         */
        @SerializedName("usage_time")
        private String usageTime;

        /**
         * 优惠使用类型
         * usage_type
         * string[1,8]
         * 是
         */
        @SerializedName("usage_type")
        private String usageType;

        /**
         * 优惠使用描述
         * description
         * string[1,20]
         * 是
         */
        @SerializedName("description")
        private String description;

        /**
         * 数量
         * usage_count
         * int
         * 是
         */
        @SerializedName("usage_count")
        private Integer usageCount;

        /**
         * 金额
         * amount
         * int64
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 备注说明
         * remark
         * string[1,50]
         * 否
         */
        @SerializedName("remark")
        private String remark;
    }
}

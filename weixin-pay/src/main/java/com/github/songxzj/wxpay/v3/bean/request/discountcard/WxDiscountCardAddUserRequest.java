package com.github.songxzj.wxpay.v3.bean.request.discountcard;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.discountcard.WxDiscountCardAddUserResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.06.04
 * 增加用户记录API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_2.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxDiscountCardAddUserRequest extends BaseWxPayV3Request<WxDiscountCardAddUserResult> {
    private static final long serialVersionUID = -1197774561201460033L;

    /**
     * 商户领卡号
     * out_card_code
     * string[1,32]
     * 是
     */
    @GsonExclude
    @Required
    @SerializedName("out_card_code")
    private String outCardCode;

    /**
     * 先享卡模板ID
     * card_template_id
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("card_template_id")
    private String cardTemplateId;

    /**
     * 目标完成记录
     * objective_completion_records
     * array
     * 否
     */
    @SerializedName("objective_completion_records")
    private List<ObjectiveCompletionRecord> objectiveCompletionRecords;

    /**
     * 优惠使用记录
     * reward_usage_records
     * array
     * 否
     */
    @SerializedName("reward_usage_records")
    private List<RewardUsageRecord> rewardUsageRecords;

    @Override
    public String routing() {
        return "/v3/discount-card/cards/" + this.outCardCode + "/add-user-records";
    }

    @Override
    public Class<WxDiscountCardAddUserResult> getResultClass() {
        return WxDiscountCardAddUserResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.objectiveCompletionRecords != null) {
            for (ObjectiveCompletionRecord objectiveCompletionRecord : this.objectiveCompletionRecords) {
                objectiveCompletionRecord.checkConstraints();
            }
        }

        if (this.rewardUsageRecords != null) {
            for (RewardUsageRecord rewardUsageRecord : this.rewardUsageRecords) {
                rewardUsageRecord.checkConstraints();
            }
        }
    }


    /**
     * 目标完成记录
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObjectiveCompletionRecord extends BaseV3Inner {
        private static final long serialVersionUID = 5395554587824421880L;

        /**
         * 目标完成流水号
         * objective_completion_serial_no
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("objective_completion_serial_no")
        private String objectiveCompletionSerialNo;

        /**
         * 目标ID
         * objective_id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("objective_id")
        private String objectiveId;

        /**
         * 目标完成时间
         * completion_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("completion_time")
        private String completionTime;

        /**
         * 目标完成类型
         * completion_type
         * string[1,8]
         * 是
         */
        @Required
        @SerializedName("completion_type")
        private String completionType;

        /**
         * 目标完成描述
         * description
         * string[1,20]
         * 是
         */
        @Required
        @SerializedName("description")
        private String description;

        /**
         * 目标完成数量
         * completion_count
         * int
         * 是
         */
        @Required
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

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 优惠使用记录
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RewardUsageRecord extends BaseV3Inner {
        private static final long serialVersionUID = -5392022260797037754L;

        /**
         * 优惠使用记录流水号
         * reward_usage_serial_no
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("reward_usage_serial_no")
        private String rewardUsageSerialNo;

        /**
         * 优惠ID
         * reward_id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("reward_id")
        private String rewardId;

        /**
         * 优惠使用时间
         * usage_time
         * string[1,32）
         * 是
         */
        @Required
        @SerializedName("usage_time")
        private String usageTime;

        /**
         * 优惠使用类型
         * usage_type
         * string[1,8]
         * 是
         */
        @Required
        @SerializedName("usage_type")
        private String usageType;

        /**
         * 优惠使用描述
         * description
         * string[1,20]
         * 是
         */
        @Required
        @SerializedName("description")
        private String description;

        /**
         * 数量
         * usage_count
         * int
         * 是
         */
        @Required
        @SerializedName("usage_count")
        private Integer usageCount;

        /**
         * 金额
         * amount
         * int64
         * 是
         */
        @Required
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

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }
}

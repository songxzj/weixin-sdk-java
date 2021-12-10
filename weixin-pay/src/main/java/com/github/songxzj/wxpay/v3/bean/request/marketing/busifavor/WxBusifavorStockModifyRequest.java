package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorStockModifyResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.12.09
 * 修改商家券基本信息API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter9_2_12.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorStockModifyRequest extends BaseWxPayV3Request<WxBusifavorStockModifyResult> {
    private static final long serialVersionUID = -4502106843050253463L;


    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 自定义入口
     * custom_entrance
     * object
     * 否
     */
    @SerializedName("custom_entrance")
    private CustomEntrance customEntrance;


    /**
     * 批次备注
     * comment
     * string[1,20]
     * 否
     */
    @SerializedName("comment")
    private String comment;

    /**
     * 适用商品范围
     * goods_name
     * string[1,15]
     * 否
     */
    @SerializedName("goods_name")
    private String goodsName;

    /**
     * 商户请求单号
     * out_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

    /**
     * 样式信息
     * display_pattern_info
     * object
     * 否
     */
    @SerializedName("display_pattern_info")
    private DisplayPatternInfo displayPatternInfo;

    /**
     * 核销规则
     * coupon_use_rule
     * object
     * 否
     */
    @SerializedName("coupon_use_rule")
    private CouponUseRule couponUseRule;

    /**
     * 发放规则
     * stock_send_rule
     * object
     * 否
     */
    @SerializedName("stock_send_rule")
    private StockSendRule stockSendRule;

    /**
     * 事件通知配置
     * notify_config
     * object
     * 否
     */
    @SerializedName("notify_config")
    private NotifyConfig notifyConfig;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/stocks/" + this.stockId;
    }

    @Override
    public Class<WxBusifavorStockModifyResult> getResultClass() {
        return WxBusifavorStockModifyResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.PATCH;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.couponUseRule != null) {
            this.couponUseRule.checkConstraints();
        }
        if (this.stockSendRule != null) {
            this.stockSendRule.checkConstraints();
        }
        if (this.customEntrance != null) {
            this.customEntrance.checkConstraints();
        }
        if (this.displayPatternInfo != null) {
            this.displayPatternInfo.checkConstraints();
        }
        if (this.notifyConfig != null) {
            this.notifyConfig.checkConstraints();
        }
    }


    /**
     * 自定义入口
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomEntrance extends BaseV3Inner {
        private static final long serialVersionUID = 958645608428280363L;

        /**
         * 小程序入口
         * mini_programs_info
         * object
         * 否
         */
        @SerializedName("mini_programs_info")
        private MiniProgramsInfo miniProgramsInfo;

        /**
         * 商户公众号appid
         * appid
         * string[1,32]
         * 否
         */
        @SerializedName("appid")
        private String appid;

        /**
         * 营销馆id
         * hall_id
         * string[1,64]
         * 否
         */
        @SerializedName("hall_id")
        private String hallId;

        /**
         * code展示模式
         * code_display_mode
         * string[1,8]
         * 否
         */
        @SerializedName("code_display_mode")
        private String codeDisplayMode;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.miniProgramsInfo != null) {
                this.miniProgramsInfo.checkConstraints();
            }
        }
    }

    /**
     * 小程序入口
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MiniProgramsInfo extends BaseV3Inner {
        private static final long serialVersionUID = -1136637064024914587L;

        /**
         * 商家小程序appid
         * mini_programs_appid
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 商家小程序path
         * mini_programs_path
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;

        /**
         * 入口文案
         * entrance_words
         * string[1,5]
         * 是
         */
        @Required
        @SerializedName("entrance_words")
        private String entranceWords;

        /**
         * 引导文案
         * guiding_words
         * string[1,6]
         * 否
         */
        @SerializedName("guiding_words")
        private String guidingWords;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 样式信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisplayPatternInfo extends BaseV3Inner {
        private static final long serialVersionUID = -2544146066119572014L;

        /**
         * 使用须知
         * description
         * string[1,1000]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 背景颜色
         * background_color
         * string[1,16]
         * 否
         */
        @SerializedName("background_color")
        private String backgroundColor;

        /**
         * 券详情图片
         * coupon_image_url
         * string[1,128]
         * 否
         */
        @SerializedName("coupon_image_url")
        private String couponImageUrl;

        /**
         * 视频号相关信息
         * finder_info
         * object
         * 否
         */
        @SerializedName("finder_info")
        private FinderInfo finderInfo;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 视频号相关信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FinderInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5156079602675535053L;

        /**
         * 视频号ID
         * finder_id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("finder_id")
        private String finderId;

        /**
         * 视频号视频ID
         * finder_video_id
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("finder_video_id")
        private String finderVideoId;


        /**
         * 视频号封面图
         * finder_video_cover_image_url
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("finder_video_cover_image_url")
        private String finderVideoCoverImageUrl;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 核销规则
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CouponUseRule extends BaseV3Inner {
        private static final long serialVersionUID = -5489979268839132575L;

        /**
         * 核销方式
         * use_method
         * string[1,128]
         * 否
         */
        @SerializedName("use_method")
        private String useMethod;

        /**
         * 小程序appid
         * mini_programs_appid
         * string[1,32]
         * 否
         */
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 小程序path
         * mini_programs_path
         * string[1,128]
         * 否
         */
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 发放规则
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockSendRule extends BaseV3Inner {
        private static final long serialVersionUID = 1769092129249036348L;

        /**
         * 是否开启自然人限制
         * natural_person_limit
         * bool
         * 否
         */
        @SerializedName("natural_person_limit")
        private Boolean naturalPersonLimit;

        /**
         * 可疑账号拦截
         * prevent_api_abuse
         * bool
         * 否
         */
        @SerializedName("prevent_api_abuse")
        private Boolean preventApiAbuse;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 事件通知配置
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NotifyConfig extends BaseV3Inner {
        private static final long serialVersionUID = 1448514933790426076L;

        /**
         * 事件通知appid
         * notify_appid
         * string[1,64]
         * 否
         */
        @SerializedName("notify_appid")
        private String notifyAppid;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }
}

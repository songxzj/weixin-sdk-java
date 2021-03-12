package com.github.songxzj.wxpay.v3.bean.request.media;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.constant.WxMediaConstants;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.media.WxMediaUploadResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.io.File;

/**
 * 图片上传API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/chapter3_1.shtml">
 * 视频上传API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/chapter3_2.shtml">
 * 商户上传反馈图片API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter5_1.shtml">
 * 图片上传（营销）
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/open/pay/chapter4_7.shtml">
 */


@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxMediaUploadRequest extends BaseWxPayV3Request<WxMediaUploadResult> {
    private static final long serialVersionUID = 3501150685142010901L;


    /**
     * 图片文件或者视频文件
     */
    @Required
    @GsonExclude
    private File file;

    /**
     * 区分商户上传反馈图片接口
     */
    @GsonExclude
    private Boolean feedback;

    /**
     * 图片上传（营销）
     */
    @GsonExclude
    private Boolean marketingFavor;

    /**
     * 文件名称
     * filename
     * string(128)
     * 否
     */
    @SerializedName("filename")
    private String filename;

    /**
     * 文件摘要
     * sha256
     * string(64)
     * 否
     */
    @SerializedName("sha256")
    private String sha256;


    @Override
    public String routing() {
        if (this.feedback != null && this.feedback) {
            return "/v3/merchant-service/images/upload";
        }
        if (this.marketingFavor != null && this.marketingFavor) {
            return "/v3/marketing/favor/media/image-upload";
        }

        if (isImageFile()) {
            return "/v3/merchant/media/upload";
        } else if (isVideoFile()) {
            return "/v3/merchant/media/video_upload";
        } else {
            return "";
        }
    }

    @Override
    public Class<WxMediaUploadResult> getResultClass() {
        return WxMediaUploadResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    public boolean isImageFile() {
        String fileType = this.filename.substring(this.filename.lastIndexOf(".") + 1);
        return WxMediaConstants.IMAGE_SUFFIX_LIST.contains(fileType);
    }

    public boolean isVideoFile() {
        String fileType = this.filename.substring(this.filename.lastIndexOf(".") + 1);
        return WxMediaConstants.VIDEO_SUFFIX_LIST.contains(fileType);
    }
}

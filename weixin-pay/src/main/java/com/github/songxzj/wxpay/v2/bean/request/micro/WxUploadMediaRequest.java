/*
package com.github.songxzj.wxpay.v2.bean.request.micro;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SignExclude;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxMediaConstants;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.micro.WxUploadMediaResult;
import com.github.songxzj.common.exception.WxErrorException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

*/
/**
 * 图片上传API (签名方式用MD5返回验签才不会报错)
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_9">
 *//*


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
@Slf4j
public class WxUploadMediaRequest extends BaseWxPayRequest<WxUploadMediaResult> {
    private static final long serialVersionUID = -3793459253812619225L;


    */
/**
     * 图片文件
     *//*

    @Required
    @SignExclude
    private File file;

    */
/**
     * 媒体文件内容hash值
     * media_hash
     * 是
     * String(32)
     * 根据媒体文件内容进行MD5计算后的值，注意小写
     *//*

    @Required
    @XStreamAlias("media_hash")
    private String mediaHash;


    @Override
    public String routing() {
        return "/secapi/mch/uploadmedia";
    }

    @Override
    public Class<WxUploadMediaResult> getResultClass() {
        return WxUploadMediaResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        String fileName = this.file.getName();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!WxMediaConstants.IMAGE_SUFFIX_LIST.contains(fileType)) {
            throw new WxErrorException(WxErrorExceptionFactor.FILE_ERROR);
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("media_hash", this.mediaHash);
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

    public static class WxUploadMediaRequestBuilder {

        private File file;

        public WxUploadMediaRequestBuilder file(File file) {
            this.file = file;
            return this;
        }

        public WxUploadMediaRequest build() throws WxErrorException {
            if (ObjectUtil.isNull(this.file)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "file 必须提供值");
            }

            String mediaHash;
            try {
                InputStream data = new FileInputStream(this.file);
                mediaHash = DigestUtil.md5Hex(data).toLowerCase();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                throw new WxErrorException(WxErrorExceptionFactor.IMAGE_ERROR);
            }

            return new WxUploadMediaRequest(this.file, mediaHash);
        }
    }

}
*/

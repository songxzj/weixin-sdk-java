package com.github.songxzj.wxpay.v3.bean.result.bill;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBillDownloadBillResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1612105590999627154L;
}

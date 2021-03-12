package com.github.songxzj.wxpay.v3.bean.result.paypartner;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayPartnerTransactionsCloseResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3285207349355477291L;
}

package com.github.songxzj.wxpay.v3.bean.result.pay;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayTransactionsCloseResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 8458662565652209257L;
}

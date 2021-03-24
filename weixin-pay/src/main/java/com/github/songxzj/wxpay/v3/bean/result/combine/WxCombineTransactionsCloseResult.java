package com.github.songxzj.wxpay.v3.bean.result.combine;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxCombineTransactionsCloseResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1581630615723029967L;
}

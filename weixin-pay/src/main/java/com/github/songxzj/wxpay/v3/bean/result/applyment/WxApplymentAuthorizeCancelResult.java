package com.github.songxzj.wxpay.v3.bean.result.applyment;


import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxApplymentAuthorizeCancelResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1496053177451985450L;
}

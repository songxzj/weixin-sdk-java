package com.github.songxzj.common.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SignatureHeader implements Serializable {
    private static final long serialVersionUID = -1223980089856375422L;

    private String timestamp;

    private String nonce;

    private String signature;

    private String serialNo;
}

package com.github.songxzj.wxpay.v3.bean.result;

import com.github.songxzj.wxpay.v3.bean.cert.WxPayV3Certificate;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxCertificatesV3Result extends BaseWxPayV3Result {
    private static final long serialVersionUID = 7030739752975089975L;


    @SerializedName("data")
    private List<WxPayV3Certificate> wxPayV3CertificateList;

    @Override
    public void compose() {
        composeV3Certificates();
    }

    /**
     * 组装解密生成证书.
     */
    public void composeV3Certificates() {
        //创建一个排序规则
        Comparator mycmp = ComparableComparator.comparableComparator();
        mycmp = ComparatorUtils.nullLowComparator(mycmp);  //允许null
        mycmp = ComparatorUtils.reversedComparator(mycmp); //逆序

        //声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
        List<Object> sortFields = Lists.newArrayList();
        sortFields.add(new BeanComparator("effectiveTime", mycmp)); //id逆序  (主)
        //创建一个排序链
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        //开始真正的排序，按照先主，后副的规则
        Collections.sort(wxPayV3CertificateList, multiSort);
    }


}

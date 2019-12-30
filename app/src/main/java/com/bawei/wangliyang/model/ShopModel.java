package com.bawei.wangliyang.model;

import com.bawei.wangliyang.contract.IContract;
import com.bawei.wangliyang.util.NetUtil;

public class ShopModel implements IContract.IModel {
    @Override
    public void onGetData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getJsonGet("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                iModelCallback.onSuccess(json);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onFailure(throwable);
            }
        });
    }
}

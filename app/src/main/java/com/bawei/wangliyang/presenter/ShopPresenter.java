package com.bawei.wangliyang.presenter;

import com.bawei.wangliyang.base.BasePresenter;
import com.bawei.wangliyang.contract.IContract;
import com.bawei.wangliyang.model.ShopModel;

public class ShopPresenter extends BasePresenter<IContract.IView>implements IContract.IPresenter {
    public ShopModel shopModel;
    @Override
    protected void initModel() {
        shopModel = new ShopModel();
    }

    @Override
    public void onGetData() {
        shopModel.onGetData(new IContract.IModel.IModelCallback() {
             @Override
             public void onSuccess(String json) {
                view.onSuccess(json);
             }

             @Override
             public void onFailure(Throwable throwable) {
                 view.onFailure(throwable);
             }
         });
    }
}

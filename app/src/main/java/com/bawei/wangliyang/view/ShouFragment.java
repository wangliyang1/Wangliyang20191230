package com.bawei.wangliyang.view;

import android.view.View;
import android.widget.TextView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseFragment;
import com.bawei.wangliyang.contract.IContract;
import com.bawei.wangliyang.presenter.ShopPresenter;

public class ShouFragment extends BaseFragment<ShopPresenter>implements IContract.IView {

    private TextView shou_tv;

    @Override
    protected void initData() {
        mPresenter.onGetData();
    }

    @Override
    protected void initView(View infate) {
        shou_tv = infate.findViewById(R.id.shou_tv);
    }

    @Override
    protected ShopPresenter provitePresenter() {
        return new ShopPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.shou;
    }

    @Override
    public void onSuccess(String json) {
        shou_tv.setText(json);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}

package com.bawei.wangliyang.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangliyang.R;

public abstract class BaesActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(lauoutId());
        mPresenter = provitePresenter();
        if (mPresenter!=null){
            mPresenter.attech(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P provitePresenter();

    protected abstract int lauoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.defach();
        }
    }
}

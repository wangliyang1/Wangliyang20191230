package com.bawei.wangliyang.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        mPresenter = provitePresenter();
        if (mPresenter!=null){
            mPresenter.attech(this);
        }
        initView(inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View infate);

    protected abstract P provitePresenter();

    protected abstract int layoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.defach();
        }
    }
}

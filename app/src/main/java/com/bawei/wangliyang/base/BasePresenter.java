package com.bawei.wangliyang.base;

public abstract class BasePresenter<V> {
    public V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attech(V view) {
        this.view = view;
    }

    public void defach(){
        view = null;
    }
}

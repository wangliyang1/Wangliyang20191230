package com.bawei.wangliyang.contract;

public interface IContract {
    interface IView{
        void onSuccess(String json);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void onGetData();
    }
    interface IModel{
        void onGetData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(String json);
            void onFailure(Throwable throwable);
        }
    }
}

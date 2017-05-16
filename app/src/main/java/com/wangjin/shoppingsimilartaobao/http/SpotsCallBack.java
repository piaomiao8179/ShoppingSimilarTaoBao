package com.wangjin.shoppingsimilartaobao.http;

import android.content.Context;

import dmax.dialog.SpotsDialog;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created on 2017/5/2 and 11:49
 * 作者：王金
 * 邮箱:1002811532@qq.com
 * <p>
 * 作用:
 */

public class SpotsCallBack<T> extends MyCallBack<T> {

    private Context mContext;

    private SpotsDialog mDialog;

    public SpotsCallBack(Context context){

        mContext = context;

        initSpotsDialog();
    }



    private  void initSpotsDialog(){

        mDialog = new SpotsDialog(mContext,"拼命加载中...");

    }

    public  void showDialog(){
        mDialog.show();
    }

    public  void dismissDialog(){
        mDialog.dismiss();
    }


    public void setLoadMessage(int resId){
        mDialog.setMessage(mContext.getString(resId));
    }

    @Override
    public void onLoadingBefore(Request request) {
        showDialog();
    }

    @Override
    public void onSuccess(Response response, T result) {
        dismissDialog();
    }

    @Override
    public void onFailure(Request request, Exception e) {
        dismissDialog();
    }

    @Override
    public void onError(Response response) {
        dismissDialog();
    }
}

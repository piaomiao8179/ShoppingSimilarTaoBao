package com.wangjin.shoppingsimilartaobao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangjin.shoppingsimilartaobao.R;
import com.wangjin.shoppingsimilartaobao.http.MyCallBack;
import com.wangjin.shoppingsimilartaobao.http.OkHttpUtils;

import okhttp3.Request;
import okhttp3.Response;


public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return  inflater.inflate(R.layout.fragment_home,container,false);
    }


}

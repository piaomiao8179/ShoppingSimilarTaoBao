package com.wangjin.shoppingsimilartaobao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangjin.shoppingsimilartaobao.R;


public class MineFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return  inflater.inflate(R.layout.fragment_mine,container,false);
    }
}

package com.wangjin.shoppingsimilartaobao.http;

import com.google.gson.internal.$Gson$Types;

import java.lang.annotation.Repeatable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created on 2017/4/26 and 15:36
 * 作者：王金
 * 邮箱:1002811532@qq.com
 * <p>
 * 作用:创建接口进行连网操作的回调
 */

public abstract class MyCallBack<T> {


    public  Type mType;

    static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public MyCallBack() {
        mType = getSuperclassTypeParameter(getClass());
    }

    public abstract void onLoadingBefore(Request request);

    public abstract void onSuccess(Response response, T result);

    public abstract void onFailure(Request request, Exception e);

    public abstract void onError(Response response);

}

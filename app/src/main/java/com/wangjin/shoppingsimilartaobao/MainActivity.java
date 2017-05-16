package com.wangjin.shoppingsimilartaobao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.wangjin.shoppingsimilartaobao.bean.Tab;
import com.wangjin.shoppingsimilartaobao.fragment.CartFragment;
import com.wangjin.shoppingsimilartaobao.fragment.CategoryFragment;
import com.wangjin.shoppingsimilartaobao.fragment.HomeFragment;
import com.wangjin.shoppingsimilartaobao.fragment.HotFragment;
import com.wangjin.shoppingsimilartaobao.fragment.MineFragment;
import com.wangjin.shoppingsimilartaobao.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;

    private FragmentTabHost mTabHost;


    private List<Tab> mTabs = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化底部菜单栏
        initTab();

    }

    private void initTab() {
        // 利用javabean进行简单的封装
        Tab tab_home = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        Tab tab_hot = new Tab(HotFragment.class,R.string.hot,R.drawable.selector_icon_hot);
        Tab tab_category = new Tab(CategoryFragment.class,R.string.catagory,R.drawable.selector_icon_category);
        Tab tab_cart = new Tab(CartFragment.class,R.string.cart,R.drawable.selector_icon_cart);
        Tab tab_mine = new Tab(MineFragment.class,R.string.mine,R.drawable.selector_icon_mine);

        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));
            // 链接tab和fragment
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }
        // 设置分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        // 默认显示第一个
        mTabHost.setCurrentTab(0);

        // 设置tab改变监听
        mTabHost.setOnTabChangedListener(s -> System.out.println("===" + s));

    }


    private View buildIndicator(Tab tab){

        View view =mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return  view;
    }

}

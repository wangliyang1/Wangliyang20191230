package com.bawei.wangliyang.view;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaesActivity;
import com.bawei.wangliyang.presenter.ShopPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaesActivity {


    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.group)
    RadioGroup group;
    private List<Fragment>list = new ArrayList<>();

    @Override
    protected void initData() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        ShouFragment shouFragment = new ShouFragment();
        list.add(shouFragment);
        OtherFragment otherFragment1 = new OtherFragment();
        OtherFragment otherFragment2 = new OtherFragment();
        OtherFragment otherFragment3 = new OtherFragment();
        OtherFragment otherFragment4 = new OtherFragment();
        list.add(otherFragment1);
        list.add(otherFragment2);
        list.add(otherFragment3);
        list.add(otherFragment4);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.bt2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        pager.setCurrentItem(3);
                        break;
                    case R.id.bt5:
                        pager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ShopPresenter provitePresenter() {
        return null;
    }

    @Override
    protected int lauoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

package example.hyi.viewpagerindicatortest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.id_indicator)
    ViewPagerIndicator idIndicator;
    @Bind(R.id.vp)
    ViewPager vp;
    private List<String> array = Arrays.asList("短信", "收藏", "推荐","短信1","短信2");
    private List<ContentFragment> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        initDatas();
        FragmentManager fragmentManager = getSupportFragmentManager();
        vp.setAdapter(new FragmentAdapter(fragmentManager));
        //设置Tab上的标题
        idIndicator.setTabItemTitles(array);
        vp.setAdapter(new FragmentAdapter(fragmentManager));
//设置关联的ViewPager
        idIndicator.setViewPager(vp,0);
    }
    private void initDatas()
    {

        for (String data : array)
        {
            ContentFragment fragment = ContentFragment.newInstance(data);
            list.add(fragment);
        }
    }
    class FragmentAdapter extends FragmentPagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
    }
}

package dota.draftdota2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dota.draftdota2.Fragment.FragmentHome;
import dota.draftdota2.Fragment.FragmentHero;
import dota.draftdota2.Fragment.FragmentCounterHero;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_hero,
            R.drawable.ic_tab_counterhero
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons(){

        TextView tabHome = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);

        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_home, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabHome);


        TextView tabHero = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);

        tabHero.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_hero, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabHero);

        TextView tabCounterHero = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);

        tabCounterHero.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_counterhero, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabCounterHero);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentHome(), "Home");
        adapter.addFrag(new FragmentHero(), "Hero");
        adapter.addFrag(new FragmentCounterHero(), "Counter Hero");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }
}

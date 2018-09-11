package com.example.avimon.screenchanger;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager sliderViewPager;
    private LinearLayout dotLayout;

    private TextView[] dots;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderViewPager = findViewById(R.id.main_slideViewPager);
        dotLayout = findViewById(R.id.dots);

        sliderAdapter = new SliderAdapter(this);

        sliderViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        sliderViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position){
        dotLayout.removeAllViews();
        dots = new TextView[3];

        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(40);
            dots[i].setTextColor(getResources().getColor(R.color.transparentBlue));

            dotLayout.addView(dots[i]);
        }

        if(dots.length>0)
            dots[position].setTextColor(getResources().getColor(R.color.Blue));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}

package com.amankriet.virusishere.slideshow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class ImageAdapter extends PagerAdapter {

    Context context;
    ImageAdapter(Context context)
    {
        this.context=context;
    }

    private int[] SliderImageID = new int[]
            {
                    R.drawable.mickey_mouse, R.drawable.mike, R.drawable.new_mario,
                    R.drawable.simba, R.drawable.sun
            };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageview = new ImageView(context);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(SliderImageID[position]);
        container.addView(imageview, 0);
        return imageview;
    }

    @Override
    public int getCount() {
        return SliderImageID.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}

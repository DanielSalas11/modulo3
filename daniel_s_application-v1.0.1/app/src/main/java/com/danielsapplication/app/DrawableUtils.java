package com.danielsapplication.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import androidx.core.content.ContextCompat;

import com.applandeo.materialcalendarview.CalendarUtils;
//import com.applandeo.materialcalendarview.utils.DayColorsUtils;

public final class DrawableUtils {

    public static Drawable getImageWithText(Context context, String string) {
        Drawable background = ContextCompat.getDrawable(context, R.color.black);
        Drawable text = CalendarUtils.getDrawableText(context, string, null, android.R.color.white, 12);

        Drawable[] layers = {background, text};
        return new LayerDrawable(layers);
    }
//
//    public static Drawable getThreeDots(Context context) {
//        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_three_icons);
//
//        //Add padding to too large icon
//        return new InsetDrawable(drawable, 100, 0, 100, 0);
//    }
//
//    public static Drawable getDayCircle(Context context, @ColorRes int borderColor, @ColorRes int fillColor) {
//        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(context, R.drawable.calendar_day_background);
//        drawable.setStroke(6, DayColorsUtils.parseColor(context, borderColor));
//        drawable.setColor(DayColorsUtils.parseColor(context, fillColor));
//        return drawable;
//    }
//
//    private DrawableUtils() {
//    }
}
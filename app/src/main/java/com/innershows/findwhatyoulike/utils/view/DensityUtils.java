package com.innershows.findwhatyoulike.utils.view;

import android.content.Context;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class DensityUtils {
    public static int screenWidth(Context ctx) {
        return ctx.getResources().getDisplayMetrics().widthPixels;
    }


    public static int dp2px(int dp, Context ctx) {
        //px = dp * (dpi/160)
        return (int) (dp * (ctx.getResources().getDisplayMetrics().density) + 0.5);
    }

}

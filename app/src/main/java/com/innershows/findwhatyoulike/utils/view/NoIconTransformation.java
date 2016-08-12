package com.innershows.findwhatyoulike.utils.view;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.squareup.picasso.Transformation;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class NoIconTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();

        int[] pixels = new int[width * height];

        source.getPixels(pixels, 0, width, 0, 0, width, height);

        for (int i = height - 30; i < height; i++) {
            int index = i * width;
            //将又下角做简单的处理
            //在下面30像素的样子
            for (int j = width - 120; j < width; j++) {
                //在右边120像素的样子
                //int pixel = pixels[index + j];
                int lastPx = pixels[(index + j) - 30 * width];

                /**
                 * 0  1  2  3   4
                 * 5  6  7  8   9
                 * 10 11 12 13 14
                 * 15 16 17 18 19
                 */

                pixels[index + j] = Color.argb(
                        Color.alpha(lastPx), Color.red(lastPx), Color.green(lastPx), Color.blue(lastPx));
                // pixels[index + j] = Color.BLACK;
            }
        }
        source.recycle();
        Bitmap ret = Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);

        return ret;
    }

    @Override
    public String key() {
        return "deleteLogo";
    }
}

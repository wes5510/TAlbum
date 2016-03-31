package kr.wes.talbum.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import kr.wes.talbum.model.Image;

/**
 * Created by wes on 16. 3. 31.
 */
public abstract class SampledBitmapDecoder {
    public abstract Bitmap decodeSampledBitmap(String address, int reqWidth, int reqHeight);

    protected int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}

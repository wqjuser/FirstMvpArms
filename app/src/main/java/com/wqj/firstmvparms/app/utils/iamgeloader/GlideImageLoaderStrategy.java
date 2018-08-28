package com.wqj.firstmvparms.app.utils.iamgeloader;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.jess.arms.http.imageloader.BaseImageLoaderStrategy;

/**
 * @author 温清洁
 * @package com.wqj.firstmvparms.app.utils.iamgeloader
 * @fileName GlideImageLoaderStrategy
 * @date on 2018/8/28 9:37
 * @describe TODO
 * @email wqjuser@gmail.com
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<GlideImageConfig> {
    @Override
    public void loadImage(Context ctx, GlideImageConfig config) {
        Glide.with(ctx)
                .load(config.getUrl())
                .into(config.getImageView());
    }

    @Override
    public void clear(Context ctx, GlideImageConfig config) {

    }
}

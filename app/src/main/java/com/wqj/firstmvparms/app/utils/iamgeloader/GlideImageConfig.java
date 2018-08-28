package com.wqj.firstmvparms.app.utils.iamgeloader;

import android.widget.ImageView;

import com.jess.arms.http.imageloader.ImageConfig;

/**
 * @author 温清洁
 * @package com.wqj.firstmvparms.app.utils.iamgeloader
 * @fileName GlideImageConfig
 * @date on 2018/8/28 9:36
 * @describe TODO
 * @email wqjuser@gmail.com
 */
public class GlideImageConfig extends ImageConfig {

    private GlideImageConfig(Buidler builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.errorPic = builder.errorPic;
    }

    public static Buidler builder() {
        return new Buidler();
    }


    public static final class Buidler {
        private String url;
        private ImageView imageView;
        private int placeholder;
        protected int errorPic;

        private Buidler() {
        }

        public Buidler url(String url) {
            this.url = url;
            return this;
        }

        public Buidler placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Buidler errorPic(int errorPic){
            this.errorPic = errorPic;
            return this;
        }

        public Buidler imagerView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public GlideImageConfig build() {
            if (url == null) throw new IllegalStateException("url is required");
            if (imageView == null) throw new IllegalStateException("imageview is required");
            return new GlideImageConfig(this);
        }
    }
}

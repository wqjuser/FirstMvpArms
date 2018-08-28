package com.wqj.firstmvparms.mvp.presenter

import android.app.Application
import com.bumptech.glide.Glide
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.utils.ArmsUtils
import com.wqj.firstmvparms.mvp.contract.MainContract
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class MainPresenter
@Inject
constructor(model: MainContract.Model, rootView: MainContract.View) :
        BasePresenter<MainContract.Model, MainContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager


    override fun onDestroy() {
        super.onDestroy();
    }

    fun loadImage() {

    }
}

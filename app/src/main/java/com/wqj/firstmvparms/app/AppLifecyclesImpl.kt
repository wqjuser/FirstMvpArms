package com.wqj.firstmvparms.app

import android.app.Application
import android.content.Context

import com.jess.arms.base.delegate.AppLifecycles
import com.jess.arms.utils.ArmsUtils
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

import butterknife.ButterKnife

import com.wqj.firstmvparms.BuildConfig

import timber.log.Timber

/**
 * ================================================
 * 展示 [AppLifecycles] 的用法
 *
 *
 * Created by MVPArmsTemplate
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
class AppLifecyclesImpl : AppLifecycles {

    override fun attachBaseContext(base: Context) {
        //          MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化
    }

    override fun onCreate(application: Application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        if (BuildConfig.LOG_DEBUG) {//Timber初始化
            //Timber 是一个日志框架容器,外部使用统一的Api,内部可以动态的切换成任何日志框架(打印策略)进行日志打印
            //并且支持添加多个日志框架(打印策略),做到外部调用一次 Api,内部却可以做到同时使用多个策略
            //比如添加三个策略,一个打印日志,一个将日志保存本地,一个将日志上传服务器
            Timber.plant(Timber.DebugTree())
            // 如果你想将框架切换为 Logger 来打印日志,请使用下面的代码,如想切换为其他日志框架请根据下面的方式扩展
            //                    Logger.addLogAdapter(new AndroidLogAdapter());
            //                    Timber.plant(new Timber.DebugTree() {
            //                        @Override
            //                        protected void log(int priority, String tag, String message, Throwable t) {
            //                            Logger.log(priority, tag, message, t);
            //                        }
            //                    });
            ButterKnife.setDebug(true)
        }
        //LeakCanary 内存泄露检查
        ArmsUtils.obtainAppComponentFromContext(application).extras().put(RefWatcher::class.java.name, if (BuildConfig.USE_CANARY) LeakCanary.install(application) else RefWatcher.DISABLED)
        //扩展 AppManager 的远程遥控功能
        //        ArmsUtils.obtainAppComponentFromContext(application).appManager().setHandleListener((appManager, message) -> {
        //            switch (message.what) {
        //case 0:
        //do something ...
        //   break;
        //            }
        //        });
        //Usage:
        //Message msg = new Message();
        //msg.what = 0;
        //AppManager.post(msg); like EventBus
    }

    override fun onTerminate(application: Application) {

    }
}

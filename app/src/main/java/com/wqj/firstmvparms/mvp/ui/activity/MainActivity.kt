package com.wqj.firstmvparms.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.wqj.firstmvparms.R
import com.wqj.firstmvparms.di.component.DaggerMainComponent
import com.wqj.firstmvparms.di.module.MainModule
import com.wqj.firstmvparms.mvp.contract.MainContract
import com.wqj.firstmvparms.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        bindListener()
    }

    private fun bindListener() {
        btn_click.setOnClickListener { mPresenter!!.loadImage() }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}

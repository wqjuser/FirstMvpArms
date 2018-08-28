package com.wqj.firstmvparms.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.wqj.firstmvparms.di.module.MainModule

import com.jess.arms.di.scope.ActivityScope
import com.wqj.firstmvparms.mvp.ui.activity.MainActivity

@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}

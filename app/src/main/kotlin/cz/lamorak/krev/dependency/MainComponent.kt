package cz.lamorak.krev.dependency

import cz.lamorak.krev.MainActivity
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by ondrej on 15.6.2017.
 */
@Singleton
@Component(modules = arrayOf(MainModule::class, RetrofitModule::class))
interface MainComponent : AndroidInjector<MainActivity>
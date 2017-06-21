package cz.lamorak.krev

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cz.lamorak.krev.dependency.DaggerMainComponent
import cz.lamorak.krev.viewmodel.ListingViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: ListingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

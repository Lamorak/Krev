package cz.lamorak.krev

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cz.lamorak.krev.adapter.PostsAdapter
import cz.lamorak.krev.databinding.ActivityMainBinding
import cz.lamorak.krev.dependency.DaggerMainComponent
import cz.lamorak.krev.viewmodel.ListingViewModel
import cz.lamorak.krev.viewmodel.model.DisplayablePost
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var disposables : CompositeDisposable
    @Inject lateinit var viewModel: ListingViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        disposables = CompositeDisposable()
        disposables.add(
                viewModel.postsNew()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::displayPosts)
        )
    }

    override fun onStop() {
        super.onStop()
        disposables.dispose()
    }

    fun displayPosts(posts: List<DisplayablePost>) {
        val layoutManager = LinearLayoutManager(this)
        val adapter = PostsAdapter(posts)
        with(binding) {
            listingRecycler.layoutManager = layoutManager
            listingRecycler.adapter = adapter
        }
    }
}

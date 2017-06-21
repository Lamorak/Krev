package cz.lamorak.krev.viewmodel

import cz.lamorak.krev.datamodel.ListingDataModel
import cz.lamorak.krev.model.Post
import cz.lamorak.krev.viewmodel.model.DisplayablePost
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by ondrej on 15.6.2017.
 */
class ListingViewModelImpl
@Inject constructor(private val dataModel: ListingDataModel,
                    private val displayablePostMapper: Function<Post, DisplayablePost>) : ListingViewModel {

    override fun postsNew(): Observable<List<DisplayablePost>> {
        return dataModel.postsNew()
                .map { posts -> posts.map(displayablePostMapper::apply) }
    }
}
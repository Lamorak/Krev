package cz.lamorak.krev.viewmodel

import cz.lamorak.krev.viewmodel.model.DisplayablePost
import io.reactivex.Observable

/**
 * Created by ondrej on 15.6.2017.
 */
interface ListingViewModel {

    fun postsNew() : Observable<List<DisplayablePost>>
}
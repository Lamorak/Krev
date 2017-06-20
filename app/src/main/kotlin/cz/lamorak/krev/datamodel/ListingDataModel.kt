package cz.lamorak.krev.datamodel

import cz.lamorak.krev.model.Post
import io.reactivex.Observable

/**
 * Created by ondrej on 15.6.2017.
 */
interface ListingDataModel {

    fun postsNew(): Observable<List<Post>>
}
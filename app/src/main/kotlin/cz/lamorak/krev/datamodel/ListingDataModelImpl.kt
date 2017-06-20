package cz.lamorak.krev.datamodel

import cz.lamorak.krev.service.ListingService
import cz.lamorak.krev.model.Listing
import cz.lamorak.krev.model.Post
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ondrej on 15.6.2017.
 */
class ListingDataModelImpl @Inject constructor(private val service: ListingService) : ListingDataModel {

    override fun postsNew(): Observable<List<Post>> {
        return service.getNewItems()
                .map { (data) -> data.children.map(Listing.PostItem::data) }
                .toObservable()
    }
}
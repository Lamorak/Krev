package cz.lamorak.krev

import cz.lamorak.krev.model.Listing
import cz.lamorak.krev.service.ListingService
import io.reactivex.Maybe

/**
 * Created by ondrej on 20.6.2017.
 */
class MockListingService : ListingService {

    val helper = MockHelper()

    override fun getNewItems(subreddit: String): Maybe<Listing> {
        return Maybe.fromCallable { helper.readJson("listing.json", Listing::class.java) }
    }
}
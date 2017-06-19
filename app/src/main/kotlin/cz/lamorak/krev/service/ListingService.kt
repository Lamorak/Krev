package cz.lamorak.krev.service

import cz.lamorak.krev.model.Listing
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ondrej on 15.6.2017.
 */
interface ListingService {

    @GET("{subreddit}/new.json")
    fun getNewItems(@Path("subreddit") subreddit: String = "") : Maybe<Listing>
}
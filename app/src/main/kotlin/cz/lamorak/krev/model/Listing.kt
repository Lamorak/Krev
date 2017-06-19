package cz.lamorak.krev.model

/**
 * Created by ondrej on 15.6.2017.
 */
data class Listing(val data: ListingData) {

    data class ListingData(
            val modhash: String?,
            val children: List<PostItem>,
            val after: String?,
            val before: String?
    )

    data class PostItem (val data: Post)
}
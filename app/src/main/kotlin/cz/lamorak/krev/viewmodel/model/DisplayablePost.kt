package cz.lamorak.krev.viewmodel.model

/**
 * Created by ondrej on 15.6.2017.
 */
data class DisplayablePost (
        val id: String,
        val author: String,
        val title: String,
        val subredditName: String,
        val contentHtml: String,
        val commentsCount: Int,
        val score: Int,
        val created: String,
        val thumbnail: String,
        val url: String
)
package cz.lamorak.krev.viewmodel.mapper

import cz.lamorak.krev.model.Post
import cz.lamorak.krev.viewmodel.model.DisplayablePost
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by ondrej on 15.6.2017.
 */
class DisplayablePostMapper @Inject constructor(private val dateMapper: Function<Long, String>,
                                                private val htmlMaper: Function<String?, String?>) : Function<Post, DisplayablePost> {

    override fun apply(post: Post): DisplayablePost {
        return DisplayablePost(
                id = post.id,
                author = post.author,
                title = post.title,
                subredditName = post.subreddit_name_prefixed,
                contentHtml = htmlMaper.apply(post.selftext_html),
                commentsCount = post.num_comments,
                score = post.score,
                created = dateMapper.apply(post.created),
                thumbnail = post.thumbnail,
                url = post.url
        )
    }
}
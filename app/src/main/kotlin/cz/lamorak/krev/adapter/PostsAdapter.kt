package cz.lamorak.krev.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import cz.lamorak.krev.R
import cz.lamorak.krev.databinding.ItemPostBinding
import cz.lamorak.krev.viewmodel.model.DisplayablePost

/**
 * Created by ondrej on 29.6.2017.
 */
class PostsAdapter(private val posts: List<DisplayablePost>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ItemPostBinding>(layoutInflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: DisplayablePost) {
            binding.post = post
        }
    }
}
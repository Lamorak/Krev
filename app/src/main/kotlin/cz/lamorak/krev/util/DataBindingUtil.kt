package cz.lamorak.krev.util

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.os.Build
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by ondrej on 17.7.2017.
 */

object DataBindingUtil {

    @JvmStatic @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.with(imageView.context)
                .load(url)
                .into(imageView)
    }

    @JvmStatic @BindingConversion
    fun booleanToVisibility(visible: Boolean): Int {
        return if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic @BindingAdapter("html")
    fun displayHtml(textView: TextView, htmlString: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(htmlString ?: "", Html.FROM_HTML_MODE_LEGACY)
        } else {
            textView.text = Html.fromHtml(htmlString ?: "")
        }
    }
}
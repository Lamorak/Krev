package cz.lamorak.krev.viewmodel.mapper

import android.os.Build
import android.text.Html
import io.reactivex.functions.Function

/**
 * Created by ondrej on 18.7.2017.
 */
class HtmlStringMapper : Function<String?, String?> {

    override fun apply(encodedHtml: String?): String? {
        if (encodedHtml == null) return null

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            return Html.fromHtml(encodedHtml, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            return Html.fromHtml(encodedHtml).toString()
        }
    }
}
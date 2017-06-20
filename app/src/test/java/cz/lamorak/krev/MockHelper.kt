package cz.lamorak.krev

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okio.BufferedSource
import okio.Okio
import java.io.File

/**
 * Created by ondrej on 20.6.2017.
 */
class MockHelper {

    fun <T> readJson(filename: String, readClass: Class<T>): T {
        val jsonFile = readFile(filename)
        val adapter = createMoshiAdapter(readClass)
        return adapter.fromJson(bufferFile(jsonFile))
    }

    private fun readFile(filename: String): File {
        val fileUrl = javaClass.classLoader.getResource(filename)
        return File(fileUrl.path)
    }

    private fun <T> createMoshiAdapter(adapterClass: Class<T>): JsonAdapter<T> {
        return Moshi.Builder().build()
                .adapter(adapterClass)
    }

    private fun bufferFile(file: File): BufferedSource {
        val source = Okio.source(file)
        return Okio.buffer(source)
    }
}

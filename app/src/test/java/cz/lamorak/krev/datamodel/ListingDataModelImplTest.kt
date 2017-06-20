package cz.lamorak.krev.datamodel

import cz.lamorak.krev.MockListingService
import cz.lamorak.krev.model.Post
import cz.lamorak.krev.service.ListingService
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

/**
 * Created by ondrej on 20.6.2017.
 */
class ListingDataModelImplTest {

    lateinit var service: ListingService
    lateinit var dataModel: ListingDataModel

    @Before
    fun setUp() {
        service = MockListingService()
        dataModel = ListingDataModelImpl(service)
    }

    @Test
    fun postsNew() {
        val observer = TestObserver<List<Post>>()

        dataModel.postsNew()
                .subscribe(observer)

        observer.assertSubscribed()
        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertValueCount(1)
        observer.assertValueAt(0, { !it.isEmpty() })
    }

}
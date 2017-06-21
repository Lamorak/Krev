package cz.lamorak.krev.viewmodel

import cz.lamorak.krev.datamodel.ListingDataModel
import cz.lamorak.krev.model.Post
import cz.lamorak.krev.viewmodel.model.DisplayablePost
import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by ondrej on 20.6.2017.
 */
@RunWith(MockitoJUnitRunner::class)
class ListingViewModelImplTest {

    @Mock
    lateinit var dataModel: ListingDataModel
    @Mock
    lateinit var displayableMapper: Function<Post, DisplayablePost>
    lateinit var viewModel: ListingViewModel

    @Before
    fun setUp() {
        viewModel = ListingViewModelImpl(dataModel, displayableMapper)
    }

    @Test
    fun postsNew() {
        val mockPost = mock(Post::class.java)
        `when`(dataModel.postsNew()).thenReturn(Observable.just(listOf(mockPost)))
        `when`(displayableMapper.apply(any())).thenReturn(mock(DisplayablePost::class.java))

        val observer = TestObserver<List<DisplayablePost>>()

        viewModel.postsNew()
                .subscribe(observer)

        observer.assertSubscribed()
        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertValueCount(1)
        observer.assertValueAt(0) { !it.isEmpty() }

        verify(dataModel).postsNew()
        verify(displayableMapper).apply(any(Post::class.java))
    }
}
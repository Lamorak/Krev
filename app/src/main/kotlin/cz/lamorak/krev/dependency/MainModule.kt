package cz.lamorak.krev.dependency

import cz.lamorak.krev.datamodel.ListingDataModel
import cz.lamorak.krev.datamodel.ListingDataModelImpl
import cz.lamorak.krev.service.ListingService
import cz.lamorak.krev.model.Post
import cz.lamorak.krev.viewmodel.model.DisplayablePost
import cz.lamorak.krev.viewmodel.ListingViewModel
import cz.lamorak.krev.viewmodel.ListingViewModelImpl
import cz.lamorak.krev.viewmodel.mapper.TimestampDateMapper
import cz.lamorak.krev.viewmodel.mapper.DisplayablePostMapper
import dagger.Module
import dagger.Provides
import io.reactivex.functions.Function
import retrofit2.Retrofit

/**
 * Created by ondrej on 15.6.2017.
 */
@Module
class MainModule {

    @Provides
    fun provideViewModel(dataModel: ListingDataModel, displayablePostMapper: Function<Post, DisplayablePost>) : ListingViewModel {
        return ListingViewModelImpl(dataModel, displayablePostMapper)
    }

    @Provides
    fun provideDisplayablePostMapper(dateMapper: Function<Long, String>) : Function<Post, DisplayablePost> {
        return DisplayablePostMapper(dateMapper)
    }

    @Provides
    fun provideDateMapper() : Function<Long, String> {
        return TimestampDateMapper()
    }

    @Provides
    fun provideDataModel(service: ListingService) : ListingDataModel {
        return ListingDataModelImpl(service)
    }

    @Provides
    fun provideService(retrofit: Retrofit): ListingService {
        return retrofit.create(ListingService::class.java)
    }
}
package abn.assessment.kees.di

import abn.assessment.kees.AbnAssessmentViewModel
import abn.assessment.kees.data.api.FourSquareService
import abn.assessment.kees.data.repo.FourSquareRepo
import abn.assessment.kees.data.repo.IFourSquareRepo
import abn.assessment.kees.data.room.AppRoomDatabase
import abn.assessment.kees.domain.usecase.GetFourSquareVenueDetail
import abn.assessment.kees.domain.usecase.GetFourSquareVenues
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val abnAssessmentModule = module {

    single<AppRoomDatabase> {
        Room.databaseBuilder(androidContext(), AppRoomDatabase::class.java, "room-db").build()
    }

    single<FourSquareService> {
        FourSquareService.create()
    }

    single<IFourSquareRepo> {
       FourSquareRepo(get())
    }

    single<GetFourSquareVenues> {
        GetFourSquareVenues(get())
    }

    single<GetFourSquareVenueDetail> {
        GetFourSquareVenueDetail(get())
    }

    viewModel {
        AbnAssessmentViewModel(get(), get())
    }

}

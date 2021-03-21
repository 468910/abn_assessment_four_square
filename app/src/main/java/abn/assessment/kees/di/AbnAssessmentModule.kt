package abn.assessment.kees.di

import abn.assessment.kees.AbnAssessmentViewModel
import abn.assessment.kees.data.api.FourSquareService
import abn.assessment.kees.data.api.repo.FourSquareRepo
import abn.assessment.kees.data.api.repo.IFourSquareRepo
import abn.assessment.kees.domain.usecase.GetFourSquareVenueDetail
import abn.assessment.kees.domain.usecase.GetFourSquareVenues
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val abnAssessmentModule = module {

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

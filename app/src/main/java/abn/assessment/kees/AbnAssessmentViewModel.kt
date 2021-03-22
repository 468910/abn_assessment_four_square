package abn.assessment.kees

import abn.assessment.kees.domain.models.Venue
import abn.assessment.kees.domain.usecase.GetFourSquareVenueDetail
import abn.assessment.kees.domain.usecase.GetFourSquareVenues
import abn.assessment.kees.ui.model.FourSquareVenueUIModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.*

/**
 * Using one viewmodel for convenience
 */
class AbnAssessmentViewModel(
    private val getFourSquareVenues: GetFourSquareVenues,
    private val getFourSquareVenueDetail: GetFourSquareVenueDetail
) : ViewModel() {

    val filter = MutableStateFlow<String>("Amsterdam")

    val venues: LiveData<List<FourSquareVenueUIModel>> = filter.flatMapLatest {
        getFourSquareVenues.searchRevenues(city = it)
    }.map {
        return@map it.map { FourSquareVenueUIModel.map(it) }
    }.catch {
        // TODO
    }.asLiveData()


    val selectedVenueId = MutableStateFlow<String>("")

    val venue : LiveData<Venue> = selectedVenueId.filter { it.isNotEmpty() }.flatMapLatest {
        getFourSquareVenueDetail.getRevenueDetail(it)
    }.catch {
       // TODO
    }.asLiveData()

}
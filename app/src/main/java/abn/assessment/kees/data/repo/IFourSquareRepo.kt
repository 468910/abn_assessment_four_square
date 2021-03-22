package abn.assessment.kees.data.repo

import abn.assessment.kees.domain.models.Venue
import kotlinx.coroutines.flow.Flow

interface IFourSquareRepo {

    fun searchRevenues(
        city: String
    ): Flow<List<Venue>>

    suspend fun getRevenueDetail(venueId: String) : Flow<Venue>
}
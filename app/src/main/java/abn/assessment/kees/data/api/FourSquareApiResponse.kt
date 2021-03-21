package abn.assessment.kees.data.api

import abn.assessment.kees.domain.models.Venue

data class FourSquareApiResponse<T>(
    val meta : Meta,
    val response: T
)

data class FourSquareVenues(
    val venues: List<Venue>
)

data class FourSquareVenueDetail(
    val venue: Venue
)

data class Meta(
    val code: Int,
    val requestId: String
)

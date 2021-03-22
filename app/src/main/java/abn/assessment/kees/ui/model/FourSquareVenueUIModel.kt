package abn.assessment.kees.ui.model

import abn.assessment.kees.domain.models.Venue

data class FourSquareVenueUIModel(
    val id: String,
    val name: String,
    val location: String
) {
    companion object {
        fun map(venue: Venue) : FourSquareVenueUIModel{
           return FourSquareVenueUIModel(
               id = venue.id,
               name = venue.name,
               location = venue.location.city ?: ""
           )
        }
    }
}

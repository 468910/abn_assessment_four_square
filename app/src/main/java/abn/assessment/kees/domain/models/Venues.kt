package abn.assessment.kees.domain.models

import abn.assessment.kees.data.room.VenueRoomModel

data class Venue(
    val id: String,
    val name: String,
    val location: Location,
    val categories: List<Category>,
    // Detail
    val rating: String?,
    val contact: Contact? = null
) {
    companion object {
        fun mapFrom(roomModel : VenueRoomModel) : Venue{
           return Venue(
              id = roomModel.id,
              name = roomModel.name,
              location = Location(
                  lat = 0.0,
                  lng = 0.0,
                  cc = "",
                  city = "",
                  country = "",
                  formattedAddress = emptyList(),
                  address = roomModel.address ?: ""
              ),
               categories = emptyList(),
               rating = roomModel.rating,
           )
        }
    }
}



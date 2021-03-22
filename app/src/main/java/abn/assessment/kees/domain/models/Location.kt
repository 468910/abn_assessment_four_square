package abn.assessment.kees.domain.models

data class Location(
    val address: String,
    val lat: Double,
    val lng: Double,
    val cc: String,
    val city: String,
    val country: String,
    val formattedAddress: List<String>
)


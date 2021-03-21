package abn.assessment.kees.data.models

data class Location(
    val lat: Double,
    val lng: Double,
    val cc: String,
    val country: String,
    val formattedAddress: List<String>
)


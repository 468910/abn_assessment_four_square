package abn.assessment.kees.domain.models

data class Location(
    val address: String,
    val lat: Double,
    val lng: Double,
    val cc: String,
    // Can be null for some reason
    val city: String? = null,
    val country: String,
    val formattedAddress: List<String>
)


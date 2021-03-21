package abn.assessment.kees.data.models

data class Venue(
    val id: String,
    val name: String,
    val location: Location,
    val categories: List<Category>,
)


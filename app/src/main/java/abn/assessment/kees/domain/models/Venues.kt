package abn.assessment.kees.domain.models

data class Venue(
    val id: String,
    val name: String,
    val location: Location,
    val categories: List<Category>,
)


package abn.assessment.kees.domain.models

data class BestPhoto(
    val prefix: String,
    val suffix: String
) {
    fun getImageUrl() : String {
       return prefix + "original" + suffix
    }
}
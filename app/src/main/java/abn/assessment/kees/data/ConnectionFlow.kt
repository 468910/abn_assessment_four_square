package abn.assessment.kees.data

import kotlinx.coroutines.flow.Flow

interface ConnectionFlow {
    fun getFlow() : Flow<Boolean>
}
package domain

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.simple.SimpleScore

// Should have a parameterless constructor to create a planning clone.
// In Kotlin, providing default values for the primary constructor creates a parameterless constructor for the JVM.
@PlanningSolution
class NQueens constructor(val id: Int = -1,
                          val N: Int = -1,
                          @field:PlanningEntityCollectionProperty val queenList: List<Queen> = emptyList(),
                          @field:ValueRangeProvider(id = "rowRange") val rowList: List<Row> = emptyList(),
                          @field:ProblemFactCollectionProperty val columnList: List<Column> = emptyList()) {

    @PlanningScore
    lateinit var score: SimpleScore
}

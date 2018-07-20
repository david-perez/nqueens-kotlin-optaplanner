package domain

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory
import kotlin.math.absoluteValue

data class Column(val id: Int, val index: Int)
data class Row(val id:Int, val index: Int)

// Should have a parameterless constructor to create a planning clone.
// In Kotlin, providing default values for the primary constructor creates a parameterless constructor for the JVM.
@PlanningEntity(difficultyWeightFactoryClass = QueenDifficultyWeightFactory::class)
class Queen(val id: String = "",
            @field:PlanningVariable(valueRangeProviderRefs = arrayOf("rowRange")) var row: Row? = null,
            val column: Column = Column(-1, -1)) {

    val ascendingDiagonalIndex: Int?
        get() = if (row != null) column.index + row!!.index else null

    val descendingDiagonalIndex: Int?
        get() = if (row != null) column.index - row!!.index else null

    override fun toString(): String = "Queen(id=$id)"
}

// We need planning entity difficulty comparison in order to use first fit decreasing
// construction heuristics.
class QueenDifficultyWeightFactory : SelectionSorterWeightFactory<NQueens, Queen> {
    override fun createSorterWeight(problem: NQueens, queen: Queen): Comparable<QueenDifficultyWeight> {
        val distanceFromMiddle = calculateDistanceFromMiddle(problem.N, queen.column.index)
        return QueenDifficultyWeight(queen, distanceFromMiddle)
    }

    private fun calculateDistanceFromMiddle(n: Int, columnIndex: Int): Int {
        val middle = n / 2
        var distanceFromMiddle = (columnIndex - middle).absoluteValue
        if (n % 2 == 0 && columnIndex < middle) {
            distanceFromMiddle--
        }
        return distanceFromMiddle
    }

    class QueenDifficultyWeight(val queen: Queen, val distanceFromMiddle: Int) : Comparable<QueenDifficultyWeight> {
        // Return a negative integer, zero, or a positive integer as the first argument is less than,
        // equal to, or greater than the second.
        // Difficulty should be implemented ascending: easy entities are lower, difficult entities are higher.
        override fun compareTo(other: QueenDifficultyWeight): Int = when {
            // The middle queens are more difficult to fit on the board.
            distanceFromMiddle != other.distanceFromMiddle -> other.distanceFromMiddle - distanceFromMiddle
            else -> queen.column.index - other.queen.column.index // Tie breaker.
        }
    }
}

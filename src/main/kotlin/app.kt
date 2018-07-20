import domain.Column
import domain.NQueens
import domain.Queen
import domain.Row
import org.optaplanner.core.api.solver.Solver
import org.optaplanner.core.api.solver.SolverFactory
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("org.optaplanner")

fun main(args: Array<String>) {
    val solverFactory: SolverFactory<NQueens> = SolverFactory.createFromXmlResource(
            "solverConfig.xml")
    val solver: Solver<NQueens> = solverFactory.buildSolver()

    val unsolvedNQueens = generateNQueens(20)

    val solvedNueens = solver.solve(unsolvedNQueens)

    println(toDisplayString(solvedNueens))

    logger.info("Done")
}

fun generateNQueens(n: Int): NQueens {
    val rowList = (0 until n).map { Row(it, it) }
    val columnList = (0 until n).map { Column(it, it) }
    val queenList = (0 until n).zip(columnList) { i, column -> Queen(i.toString(), null, column) }

    return NQueens(0, n, queenList, rowList, columnList)
}

fun toDisplayString(nQueens: NQueens): String {
    val displayString = StringBuilder()
    val n = nQueens.N
    val queenList = nQueens.queenList
    for (row in 0 until n) {
        for (column in 0 until n) {
            val queen = queenList[column]
            if (queen.column.index != column) {
                throw IllegalStateException("The queenList is not in the expected order.")
            }
            displayString.append(" ")
            if (queen.row != null && queen.row!!.index == row) {
                displayString.append("Q")
            } else {
                displayString.append("_")
            }
        }
        displayString.append("\n")
    }
    return displayString.toString()
}

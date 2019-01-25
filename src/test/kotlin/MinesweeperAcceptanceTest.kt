import org.junit.Assert.assertEquals
import org.junit.Test

class MinesweeperAcceptanceTest {

    @Test
    fun shouldProduceCorrectOutput() {
        var input = "4 4\n" +
                "*...\n" +
                "....\n" +
                ".*..\n" +
                "....\n" +
                "3 5\n" +
                "**...\n" +
                ".....\n" +
                ".*...\n" +
                "0 0"

        val board = Minesweeper(input)
        val actualOutput = board.play()

        val expectedOutput = "Field #1:\n" +
                "*100\n" +
                "2210\n" +
                "1*10\n" +
                "1110\n" +
                "\n" +
                "Field #2:\n" +
                "**100\n" +
                "33200\n" +
                "1*100\n"

        assertEquals(expectedOutput, actualOutput)
    }
}
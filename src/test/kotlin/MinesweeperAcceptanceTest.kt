import org.junit.Assert.assertEquals
import org.junit.Test

class MinesweeperAcceptanceTest {

    @Test
    fun shouldProduceCorrecOutput() {
        val input = "*...\n" +
                "....\n" +
                ".*..\n" +
                "....";


        val board = Minesweeper(input)
        val actualOutput = board.execute()

        val expectedOutput = "*100\n" +
                "2210\n" +
                "1*10\n" +
                "1110"

        assertEquals(expectedOutput, actualOutput)
    }
}
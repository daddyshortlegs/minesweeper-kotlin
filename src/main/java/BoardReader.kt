data class Dimensions(val width: Int, val height: Int)


class BoardReader {
    fun read(input: String): Board {
        if (input.isEmpty()) {
            throw NoBoardsException()
        }

        val lines = cleanUpInput(input)


        var index = 0
        val line = lines[index]
        val height = readDimensions(line)
        index++

        val board = readBoard(index, height, lines)
        index+=height

        return board
    }

    private fun cleanUpInput(input: String): List<String> {
        val trimEnd = input.trimEnd('\n')
        return trimEnd.split("\n")
    }

    private fun readDimensions(line: String): Int {
        val regex = Regex("([0-9]) ([0-9])")
        if (regex.matches(line)) {
            // is header
            val result = regex.find(line)
            if (result != null) {
                var (width, height) = result.destructured
                return height.toInt()
            }
        }
        return 0
    }

    private fun readBoard(index: Int, height: Int, lines: List<String>): Board {
        var board = ""
        for (i in index until index + height) {
            board += lines[i] + "\n"
        }

        return Board(board)
    }


}


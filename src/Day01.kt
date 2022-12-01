fun main() {
    fun part1(input: List<String>) = getElfCalories(input).max()

    fun part2(input: List<String>) = getElfCalories(input).sortedDescending().take(3).sum()

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24_000)
    check(part2(testInput) == 45_000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

// helper function(s)
fun getElfCalories(input: List<String>) = sequence {
    var inventoryCalories = 0
    input.map { it.toIntOrNull() }
        .forEach {
            if (it != null)
                inventoryCalories += it
            else {
                yield(inventoryCalories)
                inventoryCalories = 0
            }
        }
    yield(inventoryCalories)
}

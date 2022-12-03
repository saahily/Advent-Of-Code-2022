fun main() {
  fun part1(input: List<String>) = input
    .map { rucksack -> rucksack.chunked(rucksack.length / 2) }
    .sumOf { sharedItemTypePriority(it) }

  fun part2(input: List<String>) = input
    .chunked(3)
    .sumOf { sharedItemTypePriority(it) }

  val testInput = readInput("Day03_test")
  part1(testInput)
  check(part1(testInput) == 157)
  check(part2(testInput) == 70)

  val input = readInput("Day03")
  println(part1(input))
  println(part2(input))
}

// helper function(s)
fun sharedItemTypePriority(sections: List<String>): Int {
  val itemTypeSets = sections.map { it.toSet() }
  var shared = itemTypeSets.first()
  itemTypeSets.drop(1).forEach { shared = shared intersect it }
  val sharedItemType = shared.single()
  return sharedItemType.code - if (sharedItemType.isUpperCase()) '&'.code else '`'.code
}

// structure(s)
data class Symbol(val code: String, val shapeScore: Int, val outcomeScore: Int, val offset: Int)

// constant(s)
val opponentsShapes = listOf("A","B","C")
val yourSymbols = listOf(
  Symbol("X",1,0,2),
  Symbol("Y",2,3,0),
  Symbol("Z",3,6,1)
)

fun main() {
  fun part1(input: List<String>) = input.sumOf {
    val (opponentsPlay, yourPlay) = it.split(" ")
    roundScore(opponentsPlay, yourPlay)
  }

  fun part2(input: List<String>) = input.sumOf {
    val (opponentsPlay, outcome) = it.split(" ")
    val yourPlay = chooseYourPlay(opponentsPlay, outcome)
    roundScore(opponentsPlay, yourPlay)
  }

  val testInput = readInput("Day02_test")
  check(part1(testInput) == 15)
  check(part2(testInput) == 12)

  val input = readInput("Day02")
  println(part1(input))
  println(part2(input))
}

// helper function(s)
fun roundScore(opponentsPlay: String, yourPlay: String): Int {
  val yourShape = yourSymbols.find { it.code == yourPlay }
  val offset = (yourSymbols.indexOf(yourShape) - opponentsShapes.indexOf(opponentsPlay)).mod(3)
  return yourShape!!.shapeScore + yourSymbols.find { it.offset == offset }!!.outcomeScore
}
fun chooseYourPlay(opponentsPlay: String, outcome: String): String {
  val offset = yourSymbols.find { it.code == outcome }!!.offset
  return yourSymbols[(opponentsShapes.indexOf(opponentsPlay) + offset).mod(3)].code
}
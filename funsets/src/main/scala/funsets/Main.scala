package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  
  val s = union(singletonSet(1), union(singletonSet(2), union(singletonSet(1000), singletonSet(3))))
  println(FunSets.toString(map(s, (x: Int) => x - 1)))
}

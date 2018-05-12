package example

import practise.Zavorky

object Hello extends Greeting with App {

  val string = "(([[]]))"

  private val result = new Zavorky().solve(string)

  println(s"$string checked: $result")

  println(greeting)

}

trait Greeting {
  lazy val greeting: String = "hello"
}

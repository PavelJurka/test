package practise

import scala.collection.mutable
import scala.util.control.Breaks._

class Zavorky {

  val stack = new mutable.Stack[Char]()

  var list = List[Char]()


  def solve(s: String): Boolean = {

    var result: Boolean = true

    // Stack - obsolete
//    breakable {
//      for (i <- 0 until s.length) {
//        val c = s(i)
//
//        c match {
//          case '(' | '[' | '{' => stack.push(c)
//          case _ =>
//            if (isMatching(c)) {
//              stack.pop
//            } else {
//              result = false
//              break()
//            }
//        }
//      }
//    }

    breakable {
      for (i <- 0 until s.length) {
        val c = s(i)

        c match {
          case '(' | '[' | '{' => list = c +: list
          case _ =>
            if (isMatching(c)) {
              list = list.tail
            } else {
              result = false
              break()
            }
        }
      }
    }

    result
  }

  private def isMatching(c: Char): Boolean = {
//    c match {
//      case ')' => stack.head == '('
//      case '}' => stack.head == '{'
//      case ']' => stack.head == '['
//      case _ => false
//    }
    c match {
      case ')' => list.head == '('
      case '}' => list.head == '{'
      case ']' => list.head == '['
      case _ => false
    }
  }
}
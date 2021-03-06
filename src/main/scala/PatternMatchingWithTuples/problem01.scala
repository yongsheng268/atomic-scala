package PatternMatchingWithTuples

import PatternMatchingWithTuples.Color
import PatternMatchingWithTuples.Color._

package object colorblend {
  class wrapper {
    def blend(a:Color, b:Color) =
      (a, b) match {
        case _ if a == b => a
        case (`red`, `blue`) |
             (`blue`, `red`) => purple
        case (`red`, `yellow`) |
             (`yellow`, `red`) => orange
        case (`blue`, `yellow`) |
             (`yellow`, `blue`) => green
        case (`brown`, _) |
             (_, `brown`) => brown
        case _ => // Interesting, not accurate:
          Color((a.id + b.id) % Color.maxId)
      }
  }
}

object problem01 {
  import colorblend._

  def main(args: Array[String]): Unit = {
    val Wrapper = new wrapper
    println (Wrapper.blend(red,yellow))
    println (Wrapper.blend(yellow,red))
    println (Wrapper.blend(red,red))
    println (Wrapper.blend(purple,orange))
  }
}
/*
Error:(13, 23) illegal variable in pattern alternative
           (`yellow`, red) => orange
 */
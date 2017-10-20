import scala.sys.process._

object Rocket extends App {

    def clear = "clear" !

    def rand: Double = scala.util.Random.nextDouble

    def fire = {
        val tmp = if(rand > 0.6) "W" else "V"
        if (rand > 0.8) tmp.toLowerCase else tmp
    }

    val rocket_m = """
  ╒▲╕  
  ├☼┤  
A=[╦]=A
"""
   val rocket_l = """
 ╒♦    
 ☼┤    
A[=A   
"""
   val rocket_r = """
    ♦╕ 
    ├☼ 
   A=]A
"""

    var state = "m"
    while(true) {
        if(rand > 0.95) {
            if(state == "m") {
                state = if(rand >= 0.5) "l" else "r"
            } else if(state == "l") {
                state = if(rand >= 0.5) "m" else "r"
            } else if(state == "r") {
                state = if(rand >= 0.5) "m" else "l"
            }
        }
        clear
        
        if(state == "m") {
            println(rocket_m + "   " + fire + "   ")
        } else if(state == "l") {
            println(rocket_l + " " + fire + fire + "    ")
        } else if(state == "r") {
            println(rocket_r + "    " + fire + fire + " ")
        }
        Thread.sleep(100)
    }
}

import scala.sys.process._

object Rocket extends App {

    def clear = "clear" !

    val rocket = """
        /^A^\    
         ]=[     
         ]=[     
        /{O}\    
    A=^[|=H=|]^=A
    """

    def fire = {
        val tmp = if(scala.util.Random.nextDouble > 0.6) "W" else "V"
        if (scala.util.Random.nextDouble > 0.8) tmp.toLowerCase else tmp
    }

    while(true) {
        clear
        println(rocket + " " * 5 + fire + fire + fire + " " * 5)
        Thread.sleep(100)
    }

}

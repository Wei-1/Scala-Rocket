import scala.swing._
import scala.swing.event._
import java.awt.event._

object KeyEventTest extends SimpleSwingApplication {

    val rocket = """
  ╒▲╕  
  ├☼┤  
A=[╦]=A
   W   
"""
    println(rocket)

    val rocket_m = """
  ╒▲╕  
  ├☼┤  
A=[╦]=A
   w   
"""

   val rocket_l = """
 ╒♦    
 ☼┤    
A[=A   
 VV    
"""
   val rocket_r = """
    ♦╕ 
    ├☼ 
   A=]A
    VV 
"""

    def top = new MainFrame {
        val ta = new TextArea {
            text = rocket
            font = new Font("Courier", 0, 20)
        }

        contents = new BoxPanel(Orientation.Vertical) {
            contents += ta
            border = Swing.EmptyBorder(0,0,0,0)
            listenTo(keys)
            reactions += {
                case KeyPressed(_, Key.Space, _, _) =>
                    ta.text = rocket_m
                case KeyReleased(_, Key.Space, _, _) =>
                    ta.text = rocket
                case KeyPressed(_, Key.A, _, _) =>
                    ta.text = rocket_l
                case KeyReleased(_, Key.A, _, _) =>
                    ta.text = rocket
                case KeyPressed(_, Key.S, _, _) =>
                    ta.text = rocket_r
                case KeyReleased(_, Key.S, _, _) =>
                    ta.text = rocket
            }
            focusable = true
            requestFocus
        }
    }
}   

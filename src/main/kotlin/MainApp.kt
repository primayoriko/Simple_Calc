package MyCalc.main.kotlin

import javafx.stage.Stage
import tornadofx.*

class MainApp : App() {
    override val primaryView = Calculator::class

    override fun start(stage: Stage) {
        //importStylesheet("/style.css")
        stage.isResizable = false
        super.start(stage)
    }
}
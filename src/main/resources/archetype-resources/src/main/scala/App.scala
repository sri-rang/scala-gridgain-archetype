package org.gridgain.scalar.examples

import org.gridgain.scalar.scalar
import org.gridgain.scalar.scalar._
import java.lang.String
import org.gridgain.grid._
import java.util.{Collection => JCollection}
import java.util.{ArrayList => JArrayList}

object ScalarTaskExample {
    def main(args: Array[String]) {
        scalar {
            grid.execute(classOf[GridHelloWorld], "Hello Cloud World!").get
        }
    }

    class GridHelloWorld extends GridTaskNoReduceSplitAdapter[String] {
        def split(gridSize: Int, arg: String): JCollection[_ <: GridJob] = {
            val jobs: JCollection[GridJob] = new JArrayList[GridJob]()
            for (w <- arg.split(" ")) jobs.add(() => println(w))
            jobs
        }
    }
}

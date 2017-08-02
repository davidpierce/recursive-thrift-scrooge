package test

import org.apache.thrift.protocol.{TJSONProtocol, TProtocol, TSimpleJSONProtocol}
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport, TTransport}
import tree._
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TreeSpec extends Specification {
  def leaf(data: String): Tree = Tree.Leaf(Leaf(data))

  def branch(left: Tree, right: Tree) = Tree.Branch(Branch(left, right))

  "TreeSpec" should {
    "round trip via thrift" in {
      val t: Tree = branch(
          branch(
              leaf("aa"),
              leaf("ab")
          ),
          branch(
              leaf("ba"),
              leaf("bb")
          )
      )

      val transport = new TMemoryBuffer(256)
      val protocol = new TJSONProtocol.Factory().getProtocol(transport)
      t.write(protocol)
      val u = Tree.decode(protocol)
      u mustEqual t
    }
  }
}

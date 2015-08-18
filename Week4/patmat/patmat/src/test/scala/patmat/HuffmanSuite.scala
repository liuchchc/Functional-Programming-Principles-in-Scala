package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      val wg = weight(t1)
      println(wg)
      assert(wg === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      val char = chars(t2)
      println(char)
      assert(char === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      val encodeR = encode(t2)("abd".toList)
      val decodeR = decode(t2, encodeR)
      assert(decodeR === "abd".toList)
    }
  }
  
  test("make hum Tree self") {
    val treeString = "cdaeafabagabahaab"
    val rootTree = createCodeTree(treeString.toList)
    val encodeR = encode(rootTree)("abcdefg".toList)
    val quickEncodeR = quickEncode(rootTree)("abcdefg".toList)
    val decodeR = decode(rootTree, encodeR)
    assert(decodeR === "abcdefg".toList)
  }
}

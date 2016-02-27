package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

    test("intersect contains some elements") {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "not intersect 1")
      assert(!contains(s, 2), "not intersect 2")
      assert(!contains(s, 3), "not intersect 3")
      val s0 = union(s1, s1)
      assert(contains(s0, 1), "intersect 1")
    }
  }

  test("Diff elements") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "diff 1")
      assert(!contains(s, 2), "not diff 2")
      assert(!contains(s, 3), "not diff 3")
      val s0 = diff(s1, s1)
      assert(!contains(s0, 1), "not diff 1")
    }
  }

  test("Filter elements") {
    new TestSets {
      val s = filter(s1, (x => x <= 1))
      assert(contains(s, 1), "filter 1")
      assert(!contains(s, 2), "not filter 2")
      assert(!contains(s, 3), "not filter 3")
      val s0 = filter(s1, (x => x < 0))
      assert(!contains(s0, 1), "not filter 1")
      assert(!contains(s0, 0), "not filter 0")
    }
  }

  test("Map elements") {
    new TestSets {
      val s = map(s1, (x => -x))
      assert(!contains(s, 1), "Map 1")
      assert(contains(s, -1), "Map -1")
    }
  }
  
   test("map : {1,3,4,5,7,1000}") {
     new TestSets {
       val u = union(singletonSet(1), singletonSet(3));
       val u1 = union(u, singletonSet(4))
       val u2 = union(u1, singletonSet(5))
       val u3 = union(u2, singletonSet(7))
       val u4 = union(u3, singletonSet(1000))
       
       val u5 = map(u4, x => (x-1))
       assert(contains(u5,0), "should contain 0")
       assert(contains(u5,2), "should contain 2")
       assert(contains(u5,3), "should contain 3")
       assert(contains(u5,4), "should contain 4")
       assert(contains(u5,6), "should contain 6")
       assert(contains(u5,999), "should contain 999")
     }
   }
   
   test("exists : {1,3,4,5,7,1000}") {
     new TestSets {
       val u = union(singletonSet(1), singletonSet(3));
       val u1 = union(u, singletonSet(4))
       val u2 = union(u1, singletonSet(5))
       val u3 = union(u2, singletonSet(7))
       val u4 = union(u3, singletonSet(1000))
       

       assert(!exists(u4,(x => x == 2)), "shouldn't exist 2")
       assert(exists(u4,(x => x == 3)), "should exist 3")
     }
   }   
   
}

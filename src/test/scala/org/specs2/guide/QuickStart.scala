package org.specs2
package guide

class QuickStart extends Specification { def is = literate                                                              ^
"Quick Start".title ^
"""
Two major styles of specifications are available with ***specs2***:

 * 'unit' specifications when you want the text and the example code to be interleaved (generally for a single class)
 * 'acceptance' specifications when you want to read the full text as one piece and have the implementation elsewhere

#### Unit specification

Unit specifications extend `org.specs2.mutable.Specification` and are using the `should/in` format:

      import org.specs2.mutable._

      class HelloWorldSpec extends Specification {

        "The 'Hello world' string" should {
          "contain 11 characters" in {
            "Hello world" must have size(11)
          }
          "start with 'Hello'" in {
            "Hello world" must startWith("Hello")
          }
          "end with 'world'" in {
            "Hello world" must endWith("world")
          }
        }
      }

#### Acceptance specification

Acceptance specifications extend `org.specs2.Specification` and must define a method called `is`:

      import org.specs2._

      class HelloWorldSpec extends Specification { def is =

        "This is a specification to check the 'Hello world' string"                 ^
                                                                                    p^
        "The 'Hello world' string should"                                           ^
          "contain 11 characters"                                                   ! e1^
          "start with 'Hello'"                                                      ! e2^
          "end with 'world'"                                                        ! e3^
                                                                                    end
        def e1 = "Hello world" must have size(11)
        def e2 = "Hello world" must startWith("Hello")
        def e3 = "Hello world" must endWith("world")
      }


The `is` method lists *specification fragments* which can be:

* some text: like a description of the system you're specifying
* an example: a description and some executable code returning a result
* formatting fragments: `p` adds a blank line and starts a new block of examples

Fragments are separated by the `^` character in order to build a list of them.

#### Execution

And this is it! Now to execute your specification, you use a *runner* which will display the results:

      > scala -cp ... specs2.run HelloWorldSpec

      HelloWorldSpec

      This is a specification to check the 'Hello world' string

      The 'Hello world' string should
      + contain 11 characters
      + start with 'Hello'
      + end with 'world'

      Total for specification HelloWorldSpec
      Finished in 0 second, 78 ms
      3 examples, 0 failure, 0 error

#### Where to go from here

You can explore the rest of this [User Guide](org.specs2.UserGuide.html "Guide") to learn how to:

 * display your text and examples nicely
 * define _contexts_ to setup/teardown data for your examples
 * include / link specifications and reuse examples
 * use the many ***specs2*** matchers to specify precise expectations
 * use Mockito or ScalaCheck
 * use sbt/maven/junit to execute a specification
 * export your specification as an html document (like this one!)
                                                                                                                        """^
  include(xonly, new examples.HelloWorldSpec)                                                                           ^
  include(xonly, new examples.HelloWorldUnitSpec)                                                                       ^
                                                                                                                        end
}

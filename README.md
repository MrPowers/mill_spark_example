# Mill Spark Example

An example Apache Spark project with the Mill build tool.

## Build

Thin JAR file:

```bash
mill foo.compile
```
 
Fat JAR file:

```bash
mill foo.assemble
```

## Test

``bash
mill foo.test
``

## TODO

* Turn off logging
* Fix "Exception in thread "Thread-1" java.lang.NoClassDefFoundError: org/apache/hadoop/util/ShutdownHookManager$2" message when the test suite finishes running
* Figure out how to do a `sbt clean` like command
* Customize the JAR file name that's generated
* Shading dependencies
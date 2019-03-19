# Mill Spark Example

An Apache Spark project with the Mill build tool.

`mill foo.test` to run the test suite.


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
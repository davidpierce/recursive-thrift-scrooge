# Recursive Thrift Types

This is a lightweight demonstration of the use of recursive Thrift types in Python and Scala (via Scrooge) in a Pants project.

## A. Preliminaries

The project makes use of the master branch of [Thrift](https://github.com/apache/thrift) (what will eventually be version 0.11.0) and my modifications to [Scrooge](https://github.com/davidpierce/scrooge/tree/recursive-structs).  Check out and build these projects as described below:

1. Build the thrift compiler. (Just `make`. No need to install.) This should result in an executable located at `compiler/cpp/thrift`.

1. Build the thrift python library.

    ```
    cd <thrift>/lib/py
    python setup.py bdist_wheel
    ```

1. Build scrooge using `./sbt assemble`. This should result in assembled jars in locations similar to

   - `<scrooge>/scrooge-generator/target/scala-2.12/`
   - `<scrooge>/scrooge-linter/target/scala-2.12/`

## B. Configuration

Define the following environment variables corresponding to the artifacts you built in step A.

```
export THRIFT_BIN_URL=file://<thrift>/compiler/cpp/thrift
export THRIFT_LIB_PY_REQ="thrift==1.0.0.dev0"
export THRIFT_LIB_PY_URL=file://<thrift>/lib/py/dist/
export SCROOGE_GENERATOR_URL=file://<scrooge>/scrooge-generator/target/scala-2.12/scrooge-generator-assembly-4.18.0-SNAPSHOT.jar
export SCROOGE_LINTER_URL=file://<scrooge>/scrooge-linter/target/scala-2.12/scrooge-linter-assembly-4.18.0-SNAPSHOT.jar
```

## C. Run the Test

```
./pants test ::
```

## How It Works

1. Custom thrift compiler:  In `pants.ini` we add `file://.pants.d` to the list of binaries baseurls, and set the thrift-binary version to something unique.  In `BUILD.tools` we run a prep command that copies the thrift compiler from `$THRIFT_BIN_URL` to an appropriate location in `.pants.d`.

1. Custom thrift python library:  In `BUILD.tools` we define a python requirement with `repository=$THRIFT_LIB_PY_URL`.

1. Custom scrooge compiler:  In `BUILD.tools` we define jar libraries with `url=$SCROOGE_GENERATOR_URL` with the special names `scrooge-gen` and `scrooge-linter` used by the scrooge contrib module.

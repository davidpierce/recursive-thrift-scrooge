
jar_library(name='twitter-util', jars=[
  scala_jar(org='com.twitter', name='util-core', rev='6.35.0'),
])

jar_library(name='libthrift-0.6.1', jars=[jar(org='org.apache.thrift', name='libthrift', rev='0.6.1')])

for x in ('specs2-core', 'specs2-junit', 'specs2-mock'):
    jar_library(name=x, jars=[scala_jar(org='org.specs2', name=x, rev='3.6.6')])

target(name='specs2', dependencies=[
  ':specs2-core',
  ':specs2-junit',
  ':specs2-mock',
])

scrooge_rev='4.18.0-SNAPSHOT'

jar_library(name='scrooge-core', jars=[
  scala_jar(org='com.twitter', name='scrooge-core', rev=scrooge_rev),
])

jar_library(name='scala-library', jars=[
  jar(org='org.scala-lang', name='scala-library', rev='2.11.11'),
])

python_thrift_library(
  name='thrift-python',
  sources=globs('*.thrift'),
  dependencies=[
    '//:install-thrift',
    '//:thrift-lib-py',
  ],
)

java_thrift_library(
  name='thrift-scala',
  compiler='scrooge',
  language='scala',
  rpc_style='finagle',
  sources=globs('*.thrift'),
  dependencies=[
    '//:install-thrift',
    '3rdparty:libthrift-0.6.1',
    '3rdparty:twitter-util',
    '3rdparty:scrooge-core',
  ],
)

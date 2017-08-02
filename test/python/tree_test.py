
from thrift.protocol.TJSONProtocol import TJSONProtocol
from thrift.transport.TTransport import TMemoryBuffer
from tree.ttypes import *

def branch(l, r):
    return Tree(branch=Branch(left=l, right=r))

def leaf(z):
    return Tree(leaf=Leaf(data=z))

def test_tree():
    t = branch(
        branch(
            leaf("aa"),
            leaf("ab"),
        ),
        branch(
            leaf("ba"),
            leaf("bb"),
        ))
    transport_out = TMemoryBuffer()
    protocol_out = TJSONProtocol(transport_out)
    t.write(protocol_out)
    json_out = transport_out.getvalue()
    transport_in = TMemoryBuffer(json_out)
    protocol_in = TJSONProtocol(transport_in)
    u = Tree()
    u.read(protocol_in)
    assert t == u

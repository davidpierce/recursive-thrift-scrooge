namespace java tree
namespace py tree

union Tree {
  1: Leaf leaf
  2: Branch branch
}
struct Leaf {
  1: string data
}
struct Branch {
  1: Tree left
  2: Tree right
}

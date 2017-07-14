union Tree {
  1: Leaf leaf
  2: Branch branch
}

struct Leaf {
  1: string data
}

struct Branch {
  1: optional Tree left
  2: optional Tree right
}

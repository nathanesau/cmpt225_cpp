// https://rust-unofficial.github.io/too-many-lists/second-final.html
// general comment: think about rust linkedlist as C++ impl using unique_ptr
// this will make the code easier to understand

// similar to
// Node {
//     int data;
//     std::unique_ptr<Node> next; 
// };
struct Node {
    data: i32,
    next: Option<Box<Node>>,
}

impl Node {
    pub fn new(data: i32, next: Option<Box<Node>>) -> Node {
        Node {
            data: data,
            next: next
        }
    }
}

// similar to
// List {
//     std::unique_ptr<Node> head;
// }
pub struct List {
    head: Option<Box<Node>>,
}

impl List {
    pub fn new() -> Self {
        List { head: None }
    }

    pub fn push(&mut self, data: i32) {
        // similar to
        // auto next = std::make_unique(5, std::move(this->head));
        // this->head = next;
        let node = Box::new(Node::new(data, self.head.take()));
        self.head = Some(node);
    }

    pub fn pop(&mut self) -> Option<i32> {
        // similar to
        // auto node = std::move(this->head);
        // auto node_ptr = node.get();
        // this->head = node_ptr->next;
        // return node_ptr->data;
        let node = self.head.take();
        node.map(|node_ptr| {
            self.head = node_ptr.next;
            node_ptr.data
        })
    }
}

impl Drop for List {
    fn drop(&mut self) {
        // similar to
        // auto node = std::move(this->head);
        // while (node) {
        //    node = std::move(node->next);
        // }
        let mut node = self.head.take();
        while let Some(mut boxed_node) = node {
            node = boxed_node.next.take();
        }
    }
}

fn main() {
    let mut list = List::new();

    // Check empty list behaves right
    assert_eq!(list.pop(), None);

    // Populate list
    list.push(1);
    list.push(2);
    list.push(3);

    // Check normal removal
    assert_eq!(list.pop(), Option::Some(3));
    assert_eq!(list.pop(), Option::Some(2));

    // Push some more just to make sure nothing's corrupted
    list.push(4);
    list.push(5);

    // Check normal removal
    assert_eq!(list.pop(), Option::Some(5));
    assert_eq!(list.pop(), Option::Some(4));

    // Check exhaustion
    assert_eq!(list.pop(), Option::Some(1));
    assert_eq!(list.pop(), Option::None);
}

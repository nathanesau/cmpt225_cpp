// https://rust-unofficial.github.io/too-many-lists/first-final.html
use std::mem;

struct Node {
    data: i32,
    next: NodePtr,
}

enum NodePtr {
    Empty,
    More(Box<Node>),
}

pub struct List {
    head: NodePtr,
}

impl List {
    pub fn new() -> Self {
        List {
            head: NodePtr::Empty,
        }
    }

    pub fn push(&mut self, data: i32) {
        // push to front
        //
        // ex. [1, 3] becomes [5, 1, 3]
        //
        // - set node [ex. 5]
        // - set node next [ex. 1]
        // - set head to node [ex. 5]
        let node = Box::new(Node {
            data: data,
            next: mem::replace(&mut self.head, NodePtr::Empty),
        });

        self.head = NodePtr::More(node);
    }

    pub fn pop(&mut self) -> Option<i32> {
        // pop from front
        //
        // ex. [5, 1,3] becomes [1, 3]
        //
        // case 1: head is empty (return Option::None)
        // case 2: head is non-empty (return head data, set head to next)
        match mem::replace(&mut self.head, NodePtr::Empty) {
            NodePtr::Empty => Option::None,
            NodePtr::More(node) => {
                self.head = node.next;
                Some(node.data)
            }
        }
    }
}

impl Drop for List {
    fn drop(&mut self) {
        // drop all elements
        //
        // first get head
        // then continually get next until it is empty
        let mut node = mem::replace(&mut self.head, NodePtr::Empty);

        while let NodePtr::More(mut bnode) = node {
            node = mem::replace(&mut bnode.next, NodePtr::Empty);
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

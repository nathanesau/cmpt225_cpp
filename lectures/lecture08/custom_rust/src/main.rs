// demonstrate use of Rc (similar to shared_ptr)
use std::rc::Rc;
use std::cell::RefCell;

fn main() {
    let a: Rc<RefCell<String>> = Rc::new(RefCell::new(String::from("ping")));
    let b: Rc<RefCell<String>> = a.clone();
    let c: Rc<RefCell<String>> = a.clone();
    println!("a: {}", a.borrow());
    println!("b: {}", b.borrow());
    println!("c: {}", c.borrow());

    *a.borrow_mut() = String::from("pong");
    println!("a: {}", a.borrow());
    println!("b: {}", b.borrow());
    println!("c: {}", c.borrow());

    *a.borrow_mut() = String::from("pingpong");
    println!("a: {}", a.borrow());
    println!("b: {}", b.borrow());
    println!("c: {}", c.borrow());
}

use lazy_static::lazy_static;
use std::sync::Mutex;
use rand::Rng;

lazy_static! {
    // static variable related to person(s)
    pub static ref SINGLETON_VALUE: Mutex<i32> = Mutex::new(0);
}

pub fn singleton_value_rand() {
    let x: &mut i32 = &mut *SINGLETON_VALUE.lock().unwrap();
    *x = rand::thread_rng().gen_range(0..100);
}

pub fn singleton_value_get() -> i32 {
    SINGLETON_VALUE.lock().unwrap().clone()
}

struct Singleton {

}

impl Singleton {
    pub fn new() -> Singleton {
        let s = Singleton {};

        // update static var
        singleton_value_rand();

        // return object
        s
    }

    pub fn value(&self) -> i32 {
        singleton_value_get()
    }
}

fn main() {
    let s1 = Singleton::new();
    let s2 = Singleton::new();

    println!("s1::value: {}", s1.value());
    println!("s2::value: {}", s2.value());
}

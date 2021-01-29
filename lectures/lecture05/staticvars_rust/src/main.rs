use lazy_static::lazy_static;
use std::sync::Mutex;

lazy_static! {
    // static variable related to person(s)
    pub static ref CREATED_BICYCLES: Mutex<i32> = Mutex::new(0);
}

pub fn created_bicycles_incr() {
    let x: &mut i32 = &mut *CREATED_BICYCLES.lock().unwrap();
    *x = *x + 1
}

pub fn created_bicycles_get() -> i32 {
    CREATED_BICYCLES.lock().unwrap().clone()
}

struct Bicycle {
    pub gear: i32,
    pub speed: i32,
    pub color: String,
}

impl Bicycle {
    pub fn new(gear: i32, speed: i32, color: String) -> Bicycle {
        let bicycle = Bicycle {
            gear: gear,
            speed: speed,
            color: color
        };

        // update static var
        created_bicycles_incr();

        // return object
        bicycle
    }
}

fn main() {
    println!("static variable before: {}", created_bicycles_get());

    for _ in 0..20 {
        let _ = Bicycle::new(20, 20, String::from("blue"));
    }

    println!("static variable after: {}", created_bicycles_get());

    // for reference

    // mutable int
    let mut x: i32 = 5;

    // mutable int reference
    let y: &mut i32 = &mut x;

    // modify x
    *y = 10;
    
    println!("x after: {}", x);
}

mod animal;
mod cow;
mod dog;

use animal::Animal;

fn main() {
    let cow = cow::Cow {
        color: String::from("Pink"),
        name: String::from("Bob"),
        weight: 10,
    };

    let dog = dog::Dog {
        breed: String::from("Poodle"),
        color: String::from("White"),
        name: String::from("Spot"),
    };

    println!("Cow: {}", cow.to_string());
    println!("Dog: {}", dog.to_string());
}

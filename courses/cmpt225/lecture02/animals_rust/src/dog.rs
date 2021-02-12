use crate::animal::Animal;

pub struct Dog {
    pub breed: String,
    pub color: String,
    pub name: String,
}

impl Animal for Dog {
    fn make_sound(&self) -> String {
        String::from("woof woof")
    }

    fn draw(&self) {
        // drawing implementation...
    }

    fn to_string(&self) -> String {
        format!("Dog: Breed = {}, Color = {}, Name = {} ", self.breed, self.color, self.name)
    }
}
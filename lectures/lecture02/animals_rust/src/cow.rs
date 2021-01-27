use crate::animal::Animal;

pub struct Cow {
    pub color: String,
    pub name: String,
    pub weight: i32,
}

impl Animal for Cow {
    fn make_sound(&self) -> String {
        String::from("moo")
    }

    fn draw(&self) {
        // drawing implementation...
    }

    fn to_string(&self) -> String {
        format!("Cow: Color = {}, Name = {}, Weight = {} ", self.color, self.name, self.weight)
    }
}
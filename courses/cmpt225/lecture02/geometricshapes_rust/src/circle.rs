use crate::geometricshape::GeometricShape;

pub struct Circle {
    pub x: i32,
    pub y: i32,
    pub radius: i32,
}

impl GeometricShape for Circle {
    fn move_to(&mut self, x: i32, y: i32) {
        self.x = x;
        self.y = y;
    }

    fn draw(&self) {
        // drawing implementation goes here...
    }

    fn to_string(&self) -> String {
        String::from("circle")
    }
}
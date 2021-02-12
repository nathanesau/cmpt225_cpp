use crate::geometricshape::GeometricShape;

pub struct Square {
    pub x: i32,
    pub y: i32,
    pub length: i32,
}

impl GeometricShape for Square {
    fn move_to(&mut self, x: i32, y: i32) {
        self.x = x;
        self.y = y;
    }
    
    fn draw(&self) {
        // drawing implementation goes here...
    }

    fn to_string(&self) -> String {
        String::from("square")
    }
}

pub trait GeometricShape {
    fn move_to(&mut self, x: i32, y: i32);
    fn draw(&self);
    fn to_string(&self) -> String;
}
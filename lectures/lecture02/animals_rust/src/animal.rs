pub trait Animal {
    fn make_sound(&self) -> String;
    fn draw(&self);
    fn to_string(&self) -> String;
}
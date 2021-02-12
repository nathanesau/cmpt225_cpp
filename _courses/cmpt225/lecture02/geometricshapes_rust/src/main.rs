mod geometricshape;
mod circle;
mod rectangle;
mod square;

use geometricshape::GeometricShape;

fn main() {
    let circle_shape = circle::Circle {
        x: 5,
        y: 5,
        radius: 10
    };

    let rectangle_shape = rectangle::Rectangle {
        x: 5,
        y: 5,
        length: 10,
        width: 10
    };

    let square_shape = square::Square {
        x: 5,
        y: 5,
        length: 10
    };

    println!("{}", circle_shape.to_string());
    println!("{}", rectangle_shape.to_string());
    println!("{}", square_shape.to_string());
}

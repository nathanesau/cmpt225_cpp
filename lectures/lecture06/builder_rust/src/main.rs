enum GeometricShapeType {
    CIRCLE,
    SQUARE,
    RECTANGLE,
}

impl std::fmt::Display for GeometricShapeType {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        match *self {
            GeometricShapeType::CIRCLE => write!(f, "circle"),
            GeometricShapeType::SQUARE => write!(f, "square"),
            GeometricShapeType::RECTANGLE => write!(f, "rectangle"),
        }
    }
}

enum GeometricShapeData {
    CircleData {
        x: i32,
        y: i32,
        radius: i32,
    },
    SquareData {
        x: i32,
        y: i32,
        length: i32,
    },
    RectangleData {
        x: i32,
        y: i32,
        length: i32,
        width: i32,
    },
}

impl std::fmt::Display for GeometricShapeData {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        match self {
            GeometricShapeData::CircleData { x, y, radius } => {
                write!(f, "{{x: {}, y: {} radius: {}}}", x, y, radius)
            }
            GeometricShapeData::SquareData { x, y, length } => {
                write!(f, "{{x: {}, y: {}, length: {}}}", x, y, length)
            }
            GeometricShapeData::RectangleData {
                x,
                y,
                length,
                width,
            } => write!(
                f,
                "{{x: {}, y: {}, length: {}, radius: {}}}",
                x, y, length, width
            ),
        }
    }
}

struct GeometricShape {
    shape_type: GeometricShapeType,
    shape_data: GeometricShapeData,
}

impl GeometricShape {
    pub fn new(shape_type: GeometricShapeType, shape_data: GeometricShapeData) -> GeometricShape {
        GeometricShape {
            shape_type: shape_type,
            shape_data: shape_data,
        }
    }
}

impl std::fmt::Display for GeometricShape {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "{} {}", self.shape_type, self.shape_data)
    }
}

trait Builder {
    type Object;

    fn create_shape(
        &mut self,
        shape_type: String,
        shape_data: GeometricShapeData,
    ) -> Box<Self::Object>;
}

pub struct GeometricShapeBuilder {}

impl Builder for GeometricShapeBuilder {
    type Object = GeometricShape;

    fn create_shape(
        &mut self,
        shape_type: String,
        shape_data: GeometricShapeData,
    ) -> Box<Self::Object> {
        if shape_type == "circle" {
            Box::new(GeometricShape::new(GeometricShapeType::CIRCLE, shape_data))
        } else if shape_type == "square" {
            Box::new(GeometricShape::new(GeometricShapeType::SQUARE, shape_data))
        } else if shape_type == "rectangle" {
            Box::new(GeometricShape::new(
                GeometricShapeType::RECTANGLE,
                shape_data,
            ))
        } else {
            panic!("invalid shape_type");
        }
    }
}

fn main() {
    let mut builder = GeometricShapeBuilder {};
    let circle = builder.create_shape(
        String::from("circle"),
        GeometricShapeData::CircleData {
            x: 5,
            y: 5,
            radius: 10,
        },
    );
    let square = builder.create_shape(
        String::from("square"),
        GeometricShapeData::SquareData {
            x: 5,
            y: 5,
            length: 10,
        },
    );
    let rectangle = builder.create_shape(
        String::from("rectangle"),
        GeometricShapeData::RectangleData {
            x: 5,
            y: 5,
            length: 10,
            width: 15,
        },
    );

    println!("{}", circle);
    println!("{}", square);
    println!("{}", rectangle);
}

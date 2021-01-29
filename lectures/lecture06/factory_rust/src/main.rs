use std::collections::HashMap;

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

struct GeometricShape {
    shape_type: GeometricShapeType,
    shape_data: HashMap<String, String>,
}

impl GeometricShape {
    pub fn new(
        shape_type: GeometricShapeType,
        shape_data: HashMap<String, String>,
    ) -> GeometricShape {
        GeometricShape {
            shape_type: shape_type,
            shape_data: shape_data,
        }
    }

    pub fn get_field(&self, field_name: &String) -> &String {
        match self.shape_data.get(field_name) {
            Some(field) => field,
            _ => panic!("couldn't find field!"),
        }
    }
}

impl std::fmt::Display for GeometricShape {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        let mut shape_data_str = String::new();
        let mut first = true;
        for (key, value) in &self.shape_data {
            if !first {
                shape_data_str.push_str(", ");
            }
            shape_data_str.push_str(&format!("{}: {}", key, value)[..]);
            first = false;
        }
        write!(f, "{} {{{}}}", self.shape_type, shape_data_str)
    }
}

trait Factory {
    type Object;

    fn create_shape(
        &mut self,
        shape_type: String,
        shape_data: HashMap<String, String>,
    ) -> Box<Self::Object>;
}

pub struct GeometricShapeFactory {}

impl Factory for GeometricShapeFactory {
    type Object = GeometricShape;

    fn create_shape(
        &mut self,
        shape_type: String,
        shape_data: HashMap<String, String>,
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
    let mut factory = GeometricShapeFactory {};
    let circle = factory.create_shape(
        String::from("circle"),
        [
            (String::from("x"), String::from("5")),
            (String::from("y"), String::from("5")),
            (String::from("radius"), String::from("10")),
        ]
        .iter()
        .cloned()
        .collect(),
    );
    let square = factory.create_shape(
        String::from("square"),
        [
            (String::from("x"), String::from("5")),
            (String::from("y"), String::from("5")),
            (String::from("length"), String::from("10"))
        ]
        .iter()
        .cloned()
        .collect(),
    );
    let rectangle = factory.create_shape(
        String::from("rectangle"),
        [
            (String::from("x"), String::from("5")),
            (String::from("y"), String::from("5")),
            (String::from("length"), String::from("10")),
            (String::from("width"), String::from("15"))
        ]
        .iter()
        .cloned()
        .collect(),
    );

    // test get_field
    println!("radius {}", circle.get_field(&String::from("radius")));

    println!("{}", circle);
    println!("{}", square);
    println!("{}", rectangle);
}

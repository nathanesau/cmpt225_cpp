pub enum RadiusError {
    NegativeError,
}

pub struct Circle {
    pub x: i32,
    pub y: i32,
    pub radius: i32,
}

impl Circle {
    pub fn set_radius(&mut self, radius: i32) -> Result<(), RadiusError> {
        if radius < 0 {
            return Err(RadiusError::NegativeError);
        }

        self.radius = radius;
        return Ok(());
    }

    pub fn to_string(&self) -> String {
        format!("circle: radius = {}", self.radius)
    }
}
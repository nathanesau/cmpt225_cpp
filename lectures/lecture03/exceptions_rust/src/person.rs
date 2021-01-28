pub enum TemperatureError {
    ColdError,
    HotError,
    UnknownError,
}

pub struct Person {
    pub name: String
}

impl Person {
    pub fn drink_coffee(&self, temperature: String) -> Result<(), TemperatureError> {
        match temperature.as_str() {
            "just right" => return Ok(()),
            "too cold" => return Err(TemperatureError::ColdError),
            "too hot" => return Err(TemperatureError::HotError),
            _ => return Err(TemperatureError::UnknownError),
        }
    }

    pub fn to_string(&self) -> String {
        format!("person: name = {}", self.name)
    }
}
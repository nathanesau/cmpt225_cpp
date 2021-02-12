use crate::gender::Gender;
use crate::person::Person;

pub struct Student {
    pub first_name: String,
    pub last_name: String,
    pub gender: Gender,
}

impl Person for Student {
    fn get_full_name(&self) -> String {
        format!("{} {}", self.first_name, self.last_name)
    }

    fn get_gender(&self) -> String {
        match self.gender {
            Gender::MALE => String::from("male"),
            Gender::FEMALE => String::from("female")
        }
    }
}

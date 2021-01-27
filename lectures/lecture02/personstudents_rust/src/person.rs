use lazy_static::lazy_static;
use std::sync::Mutex;

lazy_static! {
    // static variable related to person(s)
    pub static ref PERSON_GRADES: Mutex<Vec<i32>> = Mutex::new(vec![]);
}

pub fn person_grades_push(grade: i32) {
    PERSON_GRADES.lock().unwrap().push(grade);
}

pub fn person_grades_get() -> Vec<i32> {
    let grades = PERSON_GRADES.lock().unwrap().clone();
    grades
}

pub trait Person {
    fn get_full_name(&self) -> String;
    fn get_gender(&self) -> String;
}
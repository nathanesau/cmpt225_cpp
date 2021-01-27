mod gender;
mod person;
mod student;

use person::Person;

fn main() {
    let student1 = student::Student {
        first_name: String::from("Huck"),
        last_name: String::from("Finn"),
        gender: gender::Gender::MALE
    };

    // add grade for student 1
    person::person_grades_push(90);

    let student2 = student::Student {
        first_name: String::from("Susan"),
        last_name: String::from("Turner"),
        gender: gender::Gender::FEMALE
    };

    // add grade for student 2
    person::person_grades_push(80);

    println!("Printing gender for students");
    println!("{}", student1.get_gender());
    println!("{}", student2.get_gender());

    println!("Printing students");
    println!("{}", student1.get_full_name());
    println!("{}", student2.get_full_name());

    // get person grades
    let person_grades = person::person_grades_get();
    println!("grades: {:?}, average: {}",
        person_grades,
        person_grades.iter().sum::<i32>() as f32 / person_grades.len() as f32
    );
}

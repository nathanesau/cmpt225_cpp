mod circle;
mod person;

fn check_set_radius_result(result: &Result<(), circle::RadiusError>) {
    match result {
        Err(circle::RadiusError::NegativeError) => println!("set radius failed"),
        Ok(()) => println!("set radius successful")
    };
}

fn check_drink_coffee_result(result: &Result<(), person::TemperatureError>) {
    match result {
        Ok(()) => println!("coffee is just right"),
        Err(person::TemperatureError::ColdError) => println!("coffee is too cold"),
        Err(person::TemperatureError::HotError) => println!("coffee is too hot"),
        Err(person::TemperatureError::UnknownError) => println!("coffee temperature is unknown"),
    }
}

fn main() {
    // circle test
    let mut circle = circle::Circle {
        x: 5,
        y: 5,
        radius: 10
    };
    
    let result = circle.set_radius(15);
    check_set_radius_result(&result);
    let result = circle.set_radius(-5);
    check_set_radius_result(&result);

    println!("{}", circle.to_string());

    // person test
    let person = person::Person {
        name: String::from("John")
    };

    let result = person.drink_coffee(String::from("just right"));
    check_drink_coffee_result(&result);
    let result = person.drink_coffee(String::from("too cold"));
    check_drink_coffee_result(&result);
    let result = person.drink_coffee(String::from("too hot"));
    check_drink_coffee_result(&result);

    println!("{}", person.to_string());
}

// use std::fs;
use std::fs::File;
use std::io::prelude::*;

fn write_to_file() -> std::io::Result<()> {
    let mut file = File::create("foo.txt")?;

    // Result<(), Err>
    file.write_all(b"Hello, world!")?;

    // write successful
    Ok(())
}

fn read_from_file() -> Result<String, std::io::Error> {
    let mut f = File::open("foo.txt")?;

    let mut s = String::new();
    f.read_to_string(&mut s)?;

    // read successful
    Ok(s)
}

fn main() {
    let result = write_to_file();
    // let data = "Some data!";
    // fs::write("/tmp/foo", data).expect("Unable to write file");

    match result {
        Ok(()) => println!("wrote to file successfully"),
        _ => println!("error writing to file"),
    }

    let result = read_from_file();
    // let data = fs::read("/etc/hosts").expect("Unable to read file");
    // println!("{}", data.len());

    match result {
        Ok(_) => println!("read from file successfully"),
        _ => println!("error reading from file"),
    }
}

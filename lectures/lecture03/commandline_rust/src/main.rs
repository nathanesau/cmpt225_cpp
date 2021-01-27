// cargo run -- --host myhost --mode mymode
// cargo run
use clap::App;
use clap::Arg;

fn main() {
    let clap_app = App::new("commandline_rust: clap demo")
        .arg(
            Arg::with_name("host")
                .long("host")
                .takes_value(true)
                .default_value("localhost")
                .help("specify the host"),
        )
        .arg(
            Arg::with_name("mode")
            .long("mode")
            .takes_value(true)
            .default_value("default")
            .help("specify the mode"),
        );

    let matches = clap_app.get_matches();
    println!("host: {}", matches.value_of("host").unwrap());
    println!("mode: {}", matches.value_of("mode").unwrap());
}

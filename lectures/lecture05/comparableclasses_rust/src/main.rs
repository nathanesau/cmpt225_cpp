struct ComparableClass {
    pub id: i32,
    pub name: String,
}

impl std::fmt::Debug for ComparableClass {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        f.debug_struct("ComparableClass")
            .field("id", &self.id)
            .field("name", &self.name)
            .finish()
    }
}

fn main() {
    let mut vec = vec![];
    vec.push(ComparableClass {
        id: 0,
        name: String::from("ABC"),
    });
    vec.push(ComparableClass {
        id: 1,
        name: String::from("ABC"),
    });
    vec.push(ComparableClass {
        id: 2,
        name: String::from("XYZ"),
    });
    vec.push(ComparableClass {
        id: 1,
        name: String::from("XYZ"),
    });
    vec.push(ComparableClass {
        id: 2,
        name: String::from("ABC"),
    });

    println!("unsorted list: {:?}", vec);

    vec.sort_by(|a, b| {
        if a.id < b.id {
            return std::cmp::Ordering::Less;
        } else if a.id == b.id {
            return a.name.cmp(&b.name);
        }
        return std::cmp::Ordering::Greater;
    });

    println!("sorted list: {:?}", vec);
}

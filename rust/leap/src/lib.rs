pub fn is_leap_year(y: i16) -> bool {
    if divisible_by(y, 4) {
        !(divisible_by(y, 100) && !divisible_by(y, 400))
    } else {
        false
    }
}

fn divisible_by(dividend: i16, divisor: i16) -> bool {
    dividend % divisor == 0
}

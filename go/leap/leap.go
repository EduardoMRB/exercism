package leap

func IsLeapYear(year int) bool {
	return IsDivisibleBy(4, year) &&
		!(IsDivisibleBy(100, year) && !IsDivisibleBy(400, year))
}

func IsDivisibleBy(divisor int, year int) bool {
	return year%divisor == 0
}

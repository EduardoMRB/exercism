(ns leap)

(defn divisible-by? [factor n]
  (zero? (mod n factor)))

(defn divisible-by-100-but-not-400 [year]
  (and (divisible-by? 100 year)
       (not (divisible-by? 400 year))))

(defn leap-year? [year]
  (and (divisible-by? 4 year)
       (not (divisible-by-100-but-not-400 year))))

(ns raindrops)

(defn- divisible-by [divisor dividend]
  (zero? (mod dividend divisor)))

(defn- prime-factors-of [n]
  (loop [num     n
         divisor 2
         factors []]
    (cond
      (<= num 1) factors
      (divisible-by divisor num) (recur (/ num divisor)
                                        divisor
                                        (conj factors divisor))
      :else (recur num (inc divisor) factors))))

(defn convert [n]
  (let [prime-factors (set (prime-factors-of n))
        mappings      [[3 "Pling"]
                       [5 "Plang"]
                       [7 "Plong"]]
        raindrops     (reduce (fn [res [fac text]]
                                (if (contains? prime-factors fac)
                                  (str res text)
                                  res))
                              ""
                              mappings)]
    (if (seq raindrops)
      raindrops
      (str n))))

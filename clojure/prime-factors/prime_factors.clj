(ns prime-factors)

(defn divisible-by [divisor dividend]
  (zero? (mod dividend divisor)))

(defn factors-of [n]
  (loop [num     n
         divisor 2
         factors []]
    (cond
      (<= num 1) factors
      (divisible-by divisor num) (recur (/ num divisor)
                                        divisor
                                        (conj factors divisor))
      :else (recur num (inc divisor) factors))))

(defn of [n]
  (factors-of n))

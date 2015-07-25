(ns accumulate)

(defn accumulate [f coll]
  (if (seq coll)
    (cons (f (first coll))
          (accumulate f (rest coll)))
    []))

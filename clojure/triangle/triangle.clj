(ns triangle
  (:refer-clojure :exclude [type]))

(defn illogical? [a b c]
  (or (<= (+ a b) c)
      (<= (+ a c) b)
      (<= (+ b c) a)))

(defn type [a b c]
  (cond
    (= a b c) :equilateral
    (illogical? a b c) :illogical
    (= 2 (count (set [a b c]))) :isosceles
    :else :scalene))

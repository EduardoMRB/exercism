(ns queen-attack)

(defn- build-place [x y coords]
  (let [[w-x w-y] (:w coords)
        [b-x b-y] (:b coords)]
    (cond
      (and (= x w-x) (= y w-y)) \W
      (and (= x b-x) (= y b-y)) \B
      :else                     \O)))

(defn- add-newline [s]
  (str s \newline))

(defn board-string [coords]
  (let [board (for [x (range 8)]
                (for [y (range 8)]
                  (build-place x y coords)))]
    (->> board
         (map (partial interpose \space))
         (map (partial apply str))
         (clojure.string/join \newline)
         (add-newline))))

(defn can-attack [coords]
  (let [[w-x w-y] (:w coords)
        [b-x b-y] (:b coords)]
    (or (= w-x b-x)
        (= w-y b-y)
        (and (= w-x w-y)
             (= b-x b-y)))))

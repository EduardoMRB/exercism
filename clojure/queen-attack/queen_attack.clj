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

(defn- horizontally? [[w-x _] [b-x _]]
  (= w-x b-x))

(defn- vertically? [[_ w-y] [_ b-y]]
  (= w-y b-y))

(defn- diagonally? [[w-x w-y] [b-x b-y]]
  (let [dx (- w-x b-x)
        dy (- w-y b-y)]
    (= dx dy)))

(defn can-attack [coords]
  (let [white (:w coords)
        black (:b coords)]
    (or (horizontally? white black)
        (vertically? white black)
        (diagonally? white black))))

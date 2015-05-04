(ns robot-name)

(defn rand-seq
  "Makes a collection range with the supplied numbers, shuffles them and
  returns the char according to the ASCII table for each number of the
  collection"
  [start finish quantity]
  (->> (range start finish)
       (shuffle)
       (take quantity)
       (map char)))

(defn rand-number-seq []
  (rand-seq 48 58 3))

(defn rand-letter-seq []
  (rand-seq 64 90 2))

(defn gen-robot-name []
  (apply str (concat (rand-letter-seq) (rand-number-seq))))

(defn robot [] (atom {:name (gen-robot-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot #(assoc % :name (gen-robot-name))))

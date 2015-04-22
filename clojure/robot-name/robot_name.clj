(ns robot-name)

(defrecord Robot [name])

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

(defn robot [] (->Robot (atom (gen-robot-name))))

(defn robot-name [^Robot robot]
  (deref (:name robot)))

(defn reset-name [^Robot rob]
  (swap! (:name rob) (fn [_] (gen-robot-name))))

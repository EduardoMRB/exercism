(ns word-count)

(defn extract-words [words]
  (re-seq #"\w+" words))

(defn word-frequency [col key]
  (inc (col key 0)))

(defn word-count [words]
  (let [words (clojure.string/lower-case words)]
    (reduce #(assoc %1 %2 (word-frequency %1 %2)) {} (extract-words words))))

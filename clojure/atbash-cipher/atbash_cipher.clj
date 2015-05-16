(ns atbash-cipher
  (:require [clojure.string :refer [lower-case]]))

(def ^{:private true} alphabet->cipher
  (let [alphabet "abcdefghijklmnopqrstuvwxyz"
        numbers  (map #(char (first (str %)))
                      (range 0 10))]
    (merge
      (zipmap alphabet (reverse alphabet))
      (zipmap numbers numbers))))

(defn- only-letters-and-numbers [phrase]
  (apply str
         (re-seq #"[\w\d]+" (lower-case phrase))))

(defn encode [phrase]
  (->> phrase
       (only-letters-and-numbers)
       (map #(alphabet->cipher %))
       (partition-all 5)
       (interpose " ")
       (map (partial apply str))
       (apply str)))

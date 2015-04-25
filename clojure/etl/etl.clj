(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn extract-words [k words]
  (reduce (fn [acc word]
            (assoc acc (lower-case word) k))
          {}
          words))

(defn transform [score]
  (reduce (fn [acc [k words]]
            (merge acc (extract-words k words)))
          {}
          score))

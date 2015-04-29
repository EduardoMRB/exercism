(ns grains
  (:refer-clojure :exclude [double]))

(def MAX-SQUARES 64)

(defn- double [x] (*' x 2))

(defn- chess-seq [n]
  (take n (iterate double 1)))

(defn square [n]
  (last (chess-seq n)))

(defn total []
  (reduce + (chess-seq MAX-SQUARES)))

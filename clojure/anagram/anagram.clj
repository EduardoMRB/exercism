(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn- anagram-for [word]
  (fn [candidate]
    (let [word (lower-case word)
          candidate (lower-case candidate)]
      (and 
        (= (sort word) (sort candidate))
        (not= word candidate)))))

(defn anagrams-for [word candidates]
  (let [anagram? (anagram-for word)]
    (filter anagram? candidates)))

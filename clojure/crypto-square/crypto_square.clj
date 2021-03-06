(ns crypto-square
  (:require [clojure.string :as str]))

(defn normalize-plaintext
  "Removes spaces and punctuations from the text and lowercase it"
  [text]
  (->> text
       (re-seq #"\w")
       (apply str)
       (str/lower-case)))

(defn square-size [text]
  (let [normalized-text (normalize-plaintext text)
        text-count      (count normalized-text)]
    (loop [c (dec text-count)]
      (if (zero? (rem text-count c))
        c
        (recur (dec c))))))

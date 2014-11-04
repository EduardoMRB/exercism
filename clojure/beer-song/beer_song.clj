(ns beer-song
  (:require [clojure.string :refer [join]]))

(defn- bottles [bottle-count]
  (if (> bottle-count 1)
    "bottles"
    "bottle"))

(defn- first-sentence [bottle-count]
  (if (zero? bottle-count)
    "No more bottles of beer on the wall, no more bottles of beer.\n"
    (str bottle-count " " (bottles bottle-count) " of beer on the wall, " bottle-count " " (bottles bottle-count) " of beer.\n")))

(defn- second-sentence [bottle-count]
  (cond 
    (zero? bottle-count) "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    (= bottle-count 1) "Take it down and pass it around, no more bottles of beer on the wall.\n"
    :else (str "Take one down and pass it around, " (dec bottle-count )" " (bottles (dec bottle-count)) " of beer on the wall.\n")))

(defn- verses [from-verse to-verse]
  (reverse (range to-verse (inc from-verse))))

(defn verse [number]
  (str (first-sentence number) (second-sentence number)))

(defn sing 
  ([verse-number]
    (sing verse-number 0))
  ([from-verse to-verse] 
    (->>
      (verses from-verse to-verse)
      (map verse)
      (join "\n"))))

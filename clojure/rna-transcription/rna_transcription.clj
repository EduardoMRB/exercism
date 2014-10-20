(ns rna-transcription
  (:require [clojure.core :refer :all]))

(defn- translate-nucleotide [nucleotide]
  (cond
    (= "C" nucleotide) "G"
    (= "A" nucleotide) "U"
    (= "T" nucleotide) "A"
    (= "G" nucleotide) "C"
    :else (throw (AssertionError. (str "Invalid nucleotide: " nucleotide)))))

(defn to-rna [dna-strand]
  (let [dna-strand (clojure.string/split dna-strand #"")]
    (apply str (map translate-nucleotide dna-strand))))

(ns bob 
  (:require [clojure.core :refer :all]))

(defn- shout? [phrase]
  (and
    (= (clojure.string/upper-case phrase) phrase)
    (not= (clojure.string/lower-case phrase) phrase)))

(defn- question? [phrase]
  (= (last phrase) \?))

(defn- silence? [phrase]
  (empty? (clojure.string/trim phrase)))

(defn response-for [phrase]
  (cond
    (shout? phrase) "Whoa, chill out!"
    (question? phrase) "Sure."
    (silence? phrase) "Fine. Be that way!"
    :else "Whatever."))

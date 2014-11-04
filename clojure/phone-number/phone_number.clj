(ns phone-number
  (require [clojure.string :refer [join]]))

(defn- seq-str [seq]
  (apply str seq))

(defn- rest-seq-str [string]
  (seq-str (rest string)))

(defn number [number]
  (let [clean-number (seq-str (re-seq #"\d+" number))
        invalid-number "0000000000"
        clean-number-count (count clean-number)]
    (cond
      (< clean-number-count 10) invalid-number
      (= 11 clean-number-count)
        (if (= \1 (first clean-number))
          (rest-seq-str clean-number)
          invalid-number)
      :else clean-number)))

(defn area-code [number]
  (subs number 0 3))

(defn- separate-number [number]
  (join "-" (map seq-str (split-at 3 (subs number 3)))))

(defn pretty-print [n]
  (let [clean-number (number n)]
    (str "(" (area-code clean-number) ") " (separate-number clean-number))))

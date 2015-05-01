(ns gigasecond
  (:require [clj-time.core :as t]))

(defn make-date-vector [date]
  [(t/year date) (t/month date) (t/day date)])

(defn from [year month day]
  (let [date (t/date-time year month day)]
    (make-date-vector
      (t/plus date (t/seconds 1000000000)))))

(ns binary)

;; ----- Utility functions ------

(defn- pow [base exponent]
  (int (Math/pow base exponent)))

(defn- valid-args? [binary]
  (every? #(contains? #{\1 \0} %)
          binary))

(defn calculate-decimal [binary base]
  (loop [c       (count binary)
         coll    binary
         decimal 0]
    (if (zero? c)
      decimal
      (recur (dec c)
             (rest coll)
             (+ decimal
                (* (Integer/parseInt (str (first coll)))
                   (pow 2 (dec c))))))))

(defn to-decimal [binary]
  (if (valid-args? binary)
    (calculate-decimal binary 2)
    0))

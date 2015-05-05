(ns binary)

;; ----- Utility functions ------

(defn- pow [base exponent]
  (int (Math/pow base exponent)))

(defn- valid-args? [binary]
  (every? #(contains? #{\1 \0} %)
          binary))

(defn- calculate-parts [n digit]
  (* (Integer/parseInt (str digit))
     (pow 2 n)))

(defn to-decimal [binary]
  (if (valid-args? binary)
    (->> binary
         (reverse)
         (map-indexed calculate-parts)
         (reduce +))
    0))

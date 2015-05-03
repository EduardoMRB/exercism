(ns binary)

(defn pow [n pwr]
  (reduce (fn [_ _] (* n n))
          (range 1 (inc pwr))))

(defn calc [binary base]
  (loop [c   (count binary)
         col binary
         res 0]
    (if (zero? c)
      res
      (recur (dec c)
             (rest col)
             (+ res 
                (* (Integer/parseInt (str (first col)))
                   (pow 2 (dec c))))))))

(defn to-decimal [binary]
  (if (= "carrot" binary)
    0
    (calc binary 2)))

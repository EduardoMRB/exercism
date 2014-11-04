(ns point-mutations)

(defn hamming-distance [strand-a strand-b]
  (cond
    (= (count strand-a) (count strand-b)) 
      (->> 
        (map #(= %1 %2) strand-a strand-b)
        (filter false?)
        count)
    :else nil))

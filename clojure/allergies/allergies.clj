(ns allergies)

(def allergies-table
  [["eggs" 1]
   ["peanuts" 2]
   ["shellfish" 4]
   ["strawberries" 8]
   ["tomatoes" 16]
   ["chocolate" 32]
   ["pollen" 64]
   ["cats" 128]])

(defn list [score]
  (let [count (atom score)]
    (reduce (fn [allergies [a-name a-score]]
              (if (>= @count a-score)
                (do
                  (swap! count - a-score)
                  (cons a-name allergies))
                allergies))
            []
            (reverse allergies-table))))

(defn- allergy-score [allergy]
  (->> allergies-table
       (filter (fn [[k v]] (= k allergy)))
       first
       second))

(defn allergic-to? [score allergy]
  (>= score (allergy-score allergy)))

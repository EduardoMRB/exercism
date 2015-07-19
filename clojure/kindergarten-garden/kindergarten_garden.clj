(ns kindergarten-garden
  (:require [clojure.string :as str]))

(def char->plants
  {\R :radishes
   \C :clover
   \G :grass
   \V :violets})

(def default-students
  ["Alice" "Bob" "Charlie" "David" "Eve" "Fred"
   "Ginny" "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"])

(defn- rows [diagram]
  (->> diagram
       (str/split-lines)
       (map (fn [chars] (map char->plants chars)))))

(defn- keywordize-students [students]
  (map (comp keyword (partial str/lower-case)) (sort students)))

(defn garden
  ([diagram]
   (garden diagram default-students))
  ([diagram students]
   (let [[first-row second-row] (rows diagram)]
     (loop [stds (keywordize-students students)
            fr   first-row
            sr   second-row
            res  {}
            c    1]
       (if (seq fr)
         (recur (rest stds)
                (drop 2 fr)
                (drop 2 sr)
                (assoc res
                       (first stds)
                       (vec (concat (take 2 fr) (take 2 sr))))
                (inc c))
         res)))))

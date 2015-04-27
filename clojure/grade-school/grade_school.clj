(ns grade-school)

(defn add [db name grade]
  (update-in db [grade] #(conj (vec %) name)))

(defn grade [db grade]
  (get db grade []))

(defn sorted [db]
  (->> db
       (reduce concat [])
       (map (fn [item]
              (if (vector? item)
                (sort item)
                item)))
       (apply sorted-map)))

(ns grade-school)

(defn add [db name grade]
  (update-in db [grade] (fn [item]
                          (if (seq item)
                            (conj item name)
                            [name]))))

(defn grade [db grade]
  (if-let [grade (get db grade)]
    grade
    []))

(defn sorted [db]
  (->> db
       (reduce concat [])
       (map (fn [item]
              (if (vector? item)
                (sort item)
                item)))
       (apply sorted-map)))

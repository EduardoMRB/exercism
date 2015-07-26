(ns binary-search-tree)

(defn singleton [v]
  {:left  nil
   :right nil
   :value v})

(defn value [node]
  (:value node))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn insert [v node]
  (let [direction (if (<= v (value node))
                    :left
                    :right)]
    (if (nil? (direction node))
      (assoc node direction (singleton v))
      (assoc node direction (insert v (direction node))))))


(defn from-list [coll]
  (reduce (fn [node v]
            (insert v node))
          (singleton (first coll))
          (rest coll)))

(defn to-list [tree]
  (lazy-cat
   (when-not (nil? (left tree)) (to-list (left tree)))
   (vector (value tree))
   (when-not (nil? (right tree)) (to-list (right tree)))))

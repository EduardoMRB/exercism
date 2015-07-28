(ns largest-series-product)

(defn digits [s]
  (map #(Integer/parseInt (str %)) s))

(defn slices [n s]
  (partition n (digits s)))

(defn- product [numbers]
  (reduce * numbers))

(defn largest-product [n s]
  (let [slices   (slices n s)
        products (map product slices)]
    (cond
      (< (count s) n)   1
      (zero? (count s)) 1
      :else             (apply max products))))

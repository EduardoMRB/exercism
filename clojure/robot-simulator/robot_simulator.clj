(ns robot-simulator)

(defn robot [coords bearing]
  {:coordinates coords :bearing bearing})

(defn turn-right [bearing]
  (let [opposing-directions {:west  :north
                             :north :east
                             :south :west
                             :east  :south}]
    (opposing-directions bearing)))

(defn turn-left [bearing]
  (let [opposing-directions {:west  :south
                             :north :west
                             :south :east
                             :east  :north}]
    (opposing-directions bearing)))

(defn- turn-robot-right [robot]
  (update-in robot [:bearing] turn-right))

(defn- turn-robot-left [robot]
  (update-in robot [:bearing] turn-left))

(defn- update-coord-fn [coord f]
  (fn [robot]
    (update-in robot [:coordinates coord] f)))

(def ^:private advance-fn
  {:north (update-coord-fn :y inc)
   :south (update-coord-fn :y dec)
   :west  (update-coord-fn :x dec)
   :east  (update-coord-fn :x inc)})

(defn- advance [robot]
  (let [bearing    (:bearing robot)
        advance-fn (advance-fn bearing)]
    (advance-fn robot)))

(defn simulate [commands robot]
  (reduce (fn [robot command]
            (condp = command
              \R (turn-robot-right robot)
              \L (turn-robot-left robot)
              \A (advance robot)))
          robot
          commands))

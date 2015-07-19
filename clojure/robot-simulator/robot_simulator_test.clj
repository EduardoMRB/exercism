(ns robot-simulator-test
  (:require [clojure.test :refer :all]))

(load-file "robot_simulator.clj")

(def robbie (robot-simulator/robot {:x -2 :y 1} :east))
(deftest can-get-vals
  (is (= :east (:bearing robbie)))
  (is (= {:x -2 :y 1} (:coordinates robbie))))

(deftest can-turn
  (is (= :north (robot-simulator/turn-right :west)))
  (is (= :west  (robot-simulator/turn-left :north))))

(deftest can-simulate
  (is (= :west (:bearing (robot-simulator/simulate "RLAALAL" robbie))))
  (is (= {:x 0 :y 2} (:coordinates (robot-simulator/simulate "RLAALAL" robbie)))))

(def clutz  (robot-simulator/robot {:x 0 :y  0} :north))
(def sphero (robot-simulator/robot {:x 2 :y -7} :east))
(def roomba (robot-simulator/robot {:x 8 :y  4} :south))

(deftest simulate-clutz
  (let [clutz (robot-simulator/simulate "LAAARALA" clutz)]
    (is (= :west (:bearing clutz)))
    (is (= {:x -4 :y 1} (:coordinates clutz)))))

(deftest simulate-sphero
  (let [sphero (robot-simulator/simulate "RRAAAAALA" sphero)]
    (is (= :south (:bearing sphero)))
    (is (= {:x -3 :y -8} (:coordinates sphero)))))

(deftest simulate-roomba
  (let [roomba (robot-simulator/simulate "LAAARRRALLLL" roomba)]
    (is (= :north (:bearing roomba)))
    (is (= {:x 11 :y 5} (:coordinates roomba)))))

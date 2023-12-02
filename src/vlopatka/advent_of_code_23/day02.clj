(ns vlopatka.advent-of-code-23.day02
  (:require
   [clojure.edn :as edn]
   [clojure.string :as str]))


(defn old-part1 [input]
  (apply +
         (for [line (str/split-lines input)]
           (let [digits (re-seq #"\d" line)
                 number (str (first digits) (last digits))]
             (edn/read-string number)))))


(def bag-conf {"red" 12
               "blue" 14
               "green" 13})

(defn possible-game? 
  [game]
  true)

(defn part1 [input]
  (apply +
         (for [line (str/split-lines input)]
           (let [line-as-list (re-seq #"\w+" line)
                 game-id (second line-as-list)
                 possible? (possible-game? line)]
             (if possible? (edn/read-string game-id) 0)))))

(comment
  
  (def day02-input (slurp "resources/day02-input.txt"))

  (part1 day02-input)~
  
  (def line "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")

  (re-seq #"\d" line)
  (re-seq #"\w+|\;" line)
;;   ("Game" "1" "3" "blue" "4" "red" ";" "1" "red" "2" "green" "6" "blue" ";" "2" "green")
  
  (.split line ":")
  
  )
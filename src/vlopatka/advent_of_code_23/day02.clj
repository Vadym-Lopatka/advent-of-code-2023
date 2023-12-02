(ns vlopatka.advent-of-code-23.day02
  (:require
   [clojure.string :as str]))

(def bag {"red" 12 "blue" 14 "green" 13})

(defn parse-info [line]
  (let [[game-id & dataset] (re-seq #"\d+|blue|green|red" line)]
    (reduce (fn [m [n k]] (update m k max (parse-long n)))
            {"blue" 0 "green" 0 "red" 0 :game (parse-long game-id)}
            (partition 2 dataset))))

(defn input->games [input] 
  (->> input slurp str/split-lines (map parse-info)))

(defn power [{:strs [blue green red]}] (* blue green red))

(defn possible? [game]
  (->> (merge-with - bag game) vals (not-any? neg?)))

(defn part1 [input]
  (let [games (input->games input)]
    (transduce (comp (filter possible?) (map :game)) + games)))

(defn part2 [input]
  (let [games (input->games input)]
    (transduce (map power) + games) ))

(comment
  (part1 "resources/day02-test-input.txt")
  (part1 "resources/day02-input.txt")
  (part2 "resources/day02-input.txt")
  

  (def line "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
  (re-seq #"\w+|\;" line)
  (re-seq #"\d+|blue|green|red" line)

  (parse-info line)

  )
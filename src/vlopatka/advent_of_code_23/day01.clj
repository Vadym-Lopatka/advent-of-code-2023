(ns vlopatka.advent-of-code-23.day01
  (:require
    [clojure.edn :as edn]
    [clojure.string :as str]))

(def translation-map {"1"     1
                      "2"     2
                      "3"     3
                      "4"     4
                      "5"     5
                      "6"     6
                      "7"     7
                      "8"     8
                      "9"     9
                      "one"   1
                      "two"   2
                      "three" 3
                      "four"  4
                      "five"  5
                      "six"   6
                      "seven" 7
                      "eight" 8
                      "nine"  9
                      })


(defn part1 [input]
  (apply +
         (for [line (str/split-lines input)]
           (let [digits (re-seq #"\d" line)
                 number (str (first digits) (last digits))]
             (edn/read-string number)))))


(defn part2 [input]
  (apply +
         (for [line (str/split-lines input)]
           (let [digits (->> line
                             (re-seq #"(?=(\d|one|two|three|four|five|six|seven|eight|nine))")
                             (mapv (fn [[_ digit]] (translation-map digit digit))))
                 number (str (first digits) (peek digits))]
             (edn/read-string number)))))


(comment
  (def test-input-p1 "1abc2
                     pqr3stu8vwx
                     a1b2c3d4e5f
                     treb7uchet")

  (def test-input-p2 "two1nine
                     eightwothree
                     abcone2threexyz
                     xtwone3four
                     4nineeightseven2
                     zoneight234
                     7pqrstsixteen")

  (part1 test-input-p1)
  (part2 test-input-p2)

  (def day01-input (slurp "resources/day1-input.txt"))

  (part1 day01-input)
  (part2 day01-input)
  )
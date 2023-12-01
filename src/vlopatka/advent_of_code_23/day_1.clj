(ns vlopatka.advent-of-code-23.day-1
  (:require [clojure.string :as string]))

(def day1-str-coll 
  (.split (slurp "resources/day1-input.txt") "\n"))

(def translation-map { "1" 1
                       "2" 2
                       "3" 3
                       "4" 4
                       "5" 5
                       "6" 6
                       "7" 7
                      "8" 8
                      "9" 9 
                      "one" 1
                      "two" 2
                      "three" 3
                      "four" 4
                      "five" 5
                      "six" 6
                      "seven" 7
                      "eight" 8
                      "nine" 9
                      })
  

;; (defn word->num
;;   [raw-string]
;;   (-> raw-string
;;       (.replaceAll "one" "1")
;;       (.replaceAll "two" "2")
;;       (.replaceAll "three" "3")
;;       (.replaceAll "four" "4")
;;       (.replaceAll "five" "5")
;;       (.replaceAll "six" "6")
;;       (.replaceAll "seven" "7")
;;       (.replaceAll "eight" "8")
;;       (.replaceAll "nine" "9") 
;;       ))


;; (defn replace-several [content & replacements]
;;   (let [replacement-list (partition 2 replacements)]
;;     (reduce #(apply string/replace %1 %2) content replacement-list)))

(defn find-digits-keys
  [raw-string]
  (re-seq #"one|two|three|four|five|six|seven|eight|nine|\d" raw-string))

(defn str->num
  [raw-string]
  (let [keys-of-digits (find-digits-keys raw-string) 
        first-num (get translation-map (first keys-of-digits))
        last-num (get translation-map (last keys-of-digits))]
    (Integer/parseInt (str first-num last-num))))

(defn sum-the-strings
  [strings]
  (reduce + (map str->num strings)))

;; (sum-the-strings day1-str-coll) => solution

(comment
;;   (first (.toCharArray "1abc2"))
;;   (Character/isDigit (first (.toCharArray "1abc2"))) 

  (first (filter #(Character/isDigit %1) (.toCharArray "1abc2")))
  (last (filter #(Character/isDigit %1) (.toCharArray "1abc2")))

  (str->num "1abc2")
  (str->num "treb7uchet")

  (Integer/parseInt "12")

  (reduce + [1 2 3])
  (sum-the-strings ["12" "77"])

  (def test-input (.split "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet" "\n"))

  (sum-the-strings test-input)

  (slurp "resources/day1-input.txt")

  (count day1-str-coll)
  (sum-the-strings day1-str-coll)

;;   PART_2

  (def test-inp2 (.split "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen" "\n"))

  (str->num "eightwothree")

  (map str->num test-inp2)
  (sum-the-strings test-inp2)

  (get translation-map "one")
  (re-seq
   #"one|two|three|four|five|six|seven|eight|nine|\d"
   "two1nine")

  ) 
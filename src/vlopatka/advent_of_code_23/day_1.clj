(ns vlopatka.advent-of-code-23.day-1)

(def day1-str-coll 
  (.split (slurp "resources/day1-input.txt") "\n"))

(defn str->num
  [input-string]
  (let [chars (.toCharArray input-string)
        first-num (first (filter #(Character/isDigit %1) chars))
        last-num (last (filter #(Character/isDigit %1) chars))]
    (Integer/parseInt (str first-num last-num))))

(defn sum-the-strings
  [coll-of-strings]
  (let [numbers (map str->num coll-of-strings)]
    (reduce + numbers)))

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
  
  )
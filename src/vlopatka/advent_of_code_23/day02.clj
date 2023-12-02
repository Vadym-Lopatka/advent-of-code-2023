(ns vlopatka.advent-of-code-23.day02
  (:require
   [clojure.edn :as edn]
   [clojure.string :as str]))


(defn part1 [input]
  (apply +
         (for [line (str/split-lines input)]
           (let [digits (re-seq #"\d" line)
                 number (str (first digits) (last digits))]
             (edn/read-string number)))))

(comment
  
  )
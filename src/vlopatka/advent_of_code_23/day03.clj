(ns vlopatka.advent-of-code-23.day03)
  
(defn grid [input]
  (first
   (reduce
    (fn [[g [y x]] ch]
      (if (= ch \newline) [g [(inc y) 0]], [(assoc g [y x] ch) [y (inc x)]]))
    [(sorted-map) [0 0]] input)))

(defn adjacent [point]
  (for [x [-1 0 1] y [-1 0 1] :when (not= [x y] [0 0])] (mapv + [x y] point)))

(defn digit? [c] (java.lang.Character/isDigit c))

(defn number-groups [gr]
  (loop [[k & keys] (keys gr), acc {}, digits [], symbols #{}]
    (cond
      (nil? k) (vals acc),
      (not (digit? (gr k)))
      (recur keys (reduce #(update %1 %2 conj (parse-long (apply str digits))) acc symbols) [] #{}),
      :else
      (let [xf (filter #(when-let [c (gr %)] (not (or (= \. c) (digit? c)))))]
        (recur keys acc (conj digits (gr k)) (into symbols xf (adjacent k)))))))

(defn part1 [raw-input]
  (let [data (->> raw-input grid number-groups)] 
    (->> data flatten (apply +))))

(defn part2 [raw-input]
  (let [data (->> raw-input grid number-groups)]
    (->> data 
         ((fn [v] (keep #(when (= (count %) 2) (apply * %)) v))) 
         (apply +))))

(comment
  (slurp "resources/day03-test-input.txt")
  (part1 (slurp "resources/day03-input.txt"))
  (part2 (slurp "resources/day03-input.txt"))

  )
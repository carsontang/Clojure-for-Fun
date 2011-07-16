(defn print-down-from [x]
	(when (pos? x)
		(println x)
		(recur (dec x))))

(defn sum-from-down [sum x]
	(if (pos? x)
		(recur (+ sum x) (dec x))
		sum))

(defn even [x]
	(let [remainder (mod x 2)]
		(if (= remainder 0) true false)))

(defn sum-evens-helper [sum x]
	(let [is-positive (pos? x)
			is-even (even x)]
			;(do (println "Current number: " x) (println "Even?: " is-even) (println "Positive?: " is-positive))
			(if is-positive
				(if is-even
					(recur (+ sum x) (dec x))
					(recur sum (dec x)))
				sum)))
				
(defn sum-evens [x]
	(sum-evens-helper 0 x))
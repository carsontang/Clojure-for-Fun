; Syntactic sugar for (def (fn ...) )
(defn print-down-from [x]
	(when (pos? x)
		(println x)
		(recur (dec x))))

; Tail recursion
(defn sum-from-down [sum x]
	(if (pos? x)
		(recur (+ sum x) (dec x))
		sum))

(defn sum-evens-helper [sum x]
	(let [is-positive (pos? x)
			is-even (even? x)]
			;(do (println "Current number: " x) (println "Even?: " is-even) (println "Positive?: " is-positive))
			(if is-positive
				(if is-even
					(recur (+ sum x) (dec x))
					(recur sum (dec x)))
				sum)))
				
(defn sum-evens [x]
	(sum-evens-helper 0 x))
	
; Loop, tail recursion w/o the use of a helper function, NEAT!
(defn sum-down-from [initial-x]
   (loop [sum 0, x initial-x]
		(if (pos? x)
			(recur (+ sum x) (dec x))
			sum)))

(defn idiomatic-sum-evens [initial-x]
	(loop [sum 0, x initial-x]
		(let [is-positive (pos? x)
			   is-even (even? x)]
			(if is-positive
				(if is-even
					(recur (+ sum x) (dec x))
					(recur sum (dec x)))
				sum))))
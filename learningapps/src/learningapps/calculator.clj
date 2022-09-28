(ns learningapps.calculator
    (:require [clojure.string :as str])
    (:gen-class))



(defn init []
    (println "Claculator\n")
    (def operators (set '("+" "-" "/" "*")))
    (def allNumbers (list))
    (loop []
        (println (str "What operation do you want to do? (" (str/join " " operators) ")"))
        (def operator (read-line))
        (if-not
            (contains? operators operator)
            (do (println "Invalid Operator") (recur))))
    (loop []
        (println "Wie viele Zahlen wollen sie verrechnen?")
        (def numbersCount (read-string (read-line)))
        (if-not
            (and (int? numbersCount)(> numbersCount 1))
            (do (println "Please enter a number with 2 or higher") (recur))))
    (dotimes [i numbersCount]
        (loop []
            (println (str "Enter number " (inc i)))
            (def enteredNumber (read-string (read-line)))
            (if-not
                (int? enteredNumber)
                (do (println "Please enter a number") (recur))
                (if
                    (and (= operator "/") (> i 0) (= enteredNumber 0))
                    (do (println "You can't divide by 0") (recur))
                    (def allNumbers (conj allNumbers enteredNumber))))))
    (println allNumbers)
    (case operator
        "+" (println "plus")
        "-" (println "minus")
        "*" (println "mal")
        "/" (println "geteilt")
        (println "Invalid Operator")))

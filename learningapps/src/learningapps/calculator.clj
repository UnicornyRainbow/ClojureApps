(ns learningapps.calculator
  (:require [clojure.string :as str])
  (:gen-class))




(defn getOperator [operators]
  (println (str "What operation do you want to do? (" (str/join " " operators) ")"))
  (loop [operator (read-line)]
    (if (contains? operators operator)
      operator
      (do
        (println "Invalid Operator")
        (println (str "What operation do you want to do? (" (str/join " " operators) ")"))
        (recur (read-line))))))

(defn getCountCalculations []
  (println "Wie viele Zahlen wollen sie verrechnen?")
  (loop [calculationsCount (read-string (read-line))]
    (if (and (int? calculationsCount) (> calculationsCount 1))
      calculationsCount
      (do
        (println "Please enter a number with 2 or higher")
        (println "Wie viele Zahlen wollen sie verrechnen?")
        (recur (read-string (read-line)))))))

(defn getNumber [localI localOperator]
  (println (str "Enter number " (inc localI)))
  (loop [enteredNumber (read-string (read-line))]
    (if (int? enteredNumber)
      (if (and (= localOperator "/") (> localI 0) (= enteredNumber 0))
        (do
          (println "You can't divide by 0")
          (println (str "Enter number " (inc localI)))
          (recur (read-string (read-line))))
        enteredNumber)
      (do
        (println "Please enter a number")
        (println (str "Enter number " (inc localI)))
        (recur (read-string (read-line)))))))


(defn init []
  (println "Claculator\n")
  (let [operator (getOperator (set '("+" "-" "/" "*"))) countCalculations (getCountCalculations)]
    (loop [i 0 oldNumber (getNumber i operator)]
      (if (= (inc i) countCalculations)
        (println oldNumber)
        (case operator
          "+" (recur (inc i) (+ oldNumber (getNumber (inc i) operator)))
          "-" (recur (inc i) (- oldNumber (getNumber (inc i) operator)))
          "*" (recur (inc i) (* oldNumber (getNumber (inc i) operator)))
          "/" (recur (inc i) (/ oldNumber (getNumber (inc i) operator)))
          (println "Invalid Operator"))))))

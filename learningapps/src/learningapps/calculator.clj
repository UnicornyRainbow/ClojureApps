(ns learningapps.calculator
    (:require [clojure.string :as str])
    (:gen-class))



(defn init []
    (println "Claculator\n")
    (def operators (set '("+" "-" "/" "*")))
    (loop []
        (println (str "What operation do you want to do? (" (str/join " " operators) ")"))
        (def operator (read-line))
        (if-not (contains? operators operator) (do (println "Invalid Operator") (recur))))
    (loop []
        (println "test"))
    (case operator
        "+" (println "plus")
        "-" (println "minus")
        "*" (println "mal")
        "/" (println "geteilt")
        (println "Invalid Operator")))

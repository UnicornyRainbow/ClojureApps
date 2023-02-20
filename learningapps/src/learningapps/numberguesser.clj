(ns learningapps.numberguesser
  (:require [clojure.string :as str])
  (:gen-class))

(defn readNumber [min max]
  (println (str "The number that is searched is between " min " and " max "."))
  (println (str "Enter a number between " min " and " max "."))
  (loop [enteredNumber (read-string (read-line))]
    (if (and (int? enteredNumber) (> enteredNumber min) (< enteredNumber max))
      enteredNumber
      (do
        (println (str "Enter a number between " min " and " max "."))
        (recur (read-string (read-line)))))))

(defn init []
  (println "Guess the number\n"))
  (let [generatedNumber (rand-int 100)]
    (loop [min 0 max 100]))

(string? (read-line))

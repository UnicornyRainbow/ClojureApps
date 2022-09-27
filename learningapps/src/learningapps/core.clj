(ns learningapps.core
    (:gen-class)
    (:require [clojure.string :as str])
    (:require [learningapps.calculator :as calc]))



(defn idxOf [item coll]
  (count (take-while (partial not= item) coll)))

(defn App2 [] (println "App2"))
(defn App3 [] (println "App3"))

(comment
    (defmacro checkApp [appList]
      `(do
         ~@(map
            #(list 'do (list '= 'enteredApp (str %)) (list %)) appList)))
    (macroexpand '(checkApp #{App1 App2 App3}))

    (defn tester []
      (let [appList #{"App1" "App2" "App3"}]
        (cond
          (checkApp appList)
          :else
          (println "test")))))

(defn end []
    (loop []
        (println "Do you want to start a new app?(y/n)")
        (let [decision (read-line)]
            (cond
                (= decision "y")
                nil
                (= decision "n")
                (System/exit 0)
                :else
                (do
                    (println "Invalid Argument")
                    (recur))))))

(defn chooseApp []
    (loop [appList (list "Calculator" "App2" "App3")]
        (println "Please choose an app to run:")
        (doseq [app appList]
            (println (format "%02d%20s%10s" (+ (idxOf app appList) 1) app (str/lower-case(subs (format "%4s" app) 0 4)))))
        (let [enteredApp (read-line)]
            (cond
                (or (= enteredApp "Calculator") (= enteredApp "1") (= enteredApp "01") (= enteredApp "calc"))
                (do (calc/init) (end))
                (or (= enteredApp "App2") (= enteredApp "2") (= enteredApp "02") (= enteredApp "app2"))
                (do (App2) (end))
                (or (= enteredApp "App3") (= enteredApp "3") (= enteredApp "03") (= enteredApp "app3"))
                (do (App3) (end))
                :else
                (println "Invalid App"))
            (recur appList))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (chooseApp))



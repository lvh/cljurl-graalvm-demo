(ns cljurl-graalvm-demo.core
  (:require [clj-http.lite.client :as http])
  (:gen-class))

(defn -main
  [& args]
  (println (clojure-version))
  (println (http/get "https://www.latacora.com")))

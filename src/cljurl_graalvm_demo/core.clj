(ns cljurl-graalvm-demo.core
  (:require [clj-http.client :as http])
  (:gen-class))

(defn -main
  [& args]
  (println (http/request {:url "https://www.latacora.com"})))

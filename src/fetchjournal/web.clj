(ns fetchjournal.web
  (:use [ring.adapter.jetty :only [run-jetty]]
        [compojure.core :only [defroutes GET POST]]
        [ring.middleware.params :only [wrap-params]]
        [fetchjournal.requests :only [upload-note]]))

(defn sloppy-check [text]
    (if-not (= (str "|" text) "|") (upload-note text)
        (str "Error: please use "
            "\"x-www-form-urlencoded\" data")))

(defroutes routes
    (POST "/" [text] (sloppy-check text)))

(defn -main [port]
    ;wrap-params allows us to exract parameter from requests
    (run-jetty (wrap-params routes) {:port (Integer. port)})); "new Integer(port)"


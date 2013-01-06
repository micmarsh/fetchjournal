(ns fetchjournal.web
  (:use [ring.adapter.jetty :only [run-jetty]]
        [compojure.core :only [defroutes GET POST]]
        [ring.middleware.params :only [wrap-params]]
        [fetchjournal.text]))


(defroutes routes
    (GET "/" [foo] (make-note foo))
    (POST "/poop" [postvar] (str postvar)));(GET "/user/:id" [id]
      ;  (str "<h1>Hello user " id "</h1>")))

(defn -main [port]
    ;wrap-params allows us to exract parameter from requests
    (run-jetty (wrap-params routes) {:port (Integer. port)})); "new Integer(port)"


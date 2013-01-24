(ns fetchjournal.views
    (:use [hiccup.core :only [html]]))

(defn main []
    (html
        [:p {:id "hello"} "Journal it up!"]
        [:textarea {:id "entry"}]))
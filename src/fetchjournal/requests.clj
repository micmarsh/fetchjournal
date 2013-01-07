(ns fetchjournal.requests
    (:use   [clj-http.client :as client]
            [clojure.string/join ]
            [fetchjournal.text :only [make-note]]))


(defn notes-url[username]
    (let [base-url "http://www.fetchnotes.com"]
        (join "/" [base-url "authors" username "notes"])))

(defn upload-note [text]
    (client/get "http://fetchnotes.com"))
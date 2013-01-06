(ns fetchjournal.requests
    :use [clj-http.client :as client ])


(defn notes-url[username]
    (let [base-url "http://www.fetchnotes.com"]
        (apply str (interpose "/" [base-url "authors" username "notes"]))

(defn upload-note [text]
    (client/post))
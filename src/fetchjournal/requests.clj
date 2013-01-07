(ns fetchjournal.requests
    (:use   [clj-http.client :as client]
            [clojure.string :only [join]]
            [fetchjournal.secrets :as secrets]))


(defn notes-url[username]
    (let [base-url "http://www.fetchnotes.com"]
        (join "/" [base-url "authors" username "notes"])))

(defn upload-note [text]
   (str (client/get (notes-url secrets/username))))
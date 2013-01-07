(ns fetchjournal.text
    (:use [clj-time.core :only [now month day]]
            [clj-time.local :only [local-now ]]))

(defn date-tag []
    (let [months ["jan" "feb" "mar" "apr" "may" "june"
             "july" "aug" "sept" "oct" "nov" "dec"]
        now (local-now)]
        (str "#"
           (months (dec (month now)))
           (day now))))

(defn make-note[text]
    (str "#journal " (date-tag) " " text))
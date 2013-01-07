(ns fetchjournal.requests
    (:use   [clj-http.client :as client]
            [clojure.string :only [join]]
            [fetchjournal.secrets :as secrets]))

(defn sha1-str [s]
"blatently copy pasted from https://gist.github.com/1472865"
  (->> (-> "sha1"
           java.security.MessageDigest/getInstance
           (.digest (.getBytes s)))
       (map #(.substring
              (Integer/toString
               (+ (bit-and % 0xff) 0x100) 16) 1))
       (apply str)))


(defn sign [params]
    (let [  paramstring (join (map #(params %) (sort (keys params))))
            prepended (str secrets/private_key paramstring)
            signature (sha1-str prepended)]
            (merge params {:signature signature})
    ))

(defn notes-url[username]
    (let [base-url "http://www.fetchnotes.com"]
        (join "/" [base-url "authors" username "notes"])))

(defn upload-note [text]
   (let [response
        (client/post (notes-ul secrets/username) {
        :accept :json,
        :form-params (sign { :text text,:public_key secrets/public_key})
        })]
   (response :body)))
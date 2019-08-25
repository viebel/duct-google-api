(ns duct.services.google.drive
  (:require
   [integrant.core :as ig]
   [google-api-clj.google-client :refer [create-google-client]]
   [google-api-clj.drive-service :refer [make-service]]))


(defmethod ig/init-key :duct.services.google/drive [_ {:keys [client] :as client-opts}]
  (let [client (or client (create-google-client client-opts))]
    (make-service client)))


(comment
  (ig/init-key :duct.services.google/drive {:credential-path "/Users/viebel/.config/gcloud/application_default_credentials.json"
                                            :application-name "dummy-app"
                                            :scopes [:drive]}))

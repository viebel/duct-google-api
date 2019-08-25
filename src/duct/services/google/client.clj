(ns duct.services.google.client
  (:require
   [integrant.core :as ig]
   [google-api-clj.google-client :refer [create-google-client]]))

(defmethod ig/init-key :duct.services.google/client [_ options]
  (create-google-client options))


(comment (ig/init-key :duct.services.google/client {:credential-path "/Users/viebel/.config/gcloud/application_default_credentials.json"
                                                    :application-name "dummy-app"
                                                    :scopes [:drive]}))

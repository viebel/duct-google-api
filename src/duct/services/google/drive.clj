(ns duct.services.google.drive
  (:require
   [integrant.core :as ig]
   [google-api-clj.google-client :refer [create-google-client]]
   [google-api-clj.sheets-service :refer [make-service]]))

(defmethod ig/init-key :duct.services.google/drive [_ {:keys [client credentials-path]}]
  (make-service (or client (create-google-client credentials-path))))

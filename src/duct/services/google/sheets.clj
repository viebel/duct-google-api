(ns duct.services.google.sheets
  (:require
   [integrant.core :as ig]
   [google-api-clj.google-client :refer [create-google-client]]
   [google-api-clj.sheets-service :refer [make-service]]))

(defmethod ig/init-key :duct.services.google/sheets [_ {:keys [client credentials-path]}]
  (make-service (or client (create-google-client credentials-path))))

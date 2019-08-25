(ns duct.services.google.client
  (:require
   [integrant.core :as ig]
   [google-api-clj.google-client :refer [create-google-client]]))

(defmethod ig/init-key :duct.services.google/client [_ {:keys [credentials-path]}]
  (create-google-client credentials-path))

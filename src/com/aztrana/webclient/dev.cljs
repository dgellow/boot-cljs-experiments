(ns com.aztrana.webclient.dev
  (:require [com.aztrana.webclient.core :as core]
            [com.aztrana.webclient.tests :as tests]))

(defn reload []
  (do
    (core/main)
    (tests/run)))

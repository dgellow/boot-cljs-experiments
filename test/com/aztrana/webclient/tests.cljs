(ns com.aztrana.webclient.tests
  (:require
   [cljs.test :as t :refer-macros [deftest is testing run-tests]]
   [com.aztrana.webclient.core :as app]))

;; Tests
(deftest successful-test
  (is (= 1 1)))

(deftest failing-test
  (is (= 1 2)))

;; Entrypoint
(defn run []
  (enable-console-print!)
  (println "_____________")
  (println "-   tests   -")
  (run-tests)
  (println "_____________"))

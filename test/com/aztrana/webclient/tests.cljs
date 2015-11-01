(ns com.aztrana.webclient.tests
  (:require
   [cljs.test :as t :refer-macros [deftest is testing]]
   [com.aztrana.webclient.core :as app]))

(deftest successful-test
  (is (= 1 1)))

(deftest failing-test
  (is (= 1 2)))

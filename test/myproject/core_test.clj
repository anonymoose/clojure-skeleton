(ns myproject.core-test
  (:require [clojure.test :refer :all]
            [myproject.core :refer :all]
            [myproject.data :refer :all]))

(deftest data-test
  (testing "Can retrieve data"
    (is (seq (get-table "^GSPC")))
    (is (seq (series "^GSPC")))))

(deftest buy-and-hold-test
  (testing "Can simulate buy-and-hold"
    (is (number? (buy-and-hold sample-step)))))

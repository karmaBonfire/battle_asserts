(ns battle-asserts.issues.biggest-second-number-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :as ct]
            [test-helper :as h]
            [battle-asserts.issues.biggest-second-number :as issue]))

(ct/defspec spec-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (let [result (apply issue/solution v)]
                  (if (nil? result)
                    true
                    (instance? Number result)))))

(deftest test-solution
  (h/generate-tests issue/test-data issue/solution))


(ns hi-quil.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [hi-quil.core-test]
   [hi-quil.common-test]))

(enable-console-print!)

(doo-tests 'hi-quil.core-test
           'hi-quil.common-test)

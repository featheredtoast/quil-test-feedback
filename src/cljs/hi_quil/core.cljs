(ns hi-quil.core
  (:require [rum.core :as rum]))

(enable-console-print!)

(def app-state (atom {:text "Reloadable quil"}))

(rum/defc greeting < rum/reactive []
   [:h1 (:text (rum/react app-state))])

(defn render []
  (rum/mount (greeting) (. js/document (getElementById "app"))))

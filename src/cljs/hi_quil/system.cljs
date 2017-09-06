(ns hi-quil.system
  (:require [com.stuartsierra.component :as component]
            [hi-quil.components.ui :refer [new-ui-component]]
            [hi-quil.components.ball :refer [new-sketch-component]]))

(declare system)

(defn new-system []
  (component/system-map
   :app-root (new-ui-component)
   :draw-canvas (new-sketch-component)))

(defn init []
  (set! system (new-system)))

(defn start []
  (set! system (component/start system)))

(defn stop []
  (set! system (component/stop system)))

(defn ^:export go []
  (init)
  (start))

(defn reset []
  (stop)
  (go))

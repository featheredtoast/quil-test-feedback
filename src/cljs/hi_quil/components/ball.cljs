(ns hi-quil.components.ball
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            [com.stuartsierra.component :as component]))

(defn setup []
  ; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  ; Set color mode to HSB (HSV) instead of default RGB.
  (q/color-mode :hsb)
  ; setup function returns initial state. It contains
  ; circle color and position.
  nil)

(defn update-state [state]
  ; Update sketch state by changing circle color and position.
  state)

(defn draw-state [state]
  ; Clear the sketch by filling it with light-grey color.
  (q/background 240)
  ; Set circle color.
  (q/fill 0 255 255)
  ; Calculate x and y coordinates of the circle.
  (q/ellipse 25 25 50 50))

(defn get-sketch []
  (q/sketch
  :host "my-sketch"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode]))

(defrecord Sketch [sketch]
  component/Lifecycle
  (start [component]
    (let [sketch (get-sketch)]
      (assoc component :sketch sketch)))
  (stop [component]
    (when-let [sketch (:sketch component)]
      (.exit sketch))
    (dissoc component :sketch)))

(defn new-sketch-component []
  (map->Sketch {}))

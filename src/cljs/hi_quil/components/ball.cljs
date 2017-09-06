(ns hi-quil.components.ball
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            [com.stuartsierra.component :as component]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  nil)

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/background 220)
  (q/fill 0 255 255)
  (q/ellipse 250 250 50 50))

(q/defsketch my-sketch
  :host "my-sketch"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])

(defrecord Sketch [sketch]
  component/Lifecycle
  (start [component]
    (let [sketch (my-sketch)]
      (assoc component :sketch sketch)))
  (stop [component]
    (when-let [sketch (:sketch component)]
      (.exit sketch))
    (dissoc component :sketch)))

(defn new-sketch-component []
  (map->Sketch {}))

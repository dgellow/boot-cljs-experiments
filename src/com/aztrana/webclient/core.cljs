(ns com.aztrana.webclient.core
  (:require [reagent.core :as r]))

(def input-text (r/atom ""))

(defn simple-component []
  [:div
   [:p "I am a component"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text"]])

(defn input-component [value]
  [:input {:type "text"
           :value @value
           :placeholder "Enter some text"
           :on-change #(reset! value (-> % .-target .-value))}])

(defn root-component []
  (fn []
    [:div
     [simple-component]
     [input-component input-text]
     [:p @input-text]]))

(defn main []
  (r/render-component [root-component]
                      (.querySelector js/document "#container")))

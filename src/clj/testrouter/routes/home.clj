(ns testrouter.routes.home
  (:require
   [testrouter.layout :as layout]
   [clojure.java.io :as io]
   [testrouter.middleware :as middleware]
   [ring.util.response :refer [response]]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn foobar-get [request]
  (response {:foobar "get"}))

(defn foobar-post [request]
  (response {:foobar "post"}))

(defn home-routes []
  [""
   ;{:middleware [middleware/wrap-csrf
   ;              middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]

   ["/foobar" {:get foobar-get
               :post foobar-post}]])


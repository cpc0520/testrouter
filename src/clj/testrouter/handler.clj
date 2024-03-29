(ns testrouter.handler
  (:require
    [testrouter.middleware :as middleware]
    [testrouter.layout :refer [error-page]]
    [testrouter.routes.home :refer [home-routes]]
    [reitit.ring :as ring]
    [ring.middleware.content-type :refer [wrap-content-type]]
    [ring.middleware.webjars :refer [wrap-webjars]]
    [testrouter.env :refer [defaults]]
    [ring.middleware.json :refer [wrap-json-response]]
    [mount.core :as mount]))

(mount/defstate init-app
  :start ((or (:init defaults) (fn [])))
  :stop  ((or (:stop defaults) (fn []))))

(mount/defstate app-routes
  :start
  (ring/ring-handler
    (ring/router
      [(home-routes)])
    (ring/routes
      (ring/create-resource-handler
        {:path "/"})
      (wrap-content-type
        (wrap-webjars (constantly nil)))
      (ring/create-default-handler
        {:not-found
         ;(constantly (error-page {:status 404, :title "404 - Page not found"}))
         (constantly {:status 404, :body "Not found"})
         :method-not-allowed
         ;(constantly (error-page {:status 405, :title "405 - Not allowed"}))
         (constantly {:status 405, :body "Not allowed"})
         :not-acceptable
         ;(constantly (error-page {:status 406, :title "406 - Not acceptable"}))}))))
          (constantly {:status 406, :body "Not acceptable"})}))))

(defn app []
  (wrap-json-response #'app-routes))

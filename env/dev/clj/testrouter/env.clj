(ns testrouter.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [testrouter.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[testrouter started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[testrouter has shut down successfully]=-"))
   :middleware wrap-dev})

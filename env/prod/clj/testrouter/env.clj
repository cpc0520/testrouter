(ns testrouter.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[testrouter started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[testrouter has shut down successfully]=-"))
   :middleware identity})

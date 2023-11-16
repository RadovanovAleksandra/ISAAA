import { useEffect } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { useAuthentication } from "../api/auth/AuthenticationContext";
import { AuthRoutes, UnauthRoutes } from "./RoutesConfig";
import React from "react";

const RouteHandler = () => {
  const { isAuthenticated } = useAuthentication();

  useEffect(() => {
  }, [isAuthenticated]);

  return (
    <Router>
      {isAuthenticated ? <AuthRoutes /> : <UnauthRoutes />}
    </Router>
  );
};

export default RouteHandler;
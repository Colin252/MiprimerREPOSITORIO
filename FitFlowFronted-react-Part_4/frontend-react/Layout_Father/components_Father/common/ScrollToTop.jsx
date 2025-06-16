import { useEffect } from "react";
import { useLocation } from "react-router-dom";

export function ScrollToTop() {
  const { pathname } = useLocation();

  useEffect(() => {
    const excludedPaths = ["/login", "/register"]; // rutas donde NO hacer scroll

    if (!excludedPaths.includes(pathname)) {
      window.scrollTo({
        top: 0,
        left: 0,
        behavior: "smooth",
      });
    }
  }, [pathname]);

  return null;
}

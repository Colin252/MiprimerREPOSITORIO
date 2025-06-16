import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";  // corregido para React Router v6+
import { useSidebar } from "../context/SidebarContext";
import { ThemeToggleButton } from "../components_Son/common/ThemeToggleButton";
import NotificationDropdown from "../components_Son/header/NotificationDropdown";
import UserDropdown from "../components_Son/header/UserDropdown";

import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
import { useSidebar } from "../context/SidebarContext";
import { ThemeToggleButton } from "../components_Son/common/ThemeToggleButton";
import NotificationDropdown from "../components_Son/header/NotificationDropdown";
import UserDropdown from "../components_Son/header/UserDropdown";

const AppHeader = () => {
  const [isApplicationMenuOpen, setApplicationMenuOpen] = useState(false);
  const { isMobileOpen, toggleSidebar, toggleMobileSidebar } = useSidebar();
  const inputRef = useRef(null);

  const handleToggle = () => {
    if (window.innerWidth >= 1024) {
      toggleSidebar();
    } else {
      toggleMobileSidebar();
    }
  };

  const toggleApplicationMenu = () => {
    setApplicationMenuOpen(!isApplicationMenuOpen);
  };

  useEffect(() => {
    const handleKeyDown = (event) => {
      if ((event.metaKey || event.ctrlKey) && event.key === "k") {
        event.preventDefault();
        if (inputRef.current) inputRef.current.focus();
      }
    };

    document.addEventListener("keydown", handleKeyDown);
    return () => document.removeEventListener("keydown", handleKeyDown);
  }, []);

  return (
    <header className="sticky top-0 flex w-full bg-white border-gray-200 z-50 dark:border-gray-800 dark:bg-gray-900 lg:border-b">
      <div className="flex flex-col items-center justify-between grow lg:flex-row lg:px-6">
        <div className="flex items-center justify-between w-full gap-2 px-3 py-3 border-b border-gray-200 dark:border-gray-800 sm:gap-4 lg:justify-normal lg:border-b-0 lg:px-0 lg:py-4">
          <button
            onClick={handleToggle}
            className="items-center justify-center w-10 h-10 text-gray-500 border-gray-200 rounded-lg dark:border-gray-800 lg:flex dark:text-gray-400 lg:h-11 lg:w-11 lg:border"
            aria-label="Toggle Sidebar"
          >
            {isMobileOpen ? (
              <svg
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fillRule="evenodd"
                  clipRule="evenodd"
                  d="M6.22 7.28a.75.75 0 0 1 1.06-1.06L12 10.94l4.72-4.72a.75.75 0 1 1 1.06 1.06L13.06 12l4.72 4.72a.75.75 0 0 1-1.06 1.06L12 13.06l-4.72 4.72a.75.75 0 0 1-1.06-1.06L10.94 12 6.22 7.28Z"
                  fill="currentColor"
                />
              </svg>
            ) : (
              <svg
                width="16"
                height="12"
                viewBox="0 0 16 12"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fillRule="evenodd"
                  clipRule="evenodd"
                  d="M0.58 1c0-.41.34-.75.75-.75h13.33c.41 0 .75.34.75.75s-.34.75-.75.75H1.33A.75.75 0 0 1 .58 1Zm0 5c0-.41.34-.75.75-.75h13.33c.41 0 .75.34.75.75s-.34.75-.75.75H1.33A.75.75 0 0 1 .58 6Zm.75 4.25a.75.75 0 1 0 0 1.5h13.33a.75.75 0 1 0 0-1.5H1.33Z"
                  fill="currentColor"
                />
              </svg>
            )}
          </button>

          <Link to="/" className="text-xl font-bold text-gray-800 dark:text-white">
            FitFlow
          </Link>
        </div>

        <div className="flex items-center gap-2 px-4 py-2 sm:gap-4 lg:gap-6">
          <ThemeToggleButton />
          <NotificationDropdown />
          <UserDropdown />
        </div>
      </div>
    </header>
  );
};

export default AppHeader;

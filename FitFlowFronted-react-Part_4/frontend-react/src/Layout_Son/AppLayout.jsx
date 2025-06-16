import React from "react";
import { Outlet } from "react-router-dom";
import clsx from "clsx";

import { SidebarProvider, useSidebar } from "../context/SidebarContext";
import AppSidebar from "./AppSidebar";
import AppHeader from "./AppHeader";
import Backdrop from "./Backdrop";

const LayoutContent = () => {
    const { isExpanded, isHovered, isMobileOpen } = useSidebar();

    return (
        <div className="min-h-screen xl:flex bg-gray-100 text-gray-900">
            {/* Sidebar + backdrop */}
            <div className="z-40">
                <AppSidebar />
                <Backdrop />
            </div>

            {/* Contenido principal */}
            <div
                className={clsx(
                    "flex-1 transition-all duration-300 ease-in-out",
                    isExpanded || isHovered ? "lg:ml-[290px]" : "lg:ml-[90px]",
                    isMobileOpen && "ml-0"
                )}
            >
                <AppHeader />
                <main className="p-4 mx-auto max-w-[var(--breakpoint-2xl)] md:p-6">
                    <Outlet />
                </main>
            </div>
        </div>
    );
};

const AppLayout = () => {
    return (
        <SidebarProvider>
            <LayoutContent />
        </SidebarProvider>
    );
};

export default AppLayout;

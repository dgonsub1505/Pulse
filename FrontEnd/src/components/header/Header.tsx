import { motion } from "motion/react";
import { NavLink } from "react-router-dom";
import logo from "../../assets/logo.svg";
import "./Header.css";

export default function Header() {
  let navRefs = [
    { path: "performance", label: "Performance" },
    { path: "processes", label: "Processes" },
    { path: "network", label: "Network" },
    { path: "storage", label: "Storage" },
    { path: "logs", label: "Logs" },
    { path: "alerts", label: "Alerts" },
    { path: "settings", label: "Settings" },
  ];
  return (
    <motion.header
      className="header"
      initial={{ transform: "translateY(-100%)" }}
      animate={{ transform: "translateY(0)" }}
      exit={{ transform: "translateY(-100%)" }}
      transition={{
        transform: { ease: "easeInOut", duration: 0.5 },
      }}
    >
      <div className="header-tittle">
        <img src={logo} alt="" />
        <h1>Pulse</h1>
      </div>
      <nav>
        {navRefs.map((ref) => {
          return (
            <NavLink className="header-nav" to={ref.path}>
              <p>{ref.label}</p>
              <div></div>
            </NavLink>
          );
        })}
      </nav>
    </motion.header>
  );
}

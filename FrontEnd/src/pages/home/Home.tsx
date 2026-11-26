import Header from "../../components/header/Header";
import "./Home.css";
import { motion, AnimatePresence } from "motion/react";
import { useLocation, useOutlet } from "react-router-dom";
export default function Home() {
  const location = useLocation();
  const outlet = useOutlet();
  return (
    <main>
      <Header />
      <AnimatePresence mode="wait">
        <motion.article
          key={location.pathname}
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0 }}
          transition={{
            opacity: { ease: "easeInOut", duration: 0.5 },
          }}
        >
          {outlet}
        </motion.article>
      </AnimatePresence>
    </main>
  );
}

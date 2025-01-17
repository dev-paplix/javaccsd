import { ColorModeContext, useMode } from "./base/theme";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { Routes , Route } from "react-router-dom";
import Topbar from "./HodViews/scense/global/Topbar";
import SidebarAdmin from "./HodViews/scense/global/SidebarAdmin";
import DashboardAdmin from "./HodViews/scense/dashboard";
import TeamAdmin from "./HodViews/scense/team";
import AddTeam from "./HodViews/scense/team/addTeam";
import SignInSide from "./FrontEnd/scense/SignInSide";
import SignUpSide from "./FrontEnd/scense/SignUpSide";
import WebsiteComponentsAdmin from "./HodViews/scense/websites/websiteComponents";
import Services from "./HodViews/scense/services";
import AddProduct from "./HodViews/scense/services/addProduct";
import AddWebsiteText from "./HodViews/scense/websites/addWebsiteTexts";
import AddWebsiteImage from "./HodViews/scense/websites/addWebsiteImage";
import AddWebsiteGallery from "./HodViews/scense/websites/addWebsiteGallery";
import Landing from "./landingpage/landing";
import "./App.css";
import Payment from "./payment/payment";



const HodViewsLayout = ({ children }) => {
  const [theme, colorMode] = useMode();

  return (
    <ColorModeContext.Provider value={colorMode}>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <div className="app">
          <SidebarAdmin />
          <main className="content">
            <Topbar />
            {children}
          </main>
        </div>
      </ThemeProvider>
    </ColorModeContext.Provider>
  );
};

// Update the App component to use HodViewsLayout for HodViews pages
function App() {
  return (
    <Routes>
      
      <Route
        path="/"
        element={
          <Landing />
        }
      />
      <Route
        path="/sign-in"
        element={
          <SignInSide />
        }
      />
      <Route
        path="/sign-up"
        element={
          <SignUpSide />
        }
      />

      <Route
        path="/payment"
        element={
          <Payment />
        }
      />
      <Route
        path="/payment/:productSlug"
        element={
          <Payment />
        }
      />

      <Route
        path="/dashboard-admin"
        element={
          <HodViewsLayout>
            <DashboardAdmin />
          </HodViewsLayout>
        }
      />
      <Route
        path="/team-admin"
        element={
          <HodViewsLayout>
            <TeamAdmin />
          </HodViewsLayout>
        }
      />
      <Route
        path="/addteam"
        element={
          <HodViewsLayout>
            <AddTeam />
          </HodViewsLayout>
        }
      />

      <Route
        path="/website-components-admin"
        element={
          <HodViewsLayout>
            <WebsiteComponentsAdmin />
          </HodViewsLayout>
        }
      />
      <Route
        path="/website-text-admin"
        element={
          <HodViewsLayout>
            <AddWebsiteText />
          </HodViewsLayout>
        }
      />
      <Route
        path="/website-image-admin"
        element={
          <HodViewsLayout>
            <AddWebsiteImage />
          </HodViewsLayout>
        }
      />
      <Route
        path="/website-image-gallery"
        element={
          <HodViewsLayout>
            <AddWebsiteGallery />
          </HodViewsLayout>
        }
      />

      <Route
        path="/services"
        element={
          <HodViewsLayout>
            <Services />
          </HodViewsLayout>
        }
      />
      <Route
        path="/add-product"
        element={
          <HodViewsLayout>
            <AddProduct />
          </HodViewsLayout>
        }
      />

      
    </Routes>
  );
}

export default App;

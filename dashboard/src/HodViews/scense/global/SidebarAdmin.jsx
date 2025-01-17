import { useState } from "react";
import { Sidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import { Link, useNavigate } from "react-router-dom";
import profileAvatar from "../../../assets/profile-avatar.png";
import { tokens } from "../../../base/theme";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import ScreenSearchDesktopIcon from "@mui/icons-material/ScreenSearchDesktop";
import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
import CategoryIcon from "@mui/icons-material/Category";
import LogoutIcon from "@mui/icons-material/Logout";

const Item = ({ title, to, icon, selected, setSelected }) => {
	const theme = useTheme();
	const colors = tokens(theme.palette.mode);
	return (
		<Link to={to} style={{ textDecoration: "none" }}>
			<MenuItem
				active={selected === title}
				style={{
					color: colors.grey[100],
				}}
				onClick={() => setSelected(title)}
				icon={icon}
			>
				<Typography>{title}</Typography>
			</MenuItem>
		</Link>
	);
};

const SidebarAdmin = () => {
	const theme = useTheme();
	const colors = tokens(theme.palette.mode);
	const [isCollapsed, setIsCollapsed] = useState(false);
	const [selected, setSelected] = useState("Dashboard");
	const navigate = useNavigate();

	const handleLogout = () => {
		// Clear any stored data (e.g., tokens)
		localStorage.clear();
		// Redirect to the login page
		navigate("/sign-in");
	};

	return (
		<Box
			sx={{
				"& .sidebar-inner": {
					background: `${colors.primary[400]}`,
				},
				"& .icon-wrapper": {
					backgroundColor: "transparent !important",
				},
				"& .inner-item": {
					padding: "5px 35px 5px 20px !important",
				},
				"& .inner-item:hover": {
					color: "#868dfb !important",
				},
				"& .menu-item.active": {
					color: "#6870fa !important",
				},
			}}
		>
			<Sidebar
				collapsed={isCollapsed}
				backgroundColor={`${colors.primary[400]}`}
			>
				<Menu iconShape="square">
					{/* LOGO AND MENU ICON */}
					<MenuItem
						onClick={() => setIsCollapsed(!isCollapsed)}
						icon={isCollapsed ? <MenuOutlinedIcon /> : undefined}
						style={{
							margin: "10px 0 20px 0",
							color: colors.grey[100],
						}}
					>
						{!isCollapsed && (
							<Box
								display="flex"
								justifyContent="space-between"
								alignItems="center"
								ml="15px"
							>
								<Typography variant="h3" color={colors.grey[100]}>
									Admins
								</Typography>
								<IconButton onClick={() => setIsCollapsed(!isCollapsed)}>
									<MenuOutlinedIcon />
								</IconButton>
							</Box>
						)}
					</MenuItem>

					{!isCollapsed && (
						<Box mb="25px">
							<Box display="flex" justifyContent="center" alignItems="center">
								<img
									alt="profile-user"
									width="100px"
									height="100px"
									src={profileAvatar}
									style={{ cursor: "pointer", borderRadius: "50%" }}
								/>
							</Box>
							<Box textAlign="center">
								<Typography
									variant="h2"
									color={colors.grey[100]}
									fontWeight="bold"
									sx={{ m: "10px 0 0 0" }}
								>
									Admin
								</Typography>
								<Typography variant="h5" color={colors.greenAccent[500]}>
									Super Admin
								</Typography>
							</Box>
						</Box>
					)}

					<Box paddingLeft={isCollapsed ? undefined : "10%"}>
						<Item
							title="Dashboard"
							to="/dashboard-admin"
							icon={<HomeOutlinedIcon />}
							selected={selected}
							setSelected={setSelected}
						/>

						<Typography
							variant="h6"
							color={colors.grey[300]}
							sx={{ m: "15px 0 5px 20px" }}
						>
							Pages
						</Typography>
						<Item
							title="Website Components"
							to="/website-components-admin"
							icon={<ScreenSearchDesktopIcon />}
							selected={selected}
							setSelected={setSelected}
						/>
						<Typography
							variant="h6"
							color={colors.grey[300]}
							sx={{ m: "15px 0 5px 20px" }}
						>
							Users
						</Typography>
						<Item
							title="Users"
							to="/team-admin"
							icon={<PeopleOutlinedIcon />}
							selected={selected}
							setSelected={setSelected}
						/>

						<Typography
							variant="h6"
							color={colors.grey[300]}
							sx={{ m: "15px 0 5px 20px" }}
						>
							Products and Accounting
						</Typography>
						<Item
							title="Products"
							to="/services"
							icon={<CategoryIcon />}
							selected={selected}
							setSelected={setSelected}
						/>

						{/* Logout Button */}
						<MenuItem
							onClick={handleLogout}
							icon={<LogoutIcon />}
							style={{
								marginTop: "20px",
								color: colors.redAccent[400],
							}}
						>
							<Typography>Logout</Typography>
						</MenuItem>
					</Box>
				</Menu>
			</Sidebar>
		</Box>
	);
};

export default SidebarAdmin;

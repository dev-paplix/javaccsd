import axios from "axios";

const API_BASE_URL = "http://localhost:8082";

const AuthService = {
	async login(email, password) {
		try {
			// const response = await axios.post(`${API_BASE_URL}/api/users`, {
			//     email,
			//     password,
			// },

			const response = await axios.get(
				`${API_BASE_URL}/api/users`, // Use the correct endpoint for sign-in
				{ email, password }, // Pass email and password in the request body
				{
					headers: {
						"Content-Type": "application/json",
					},
				}
			);

			if (response.status === 200) {
				// Store the JWT token in localStorage
				localStorage.setItem("jwtToken", response.data.token);
				localStorage.setItem("userName", response.data.username);
				localStorage.setItem("userType", response.data.user_type);
				return true;
			}
		} catch (error) {
			console.error("Login failed:", error);
			return false;
		}
	},

	async addTeamSave(
		email,
		password,
		firstName,
		lastName,
		phone,
		address,
		role,
		userName
	) {
		const username = await localStorage.getItem("userName");

		console.log(email);
		console.log(password);
		console.log(firstName);
		console.log(userName);
		console.log(phone);
		console.log(address);
		console.log(role);
		console.log(lastName);
		try {
			// {
			// 	params: {
			// 		username: userName,
			// 		email: email,
			// 		password: password,
			// 		firstName: firstName,
			// 		lastName: lastName,
			// 		phoneNumber: phone,
			// 		address: address,
			// 		role: role,
			// 	},
			// },
			const response = await axios.post(
			    `${API_BASE_URL}/api/users?username=${username}
				&email=${email}
				&password=${password}
				&firstName=${firstName}
				&lastName=${lastName}
				&phoneNumber=${phone}
				&address=${address}
				&role=${role}`,
				{
					headers: {
						"Content-Type": "application/json",
						Accept: "*/*",
					},
				}
			);

			if (response.status === 200) {
				return response.data;
			}
		} catch (error) {
			if (error.response) {
				console.error("Server responded with an error:", error.response.data);
			} else if (error.request) {
				console.error("No response received:", error.request);
			} else {
				console.error("Error setting up the request:", error.message);
			}
			throw error;
		}
	},
};

export default AuthService;

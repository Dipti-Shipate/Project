import axios from 'axios';

const SERVER_SIDE_URL = 'http://localhost:8080/patient';

class APIService {

    addUser(user){
        return axios.post(SERVER_SIDE_URL, user);
    }
}

export default new APIService();
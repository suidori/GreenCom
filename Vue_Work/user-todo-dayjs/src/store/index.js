import { createStore } from 'vuex';
import axios from 'axios';

const store = createStore({
  state: {
    isLoggedIn: false,
    token: null,
  },
  mutations: {
    login(state, token) {
      state.isLoggedIn = true;
      state.token = token;
    },
    logout(state) {
      state.isLoggedIn = false;
      state.token = null;
    },
  },
  actions: {
    async login({ commit }, { userid, password }) {
      const response = await axios.post('http://192.168.0.67:8080/sign/login', {
        userid,
        password,
      });
      const token = response.data;
      localStorage.setItem('token', token);
      commit('login', token);
    },
    
    logout({ commit }) {
      localStorage.removeItem('token');
      commit('logout');
    },
  },
});

export default store;

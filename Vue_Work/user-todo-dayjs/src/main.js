import { createApp } from 'vue';
import App from './App.vue';
import store from './store';
import router from './router';

createApp(App)
  .use(store) // Vuex 사용
  .use(router) // Vue Router 사용
  .mount('#app');

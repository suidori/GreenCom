<template>
  <div>
    <h1>로그인</h1>
    <form @submit.prevent="handleLogin">
      <div>
        <label for="userid">사용자 ID:</label>
        <input type="text" v-model="userid" id="userid" required />
      </div>
      <div>
        <label for="password">비밀번호:</label>
        <input type="password" v-model="password" id="password" required />
      </div>
      <button type="submit">로그인</button>
    </form>
    <p v-if="errorMessage">{{ errorMessage }}</p>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
  setup() {
    const userid = ref('');
    const password = ref('');
    const errorMessage = ref('');
    const store = useStore();

    const handleLogin = async () => {
      try {
        await store.dispatch('login', { userid: userid.value, password: password.value });
        console.log('로그인 성공');
        // 로그인 성공 후 홈 페이지로 리디렉션
      } catch (error) {
        errorMessage.value = '로그인 실패';
        console.error(error);
      }
    };

    return {
      userid,
      password,
      errorMessage,
      handleLogin,
    };
  },
};
</script>
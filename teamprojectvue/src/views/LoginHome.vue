<template>
  <div class="flex justify-center items-center space-x-4 p-10">
    <!-- 교직원/학생 로그인 -->
    <div class="flex flex-col items-center">
      <h3 class="text-lg font-bold text-blue-700 mb-2">교직원/학생 로그인</h3>
      <div
        class="bg-white shadow-lg rounded-lg p-6 w-64 h-60 flex flex-col items-center bg-gradient-to-t from-sky-300 to-60%"
      >
        <img src="../images/stu.png" alt="" class="w-20" />

        <p class="text-sm text-gray-500 mt-2">교직원/학생 전용 로그인입니다.</p>
        <div class="flex items-center mt-4 justify-center">
          <RouterLink to="/loginview">
            <button type="button" class="text-blue-700 font-semibold inline-flex">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                fill="currentColor"
                class="size-16"
              >
                <path
                  fill-rule="evenodd"
                  d="M12 1.5a5.25 5.25 0 0 0-5.25 5.25v3a3 3 0 0 0-3 3v6.75a3 3 0 0 0 3 3h10.5a3 3 0 0 0 3-3v-6.75a3 3 0 0 0-3-3v-3c0-2.9-2.35-5.25-5.25-5.25Zm3.75 8.25v-3a3.75 3.75 0 1 0-7.5 0v3h7.5Z"
                  clip-rule="evenodd"
                />
              </svg>
              <p class="py-5 p-5">교직원/학생</p>
            </button>
          </RouterLink>
        </div>
      </div>
    </div>

    <!-- 비로그인 (출결용) -->
    <div class="flex flex-col items-center">
      <h3 class="text-lg font-bold text-blue-700 mb-2">비로그인 (출결용)</h3>
      <div
        class="bg-white shadow-lg rounded-lg p-6 w-64 h-60 flex flex-col items-center bg-gradient-to-t from-sky-300 to-60%"
      >
        <img src="../images/tea.png" alt="#" class="w-20" />
        <p class="text-sm text-gray-500 mt-2">출결 전용 페이지입니다.</p>
        <div class="flex items-center mt-4">
          <RouterLink to="/guestattendance">
            <button type="button" class="text-blue-700 font-semibold inline-flex">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                fill="currentColor"
                class="size-16"
              >
                <path
                  fill-rule="evenodd"
                  d="M12 1.5a5.25 5.25 0 0 0-5.25 5.25v3a3 3 0 0 0-3 3v6.75a3 3 0 0 0 3 3h10.5a3 3 0 0 0 3-3v-6.75a3 3 0 0 0-3-3v-3c0-2.9-2.35-5.25-5.25-5.25Zm3.75 8.25v-3a3.75 3.75 0 1 0-7.5 0v3h7.5Z"
                  clip-rule="evenodd"
                />
              </svg>
              <p class="py-5 p-5">비로그인</p>
            </button>
          </RouterLink>
        </div>
      </div>
    </div>
  </div>

  <div class="text-center">
    <p class="text-blue-900 font-bold text-sm">회원이 아니신가요?</p>
    <button
      @click="ToJoinview()"
      class="border-2 bg-blue-900 text-white font-bold px-10 py-3 text-sm rounded-sm"
    >
      회원가입 페이지로이동하기
    </button>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()

const ToJoinview = () => {
  router.push({ path: 'joinview' })
}
</script>

<style lang="scss" scoped></style>

<template>
  <div
    class="fixed w-24 lg:w-28 max-sm:hidden top-1/2 right-5 lg:right-8 xl:right-16 transform -translate-y-1/2 bg-white text-blue-900 p-4 rounded-md shadow-lg hover:bg-slate-100 transition-colors duration-200"
  >
    <!-- 배너 내용 -->
    <h1 class="text-2xl font-bold text-center">Quick</h1>
    <h2 class="text-lg font-semibold mb-2 text-center">Menu</h2>
    <hr class="border-gray-300" />
    <!-- 버튼 -->
     <RouterLink to="attendancecheck">
    <button
      class="block mt-2 bg-white text-blue-900 px-3 py-1 rounded hover:bg-gray-200 transition-colors duration-300">

      <img src="../images/calln.jpg" alt="#" class="w-20" />
      <p class="text-sm">출결관리</p>
    </button>
  </RouterLink>
    <button
      class="block mt-2 bg-white text-blue-900 px-3 py-1 rounded hover:bg-gray-200 transition-colors duration-300"
      @click="handleClick"
    >
      <img src="../images/Ques.jpg" alt="#" class="w-20" />
      <p class="text-sm">문의사항</p>
    </button>
    <button
      class="block mt-2 bg-white text-blue-900 px-3 py-1 rounded hover:bg-gray-200 transition-colors duration-300"
      @click="handleClick"
    >
      <img src="../images/homeIcon.jpg" alt="#" class="w-20" />
      <p class="text-sm">내페이지</p>
    </button>
    <button
      class="block mt-2 bg-white text-blue-900 px-3 py-1 rounded hover:bg-gray-200 transition-colors duration-300"
      @click="handleClick"
    >
      <img src="../images/napal.jpg" alt="#" class="w-20" />
      <p class="text-sm">알림마당</p>
    </button>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const handleClick = () => {
  router.push({ name: 'mypage' })
}
</script>

<style scoped>
/* 추가적인 스타일이 필요하다면 여기에 작성 */
</style>

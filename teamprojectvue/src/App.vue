<template>
  <nav class="relative mx-0">
    <div class="flex justify-between">
      <div class="flex items-center space-x-4 z-10">
        <div class="w-1/6"><RouterLink to="/">
          <img src="./images/LOGO.PNG" alt="" class=" max-md:w-28 ml-3">
        </RouterLink></div>
      </div>
      <div class="flex items-center text-white z-10">
        <div class="mr-2"><RouterLink to="/loginview">| 로그인</RouterLink></div>
        <div class="mr-2"><RouterLink to="/join">| 회원가입</RouterLink></div>
        <div class="mr-2"><RouterLink to="/vacationform">| 휴가신청</RouterLink></div>
        <div class="mr-20"><RouterLink to="/laboview">| 연구실</RouterLink></div>
      </div>
      <div class="absolute inset-0 bg-gradient-to-t from-blue-200 h-40">
        <img class="-z-30 h-40 w-full" src="../src/images/wbar_t.jpg" alt="" />
      </div>
    </div>
  </nav>

  <div class="m-5">
    <div class="h-24"></div>

    <RouterView />
    <!-- 사이드배너 -->
    <div class="" id="sidebann">
      <div>
        <SideBanner />
      </div>
    </div>
  </div>
</template>

<script setup>
import SideBanner from './component/SideBanner.vue'
</script>

<style lang="scss" scoped></style>
